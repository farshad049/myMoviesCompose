package com.farshad.moviesAppCompose.ui.filter

data class ModelDataForMovieList (
    val genreSetOfSelectedFilters : Set<String> = emptySet(),
    val imdbSetOfSelectedFilters : Set<String> = emptySet()
        )