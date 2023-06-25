package com.example.food_app_compose.presentation.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_app_compose.domian.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    sealed class Event() {
        object LoginSuccess : Event()
        object LoginFail : Event()
    }

    private var _event = Channel<Event>(Channel.UNLIMITED)
    val event = _event.receiveAsFlow()


    fun checkCurrentUser() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.checkCurrentUser<FirebaseUser>().fold(onSuccess = {
                if (it != null) {
                    _event.send(Event.LoginSuccess)
                    Log.e(TU, "checkCurrentUser: Success")
                } else {
                    _event.send(Event.LoginFail)
                    Log.e(TU, "checkCurrentUser: Fail")
                }
            }, onFailure = {

            })

        }
    }
}