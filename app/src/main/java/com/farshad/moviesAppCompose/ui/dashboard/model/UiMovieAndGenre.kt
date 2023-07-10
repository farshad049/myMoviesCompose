package com.farshad.moviesAppCompose.ui.dashboard.model

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.data.model.network.GenresModel

data class UiMovieAndGenre(
    val movie: List<DomainMovieModel>,
    val genre: List<GenresModel>
)
