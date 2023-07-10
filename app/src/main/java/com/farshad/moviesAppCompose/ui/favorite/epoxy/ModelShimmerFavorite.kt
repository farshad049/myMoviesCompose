package com.farshad.moviesAppCompose.ui.favorite.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelFavoriteShimmerBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

 class ModelShimmerFavorite
     : ViewBindingKotlinModel<ModelFavoriteShimmerBinding>(R.layout.model_favorite_shimmer){
    override fun ModelFavoriteShimmerBinding.bind() {
        shimmerLayout.startShimmer()
    }

}
