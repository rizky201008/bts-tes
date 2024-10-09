package com.vixiloc.btstodolist.ui.screens.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vixiloc.btstodolist.ui.screens.login.LoginScreen
import com.vixiloc.btstodolist.ui.screens.register.RegisterScreen
import kotlinx.serialization.Serializable

sealed interface MainRoutes {
    @Serializable
    data object LoginScreen : MainRoutes

    @Serializable
    data object RegisterScreen : MainRoutes
}

@Composable
fun MainNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainRoutes.LoginScreen) {
        composable<MainRoutes.LoginScreen> {
            LoginScreen(navHostController = navHostController)
        }
        composable<MainRoutes.RegisterScreen> {
            RegisterScreen(navHostController = navHostController)
        }
    }
}