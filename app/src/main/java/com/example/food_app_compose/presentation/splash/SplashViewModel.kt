package com.example.food_app_compose.presentation.splash

import androidx.lifecycle.viewModelScope
import com.example.food_app_compose.common.CCDispatcher
import com.example.food_app_compose.common.Dispatcher
import com.example.food_app_compose.common.success
import com.example.food_app_compose.domian.repository.AuthRepository
import com.example.food_app_compose.presentation.base.RootState
import com.example.food_app_compose.presentation.base.RootViewModel
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    @Dispatcher(CCDispatcher.IO) private val ioDispatcher: CoroutineDispatcher
): RootViewModel<RootState.ViewUiState, SplashOneTimeEvent, RootState.ViewEvent>() {
    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, _ ->
            sendEvent(SplashOneTimeEvent.LoginFail)
        }
    override val uiState: StateFlow<RootState.ViewUiState> = MutableStateFlow(RootState.ViewUiState.None)
    
    override fun onEvent(event: RootState.ViewEvent) {
        //noop
    }
    
    override fun reduceUiStateFromOneTimeEvent(
        uiState: RootState.ViewUiState,
        oneTimeEvent: SplashOneTimeEvent
    ) {
        //noop
    }
    
    fun checkCurrentUser() {
        viewModelScope.launch(ioDispatcher + coroutineExceptionHandler) {
            authRepository.getCurrentUser<FirebaseUser>()
                .success {
                    if (it != null) {
                        sendEvent(SplashOneTimeEvent.LoginSuccess)
                    } else {
                        sendEvent(SplashOneTimeEvent.LoginFail)
                    }
                }
        }
    }
    
}

sealed interface SplashOneTimeEvent: RootState.OneTimeEvent<RootState.ViewUiState> {
    
    override fun reduce(uiState: RootState.ViewUiState): RootState.ViewUiState =
        RootState.ViewUiState.None
    object LoginSuccess: SplashOneTimeEvent
    object LoginFail: SplashOneTimeEvent
}