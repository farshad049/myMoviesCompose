package com.farshad.moviesAppCompose.ui.filter.model

data class FilterByImdbInfo(
   val imdbRate : Set<String>  = setOf(),
   val selectedImdbRate : Set<String> = emptySet()
)
