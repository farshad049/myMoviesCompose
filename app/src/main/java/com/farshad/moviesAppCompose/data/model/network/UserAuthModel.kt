package com.farshad.moviesAppCompose.data.model.network

data class UserAuthModel(
    val access_token: String = "",
    val expires_in: Int = 0,
    val refresh_token: String = "",
    val token_type: String = ""
)