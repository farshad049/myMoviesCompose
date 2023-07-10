package com.farshad.moviesAppCompose.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelSearchHistoryBinding
import com.farshad.moviesAppCompose.data.db.Entity.SearchHistoryEntityWithoutId


data class SearchHistoryEpoxyModel(
    val movie : SearchHistoryEntityWithoutId,
    val onTitleClick : (Int) -> Unit,
    val onCloseClick : (Int) -> Unit
): ViewBindingKotlinModel<ModelSearchHistoryBinding>(R.layout.model_search_history) {
    override fun ModelSearchHistoryBinding.bind() {
        tvMovieTitle.text = movie.movieTitle
        tvMovieTitle.setOnClickListener { onTitleClick(movie.movieId) }
        ivClose.setOnClickListener { onCloseClick(movie.movieId) }
    }
}