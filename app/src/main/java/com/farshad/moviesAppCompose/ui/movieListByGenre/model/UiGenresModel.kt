package com.farshad.moviesAppCompose.ui.movieListByGenre.model

import com.farshad.moviesAppCompose.data.model.network.GenresModel

data class UiGenresModel(
    val genre :GenresModel,
    val isSelected: Boolean
)
