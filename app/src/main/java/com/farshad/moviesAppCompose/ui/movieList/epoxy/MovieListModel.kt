package com.farshad.moviesAppCompose.ui.movieList.epoxy

import androidx.core.view.isGone
import androidx.core.view.isVisible
import coil.load
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelMovieListItemBinding
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

data class MovieListModel(
    val item: DomainMovieModel,
    val click: (Int) -> Unit
) : ViewBindingKotlinModel<ModelMovieListItemBinding>(R.layout.model_movie_list_item){
    override fun ModelMovieListItemBinding.bind() {
        progressImage.isVisible=true
        ivMovieCard.load(item.poster){
            listener { request, result ->
                progressImage.isGone=true
            }
        }
        tvTitle.text=item.title
        tvCountry.text=item.country
        tvIMDB.text=item.imdb_rating
        tvYear.text=item.year
        tvGenres.text=convertListToText(item.genres)

        root.setOnClickListener{click(item.id)}
    }




    private fun convertListToText(list : List<String>): String{
        val sb = StringBuilder()
        for (element in list) {
            sb.append(element).append(", ")
        }
        return sb.toString()
    }
}
