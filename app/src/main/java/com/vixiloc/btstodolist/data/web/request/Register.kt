package com.vixiloc.btstodolist.data.web.request


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)