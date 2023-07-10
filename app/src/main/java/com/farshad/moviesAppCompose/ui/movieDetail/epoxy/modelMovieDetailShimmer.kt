package com.farshad.moviesAppCompose.ui.movieDetail.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelMovieDetailShimmerBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

class modelMovieDetailShimmer: ViewBindingKotlinModel<ModelMovieDetailShimmerBinding>(R.layout.model_movie_detail_shimmer){
    override fun ModelMovieDetailShimmerBinding.bind() {
        shimmerLayout.startShimmer()
    }

}