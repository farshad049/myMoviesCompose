package com.farshad.moviesapp.model.ui

data class DataForMovieListEpoxy(
    val filteredByGenreList : IsExpandAndList,
    val filteredByImdbList : IsExpandAndList
)
{
    data class IsExpandAndList(
        val isExpand : Boolean ,
        val filterList : List<UiFilter>
    )
}
