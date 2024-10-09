package com.vixiloc.btstodolist.di

import com.vixiloc.btstodolist.data.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {
    single {
        provideApiService(provideClient())
    }
}

fun provideApiService(client: OkHttpClient): ApiService {
    return Retrofit.Builder()
        .baseUrl("http://94.74.86.174:8080/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}

fun provideClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()
}