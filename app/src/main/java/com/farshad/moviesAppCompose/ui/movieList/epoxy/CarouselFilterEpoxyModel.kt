package com.farshad.moviesAppCompose.ui.movieList.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelCaruselFilterBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class CarouselFilterEpoxyModel (
        val filterName : String,
        val onFilterDeleteClick : (String) -> Unit
        ): ViewBindingKotlinModel<ModelCaruselFilterBinding>(R.layout.model_carusel_filter) {
        override fun ModelCaruselFilterBinding.bind() {
                tvFilterName.text= filterName
                root.setOnClickListener { onFilterDeleteClick(filterName) }
        }
}