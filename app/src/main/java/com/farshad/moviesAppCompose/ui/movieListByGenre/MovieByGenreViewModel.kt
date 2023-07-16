package com.farshad.moviesAppCompose.ui.movieListByGenre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.farshad.moviesAppCompose.data.model.mapper.MovieMapper
import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.data.model.ui.Resource
import com.farshad.moviesAppCompose.data.remote.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieByGenreViewModel @Inject constructor(
    private val apiClient: ApiClient,
    private val movieMapper: MovieMapper
): ViewModel() {

    private val _allGenresMovieFlow= MutableStateFlow<List<GenresModel>>(emptyList())
    val allGenresMovieFlow = _allGenresMovieFlow.asStateFlow()

    private val _selectedFlow= MutableStateFlow<GenresModel>(GenresModel())
    val selectedFlow = _allGenresMovieFlow.asStateFlow()




    private var genreId:Int=0
    //every time pagingSource be called, this block of code will be run because every time user may type a new string to be searched
     var pagingSource: MovieByGenreDataSource? =null
        get() {
            if (field == null || field?.invalid == true){
                field = MovieByGenreDataSource(apiClient,movieMapper, genreId = genreId)
            }
            return field
        }

    val movieByGenreFlow = Pager(
        PagingConfig(
            pageSize = 10,
            prefetchDistance = 20,
            enablePlaceholders = false
        )
    ) { pagingSource!! }.flow.cachedIn(viewModelScope)



    fun submitQuery(genreIdFromFragment:Int){
        genreId= genreIdFromFragment
        pagingSource?.invalidate()
    }

}