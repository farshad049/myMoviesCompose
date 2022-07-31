package com.example.moviesapp.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviesapp.model.domain.DomainMovieModel
import com.example.moviesapp.model.network.RegisterUserModel
import com.example.moviesapp.model.network.UploadMovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val movieDataSource: MovieDataSource,
) : ViewModel() {

    private val _movieByIdLiveData= MutableLiveData<DomainMovieModel?>()
    val movieByIdLiveData: LiveData<DomainMovieModel?> =_movieByIdLiveData

    private val _movieByGenreLiveData= MutableLiveData<List<DomainMovieModel?>>()
    val movieByGenreLiveData: LiveData<List<DomainMovieModel?>> = _movieByGenreLiveData

    private val _pushMovieLiveData= MutableLiveData<UploadMovieModel?>()
    val pushMovieLiveData: LiveData<UploadMovieModel?> = _pushMovieLiveData

    private val _registerUserLiveData= MutableLiveData<Any?>()
    val registerUserLiveData: LiveData<Any?> = _registerUserLiveData

    private val _loginUserLiveData= MutableLiveData<Any?>()
    val loginUserLiveData: LiveData<Any?> = _loginUserLiveData


    fun fetchMovie(movieId: Int){
        viewModelScope.launch {
            val response=repository.getMovieById(movieId)
            _movieByIdLiveData.postValue(response)
        }
    }

    fun  fetchMovieByGenre(genreId: Int){
        viewModelScope.launch {
            val response=repository.getMovieByGenre(genreId)
            _movieByGenreLiveData.postValue(response)
        }
    }

    fun pushMovie(movie:UploadMovieModel){
        viewModelScope.launch {
            val response=repository.pushMovie(movie)
            _pushMovieLiveData.postValue(response)
        }
    }

    fun registerUser(user:RegisterUserModel){
        viewModelScope.launch {
            val response=repository.registerUser(user)
            _registerUserLiveData.postValue(response)
        }
    }

    fun loginUser(email: RequestBody, password: RequestBody, grantType: RequestBody){
        viewModelScope.launch {
            val response=repository.loginUser(email,password,grantType)
            _loginUserLiveData.postValue(response)
        }
    }


    val movieListFlow = Pager(PagingConfig(
            pageSize = 20,
            prefetchDistance = 40,
            enablePlaceholders = false
        )
    ) { movieDataSource }.flow.cachedIn(viewModelScope)









}