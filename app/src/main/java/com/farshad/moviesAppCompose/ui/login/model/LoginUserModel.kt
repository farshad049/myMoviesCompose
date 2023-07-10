package com.farshad.moviesAppCompose.ui.login.model

data class LoginUserModel(
    val userName: TextFieldStatusModel = TextFieldStatusModel.Success(),
    val password : TextFieldStatusModel = TextFieldStatusModel.Success(),
)
