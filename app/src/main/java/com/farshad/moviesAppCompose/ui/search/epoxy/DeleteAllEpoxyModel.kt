package com.farshad.moviesAppCompose.ui.search.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelDeleteAllBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class DeleteAllEpoxyModel (
    val onDeleteAlClick : () -> Unit
        ): ViewBindingKotlinModel<ModelDeleteAllBinding>(R.layout.model_delete_all) {
    override fun ModelDeleteAllBinding.bind() {
        cardView.setOnClickListener { onDeleteAlClick() }
    }
}