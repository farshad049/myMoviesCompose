package com.farshad.moviesAppCompose.ui.movieDetail.epoxy

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import coil.load
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.databinding.ModelDetailFragmentUpBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel
import com.farshad.moviesAppCompose.ui.favorite.FavoriteFragmentViewModel
import com.farshad.moviesAppCompose.util.Convertors
import kotlinx.coroutines.launch

data class MovieDetailUpEpoxyModel (
    val context : Context,
    val uiModel : DomainMovieModel,
    val favoriteFragmentViewModel : FavoriteFragmentViewModel,
    val isFavorite : Boolean
        ): ViewBindingKotlinModel<ModelDetailFragmentUpBinding>(R.layout.model_detail_fragment_up) {
    override fun ModelDetailFragmentUpBinding.bind() {

        progressOnPoster.isVisible=true
        ivMovie.load(uiModel.poster){
            listener { request, result ->
                progressOnPoster.isGone=true
            }
        }

        tvMovieName.text= uiModel.title
        tvIMDB.text= uiModel.imdb_rating
        tvYear.text= uiModel.year
        tvRate.text= uiModel.rated
        tvCountry.text= uiModel.country
        tvDirector.text= uiModel.director
        tvGenres.text= Convertors().convertListToText(uiModel.genres)
        tvActors.text= uiModel.actors
        tvPlot.text= uiModel.plot

        val imageRes=if (isFavorite) R.drawable.ic_round_favorite_24 else R.drawable.ic_round_favorite_border_24

        favoriteImage.load(imageRes)

                favoriteImage.setOnClickListener {
                    favoriteFragmentViewModel.viewModelScope.launch {
                        if (isFavorite){
                            favoriteFragmentViewModel.deleteFavoriteMovie(
                                FavoriteMovieEntity(
                                    id = uiModel.id ,
                                    title = uiModel.title
                                )
                            )
                        }else{
                            favoriteFragmentViewModel.insertFavoriteMovie(
                                FavoriteMovieEntity(
                                    id = uiModel.id,
                                    title = uiModel.title
                                )
                            )
                        }
                    }

        }

        btnShare.setOnClickListener {
            val dataToShare = "https://moviesapi.ir/api/v1/movies/${uiModel.id}"
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hey Check out this Great app:")
            intent.putExtra(Intent.EXTRA_TEXT, dataToShare)
            startActivity(context , Intent.createChooser(intent,"Share To:") , null)
        }

    }











}