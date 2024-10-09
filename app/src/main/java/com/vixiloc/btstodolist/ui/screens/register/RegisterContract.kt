package com.vixiloc.btstodolist.ui.screens.register

class RegisterContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val userName: String = "",
        val message: String = "",
        val isLoading: Boolean = false
    )

    sealed class Event {
        data class ChangeInput(val data: String, val input: Int) : Event()
        data object Register : Event()
        data class ShowMessage(val message: String) : Event()
    }
}