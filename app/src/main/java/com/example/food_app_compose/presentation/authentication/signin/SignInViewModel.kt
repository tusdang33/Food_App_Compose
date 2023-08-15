package com.example.food_app_compose.presentation.authentication.signin

import androidx.lifecycle.viewModelScope
import com.example.food_app_compose.common.CCDispatcher
import com.example.food_app_compose.common.Dispatcher
import com.example.food_app_compose.common.fail
import com.example.food_app_compose.common.success
import com.example.food_app_compose.domian.repository.AuthRepository
import com.example.food_app_compose.presentation.base.RootState
import com.example.food_app_compose.presentation.base.RootViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
	private val authRepository: AuthRepository,
	@Dispatcher(CCDispatcher.IO) private val ioDispatcher: CoroutineDispatcher
): RootViewModel<SignInUiState, SignInOneTimeEvent, SignInEvent>() {
	override val coroutineExceptionHandler: CoroutineExceptionHandler
		get() = CoroutineExceptionHandler { _, exception ->
			sendEvent(SignInOneTimeEvent.Fail(exception.message))
		}
	
	private val _signInUiState = MutableStateFlow(SignInUiState())
	override val uiState: StateFlow<SignInUiState> = _signInUiState.asStateFlow()
	
	override fun reduceUiStateFromOneTimeEvent(
		uiState: SignInUiState,
		oneTimeEvent: SignInOneTimeEvent
	) {
		_signInUiState.value = uiState
	}
	
	override fun onEvent(event: SignInEvent) {
		when (event) {
			is SignInEvent.OnEmailChange -> {
				_signInUiState.update {
					it.copy(
						email = event.email
					)
				}
			}
			
			is SignInEvent.OnPasswordChange -> {
				_signInUiState.update {
					it.copy(
						password = event.password
					)
				}
			}
			
			is SignInEvent.OnPasswordVisibleChange -> {
				_signInUiState.update {
					it.copy(
						isPasswordVisible = event.visible
					)
				}
			}
			
			is SignInEvent.OnLogin -> login()
		}
	}
	
	private fun login() {
		viewModelScope.launch(ioDispatcher + coroutineExceptionHandler) {
			sendEvent(SignInOneTimeEvent.Loading)
			authRepository.login(_signInUiState.value.email, _signInUiState.value.password)
				.success {
					sendEvent(SignInOneTimeEvent.Success)
				}
				.fail {
					sendEvent(SignInOneTimeEvent.Fail(it))
				}
		}
	}
}

data class SignInUiState(
	val email: String = "",
	val password: String = "",
	val isPasswordVisible: Boolean = false,
	override val isLoading: Boolean = false,
	override val errorMessage: String = "",
): RootState.ViewUiState

sealed interface SignInOneTimeEvent: RootState.OneTimeEvent<SignInUiState> {
	override fun reduce(uiState: SignInUiState): SignInUiState {
		return when (this) {
			is Fail -> uiState.copy(
				isLoading = false,
				errorMessage = checkNotNull(errorMessage)
			)
			
			is Loading -> uiState.copy(
				isLoading = true,
				errorMessage = ""
			)
			
			is Success -> uiState.copy(
				isLoading = false,
				errorMessage = ""
			)
		}
	}
	
	object Loading: SignInOneTimeEvent
	object Success: SignInOneTimeEvent
	data class Fail(val errorMessage: String?): SignInOneTimeEvent
}

sealed class SignInEvent: RootState.ViewEvent {
	data class OnEmailChange(val email: String): SignInEvent()
	data class OnPasswordChange(val password: String): SignInEvent()
	data class OnPasswordVisibleChange(val visible: Boolean): SignInEvent()
	object OnLogin: SignInEvent()
}