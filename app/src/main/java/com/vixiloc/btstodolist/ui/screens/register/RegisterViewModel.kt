package com.vixiloc.btstodolist.ui.screens.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixiloc.btstodolist.data.ApiService
import com.vixiloc.btstodolist.data.web.request.Register
import com.vixiloc.btstodolist.handler.HttpHandler
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class RegisterViewModel(private val apiService: ApiService) : ViewModel() {

    private val httpHandler = HttpHandler()

    private val _state = mutableStateOf(RegisterContract.State())
    val state: State<RegisterContract.State> = _state

    fun onEvent(event: RegisterContract.Event) {
        when (event) {
            is RegisterContract.Event.ChangeInput -> {
                when (event.input) {
                    0 -> {
                        _state.value = state.value.copy(email = event.data)
                    }

                    1 -> {
                        _state.value = state.value.copy(password = event.data)
                    }

                    2 -> {
                        _state.value = state.value.copy(userName = event.data)
                    }
                }
            }

            RegisterContract.Event.Register -> register()
            is RegisterContract.Event.ShowMessage -> {
                _state.value = state.value.copy(
                    message = event.message
                )
            }
        }
    }

    private fun register() {
        val data = Register(
            email = state.value.email,
            password = state.value.password,
            username = state.value.userName
        )
        _state.value = state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                val response = apiService.register(data)
                _state.value = state.value.copy(
                    isLoading = false,
                    message = response.message
                )
            } catch (exception: HttpException) {
                val errorMessage = httpHandler.handleHttpException(exception)
                _state.value = state.value.copy(
                    isLoading = false,
                    message = errorMessage
                )
            } catch (exception: IOException) {
                _state.value = state.value.copy(
                    isLoading = false,
                    message = "An unexpected error occurred"
                )
            }
        }
    }
}