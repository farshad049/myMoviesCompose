package com.farshad.moviesAppCompose.ui.search.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.farshad.moviesAppCompose.epoxy.SearchHistoryEpoxyModel
import com.farshad.moviesAppCompose.data.db.Entity.SearchHistoryEntityWithoutId
import com.farshad.moviesAppCompose.epoxy.VerticalSpaceEpoxyModel
import com.farshad.moviesAppCompose.util.toPx

class SearchHistoryEpoxyController(
    private val onTitleClick : (Int) -> Unit,
    private val onCloseClick : (Int) -> Unit,
    private val onDeleteAllClick : () -> Unit
):TypedEpoxyController<List<SearchHistoryEntityWithoutId>>() {

    override fun buildModels(data: List<SearchHistoryEntityWithoutId>?) {

        if (data?.isNotEmpty() == true){
            DeleteAllEpoxyModel(onDeleteAllClick).id("delete_all").addTo(this)
            VerticalSpaceEpoxyModel(8.toPx()).id("delete_all_bottom_space").addTo(this)
        }

        data?.forEach {
            SearchHistoryEpoxyModel(it , onTitleClick , onCloseClick).id(it.movieId).addTo(this)
        }
    }

}
