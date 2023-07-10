package com.farshad.moviesAppCompose.ui.favorite.epoxy

import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.databinding.ModelFavoriteFooterBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.util.Convertors

data class FavoriteFooterModel(
    val movie: DomainMovieModel,
    val onClick: (movieEntity: FavoriteMovieEntity) -> Unit
): ViewBindingKotlinModel<ModelFavoriteFooterBinding>(R.layout.model_favorite_footer){

    override fun ModelFavoriteFooterBinding.bind() {
        tvTITLE.text= movie.title
        tvIMDB.text= movie.imdb_rating
        tvYEAR.text= movie.year
        tvRATE.text= movie.rated
        tvGENRE.text= Convertors().convertListToText(movie.genres)
        tvDIRECTOR.text= movie.director
        btnRemove.setOnClickListener {
            onClick(FavoriteMovieEntity(id = movie.id, title = movie.title))
        }

    }

}
