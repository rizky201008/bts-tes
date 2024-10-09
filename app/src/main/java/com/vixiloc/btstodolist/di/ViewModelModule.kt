package com.vixiloc.btstodolist.di

import com.vixiloc.btstodolist.ui.screens.login.LoginViewModel
import com.vixiloc.btstodolist.ui.screens.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        RegisterViewModel(get())
    }
    viewModel {
        LoginViewModel()
    }
}