package com.vixiloc.btstodolist.ui.screens.login

class LoginContract {

    data class State(
        val email: String = "",
        val password: String = ""
    )

    sealed class Event {
        data class ChangeInput(val data: String, val input: Int) : Event()
        data object Login : Event()
    }
}