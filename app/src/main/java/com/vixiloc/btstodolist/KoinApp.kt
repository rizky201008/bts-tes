package com.vixiloc.btstodolist

import android.app.Application
import com.vixiloc.btstodolist.di.retrofitModule
import com.vixiloc.btstodolist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinApp)
            modules(
                listOf(
                    retrofitModule, viewModelModule
                )
            )
        }
    }
}