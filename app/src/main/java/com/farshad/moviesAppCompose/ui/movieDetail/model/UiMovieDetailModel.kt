package com.farshad.moviesAppCompose.ui.movieDetail.model

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel

data class UiMovieDetailModel (
    val movie : DomainMovieModel? = null,
    val isFavorite : Boolean = false,
    val similarMovies : List<DomainMovieModel> = emptyList()
        )