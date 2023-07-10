package com.farshad.moviesAppCompose.ui.dashboard.epoxy

import androidx.navigation.NavController
import com.farshad.moviesAppCompose.NavGraphDirections
import com.farshad.moviesAppCompose.ui.dashboard.DashboardFragmentDirections

class DashboardOnClicks(private val navController: NavController) {

    fun onGenreClick(genreId: Int,genreName:String){
        val directions= DashboardFragmentDirections.actionDashboardFragmentToMovieListByGenre(genreId,genreName)
        navController.navigate(directions)
    }

    fun onMovieClick(movieId:Int){
        val directions= NavGraphDirections.actionGlobalToMovieDetailFragment(movieId)
        navController.navigate(directions)
    }
}