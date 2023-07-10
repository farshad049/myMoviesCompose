package com.farshad.moviesAppCompose.ui.filter.model

data class FilterByGenreInfo (
        val genres: Set<String> = setOf(),
        var selectedGenres: Set<String> = emptySet()
)