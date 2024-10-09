package com.vixiloc.btstodolist.ui.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _state = mutableStateOf(LoginContract.State())
    val state: State<LoginContract.State> = _state

    fun onEvent(event: LoginContract.Event) {
        when (event) {
            is LoginContract.Event.ChangeInput -> {
                when (event.input) {
                    0 -> {
                        _state.value = state.value.copy(email = event.data)
                    }

                    1 -> {
                        _state.value = state.value.copy(password = event.data)
                    }
                }
            }

            LoginContract.Event.Login -> TODO()
        }
    }
}