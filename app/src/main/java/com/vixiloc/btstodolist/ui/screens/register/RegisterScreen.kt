package com.vixiloc.btstodolist.ui.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val viewModel: RegisterViewModel = koinViewModel()
    val state = viewModel.state.value
    val onEvent = viewModel::onEvent

    Scaffold(modifier = modifier) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Sign up", style = MaterialTheme.typography.titleMedium)
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .height(300.dp)
                    .padding(10.dp)
            ) {
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    onValueChange = { onEvent(RegisterContract.Event.ChangeInput(it, 0)) },
                    placeholder = { Text(text = "Email") })
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = {
                        onEvent(RegisterContract.Event.ChangeInput(it, 1))
                    },
                    placeholder = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation()
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.userName,
                    onValueChange = {
                        onEvent(RegisterContract.Event.ChangeInput(it, 2))
                    },
                    placeholder = { Text(text = "Username") })

                if (state.isLoading) {
                    CircularProgressIndicator()
                }

                Button(
                    onClick = { onEvent(RegisterContract.Event.Register) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Sign up")
                }
                TextButton(onClick = { navHostController.navigateUp() }) {
                    Text(
                        text = "Login",
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (state.message.isNotBlank()) {
                    Text(
                        text = state.message,
                        style = TextStyle(color = MaterialTheme.colorScheme.error)
                    )
                }
            }
        }
    }
}