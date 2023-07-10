package com.farshad.moviesAppCompose.ui.favorite.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelEmptyFavoriteListBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

class EmptyFavoriteMovieListEpoxyModel
    : ViewBindingKotlinModel<ModelEmptyFavoriteListBinding>(R.layout.model_empty_favorite_list) {
    override fun ModelEmptyFavoriteListBinding.bind() {

    }
    //let this to take whole span count
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}