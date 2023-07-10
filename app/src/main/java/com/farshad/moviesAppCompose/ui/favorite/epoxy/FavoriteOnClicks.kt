package com.farshad.moviesAppCompose.ui.favorite.epoxy

import androidx.navigation.NavController
import com.farshad.moviesAppCompose.NavGraphDirections
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.ui.favorite.FavoriteFragmentViewModel

class FavoriteOnClicks(
private val nanController: NavController,
private val viewModel: FavoriteFragmentViewModel
) {

    fun onMovieClick(movieId : Int){
        val directions= NavGraphDirections.actionGlobalToMovieDetailFragment(movieId)
        nanController.navigate(directions)
    }


    fun onCarouselItemClick(item: DomainMovieModel){
        viewModel.changeSelectedItem(item)
    }

    fun onDeleteMovieClick(movie: FavoriteMovieEntity){
        viewModel.deleteFavoriteMovie(movie)
    }
}