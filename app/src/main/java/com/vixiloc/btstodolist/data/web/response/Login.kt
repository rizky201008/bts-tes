package com.vixiloc.btstodolist.data.web.response

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("errorMessage")
    val errorMessage: String?,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)

data class Data(
    @SerializedName("token")
    val token: String
)