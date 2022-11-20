package com.farshad.moviesapp.ui.submitMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farshad.moviesapp.data.model.ui.SubmitFieldValidationModel
import com.farshad.moviesapp.data.model.ui.SubmitResponseModel
import com.farshad.moviesapp.data.model.ui.TextFieldStatusModel
import com.farshad.moviesapp.data.repository.SubmitMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class SubmitMultipartViewModel @Inject constructor(
    private val repository: SubmitMovieRepository
):ViewModel() {

    private val eventChannel = Channel<SubmitResponseModel>()
    val submitFlow = eventChannel.receiveAsFlow()


    private val _validationMutableLiveData= MutableStateFlow<SubmitFieldValidationModel>(SubmitFieldValidationModel())
    val validationLiveData: StateFlow<SubmitFieldValidationModel> = _validationMutableLiveData

//    private val _submitMovieMultipartLiveData= MutableLiveData<UploadMovieModel?>()
//    val pushMovieMultipartLiveData: LiveData<UploadMovieModel?> = _submitMovieMultipartLiveData



    fun pushMovieMultipart(
        poster: MultipartBody.Part?,
        title: String,
        imdb_id: String,
        country: String,
        year: String
    ){
        viewModelScope.launch {
            val response=repository.pushMovieMultipart(poster,title,imdb_id,country,year)
            //_submitMovieMultipartLiveData.postValue(response)
            eventChannel.send(response)
        }
    }




    fun validate(
        title : String,
        imdb_id : String,
        country : String,
        year : String ,
        poster : MultipartBody.Part?
    ){

        val titleB = title.trim()
        val imdbIdB = imdb_id.trim()
        val countryB = country.trim()
        val yearB = year.trim()

        when{
            titleB.isEmpty() -> {
                _validationMutableLiveData.value=
                    SubmitFieldValidationModel(
                        title = TextFieldStatusModel.Error("* please enter a valid title")
                    )
            }
            imdbIdB.isEmpty() -> {
                _validationMutableLiveData.value=
                    SubmitFieldValidationModel(
                        imdbId = TextFieldStatusModel.Error("* please enter a valid IMDB ID")
                    )
            }
            countryB.isEmpty() -> {
                _validationMutableLiveData.value =
                    SubmitFieldValidationModel(
                        country = TextFieldStatusModel.Error("* please enter a valid country name")
                    )
            }
            yearB.isEmpty() && year.length < 4 -> {
                _validationMutableLiveData.value=
                    SubmitFieldValidationModel(
                        year = TextFieldStatusModel.Error("* please enter a valid year")
                    )
            }else ->{
            _validationMutableLiveData.value = SubmitFieldValidationModel(
                title = TextFieldStatusModel.Success(),
                imdbId = TextFieldStatusModel.Success(),
                country = TextFieldStatusModel.Success(),
                year  = TextFieldStatusModel.Success(),
                poster  = TextFieldStatusModel.Success()
            )


            pushMovieMultipart(
                    title = titleB,
                    imdb_id = imdbIdB ,
                    country = countryB ,
                    year = yearB,
                    poster = poster
            )

        }
        }

    }





}