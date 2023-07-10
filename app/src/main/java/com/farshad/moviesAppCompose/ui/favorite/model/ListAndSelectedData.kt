package com.farshad.moviesAppCompose.ui.favorite.model

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel

data class ListAndSelectedData(
    val list:List<DomainMovieModel>,
    val selectedItem: DomainMovieModel
)
