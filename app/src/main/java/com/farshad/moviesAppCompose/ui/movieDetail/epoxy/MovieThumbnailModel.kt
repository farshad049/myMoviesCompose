package com.farshad.moviesAppCompose.ui.movieDetail.epoxy

import androidx.core.view.isGone
import androidx.core.view.isVisible
import coil.load
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelMovieThumbnailBinding

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class MovieThumbnailModel(
    val item: DomainMovieModel,
    val onclick:(Int)->Unit
)
    : ViewBindingKotlinModel<ModelMovieThumbnailBinding>(R.layout.model_movie_thumbnail){
    override fun ModelMovieThumbnailBinding.bind(){
        progressImage.isVisible=true
        ivMovie.load(item.poster){
            listener { request, result ->
                progressImage.isGone=true
            }
        }
        root.setOnClickListener { onclick(item.id) }
    }
}