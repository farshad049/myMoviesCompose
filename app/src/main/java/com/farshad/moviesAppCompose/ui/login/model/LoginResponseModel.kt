package com.farshad.moviesAppCompose.ui.login.model

import com.farshad.moviesAppCompose.data.model.network.UserAuthModel


sealed interface LoginResponseModel {
    data class Success(val data: UserAuthModel) : LoginResponseModel
    data class Error(val error: String) : LoginResponseModel
    object Loading : LoginResponseModel
}



