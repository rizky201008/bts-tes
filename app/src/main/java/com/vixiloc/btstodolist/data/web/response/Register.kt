package com.vixiloc.btstodolist.data.web.response


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("data")
    val `data`: Any?,
    @SerializedName("errorMessage")
    val errorMessage: Any?,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)