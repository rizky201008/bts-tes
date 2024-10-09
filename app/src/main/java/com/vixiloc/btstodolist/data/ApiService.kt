package com.vixiloc.btstodolist.data

import retrofit2.http.Body
import com.vixiloc.btstodolist.data.web.response.Register as ResponseRegister
import com.vixiloc.btstodolist.data.web.request.Register as RequestRegister
import com.vixiloc.btstodolist.data.web.response.Login as ResponseLogin
import com.vixiloc.btstodolist.data.web.request.Login as RequestLogin
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    suspend fun register(@Body data: RequestRegister): ResponseRegister

    @POST("login")
    suspend fun login(@Body data: RequestLogin): ResponseLogin

}