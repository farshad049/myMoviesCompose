package com.farshad.moviesAppCompose.ui.userInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farshad.moviesAppCompose.data.model.network.UserRegisteredModel
import com.farshad.moviesAppCompose.data.model.ui.Resource
import com.farshad.moviesAppCompose.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val repository: UserRepository
):ViewModel() {

    init {
        getUserInfo()
    }


    private val _userInfoFlow = MutableStateFlow<Resource<UserRegisteredModel>>(Resource.Loading)
    val userInfoFlow= _userInfoFlow.asStateFlow()



    private fun getUserInfo(){
        viewModelScope.launch {
            val response= repository.getUserInfo()
            if (response != null) _userInfoFlow.emit(Resource.Success(response))
        }
    }



}