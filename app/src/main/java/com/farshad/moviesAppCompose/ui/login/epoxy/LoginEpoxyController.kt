package com.farshad.moviesAppCompose.ui.login.epoxy

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.farshad.moviesAppCompose.ui.login.LoginViewModel
import com.farshad.moviesAppCompose.ui.login.model.LoginResponseModel


class LoginEpoxyController(
    private val context: Context,
    private val viewModel : LoginViewModel
) : TypedEpoxyController<LoginResponseModel>() {

    override fun buildModels(data: LoginResponseModel) {

//        ModelLoginBottom(
//            context = context ,
//            onLogin = {username , password ->
//                viewModel.loginUser(username , password)
//            }
//        ).id(UUID.randomUUID().toString()).addTo(this)
//
//
//        if (data is LoginResponseModel.Error){
//            Toast.makeText(context, data.error,Toast.LENGTH_SHORT).show()
//        }
//
//        if (data is LoginResponseModel.Success){
//            context.startActivity(Intent(context , MainActivity::class.java))
//            Toast.makeText(context, R.string.you_are_logged_in,Toast.LENGTH_SHORT).show()
//        }
    }



}