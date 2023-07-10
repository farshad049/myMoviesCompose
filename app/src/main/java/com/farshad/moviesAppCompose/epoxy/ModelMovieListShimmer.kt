package com.farshad.moviesAppCompose.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelMovieListShimmerBinding

class ModelMovieListShimmer
    : ViewBindingKotlinModel<ModelMovieListShimmerBinding>(R.layout.model_movie_list_shimmer){
    override fun ModelMovieListShimmerBinding.bind() {
        shimmerLayout.startShimmer()
    }
}