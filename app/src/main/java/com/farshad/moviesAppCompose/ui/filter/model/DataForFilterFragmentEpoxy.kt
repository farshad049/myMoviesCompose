package com.farshad.moviesAppCompose.ui.filter.model

data class DataForFilterFragmentEpoxy(
    val filteredByGenreList : IsExpandAndList,
    val filteredByImdbList : IsExpandAndList
)
{
    data class IsExpandAndList(
        val isExpand : Boolean ,
        val filterList : List<UiFilter>
    )
}
