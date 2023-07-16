package com.farshad.moviesAppCompose.uiCompose.comon.model

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel

data class UiModelMovieWithFavorite(
    val movie : DomainMovieModel,
    val isFavorite : Boolean
)
