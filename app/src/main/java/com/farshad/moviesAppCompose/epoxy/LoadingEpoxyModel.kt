package com.farshad.moviesAppCompose.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelLoadingBinding


class LoadingEpoxyModel : ViewBindingKotlinModel<ModelLoadingBinding>(R.layout.model_loading) {
    override fun ModelLoadingBinding.bind() {
        // nothing to do
    }
    //let this to take whole span count
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}