package com.farshad.moviesAppCompose.ui.filter.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelFilterBinding
import com.farshad.moviesAppCompose.ui.filter.model.UiFilter
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class FilterEpoxyModel(
    val uiFilter: UiFilter,
    val onFilterClick:(String) -> Unit
    )
    : ViewBindingKotlinModel<ModelFilterBinding>(R.layout.model_filter){
    override fun ModelFilterBinding.bind() {

        tvFilterName.text=uiFilter.filterDisplayName
        root.setOnClickListener { onFilterClick(uiFilter.filterDisplayName) }
        //checkbox.isClickable=false
        checkbox.isChecked = uiFilter.isSelected
    }

}
