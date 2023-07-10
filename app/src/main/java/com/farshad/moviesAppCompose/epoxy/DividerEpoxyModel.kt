package com.farshad.moviesAppCompose.epoxy

import android.view.ViewGroup
import androidx.annotation.Dimension
import androidx.annotation.Dimension.Companion.PX
import androidx.core.view.updateLayoutParams
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelDividerBinding


data class DividerEpoxyModel(
    @Dimension(unit = PX) private val horizontalMargin: Int = 0,
    @Dimension(unit = PX) private val verticalMargin: Int = 0
) : ViewBindingKotlinModel<ModelDividerBinding>(R.layout.model_divider) {

    override fun ModelDividerBinding.bind() {
        root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            setMargins(
                horizontalMargin,
                verticalMargin,
                horizontalMargin,
                verticalMargin
            )
        }
    }
}