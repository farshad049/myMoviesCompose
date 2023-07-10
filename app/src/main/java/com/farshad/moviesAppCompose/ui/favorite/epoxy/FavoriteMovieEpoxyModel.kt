package com.farshad.moviesAppCompose.ui.favorite.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelFavoriteMovieBinding
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class FavoriteMovieEpoxyModel(
    val movie : FavoriteMovieEntity,
    val onClick : (Int) -> Unit
): ViewBindingKotlinModel<ModelFavoriteMovieBinding>(R.layout.model_favorite_movie) {
    override fun ModelFavoriteMovieBinding.bind() {
        tvMovieTitle.text = movie.title
        root.setOnClickListener { onClick(movie.id) }
    }
}