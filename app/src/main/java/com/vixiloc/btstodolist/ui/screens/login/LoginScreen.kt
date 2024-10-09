package com.vixiloc.btstodolist.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vixiloc.btstodolist.ui.screens.navhost.MainRoutes
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val viewModel: LoginViewModel = koinViewModel()
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
                verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .height(300.dp)
                    .padding(10.dp)
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    onValueChange = { onEvent(LoginContract.Event.ChangeInput(it, 0)) },
                    placeholder = { Text(text = "Email") })
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = {
                        onEvent(LoginContract.Event.ChangeInput(it, 1))
                    },
                    placeholder = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onEvent(LoginContract.Event.Login) }) {
                    Text(text = "Sign in")
                }
                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    navHostController.navigate(MainRoutes.RegisterScreen)
                }) {
                    Text(text = "Sign up")
                }

            }
        }
    }
}