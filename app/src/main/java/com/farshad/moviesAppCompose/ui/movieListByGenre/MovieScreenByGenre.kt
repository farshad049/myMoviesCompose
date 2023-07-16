package com.farshad.moviesAppCompose.ui.movieListByGenre

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.ui.movieListByGenre.model.UiGenresModel


@Composable
fun MovieScreenByGenre(
    modifier: Modifier= Modifier,
    genreList: List<UiGenresModel>,
    onGenreClick: (GenresModel)->Unit
){
    Box(
        modifier= modifier.fillMaxSize()
    ) {
        Column() {
            GenreTabRow(
                genreList = genreList,
                onClick = onGenreClick
            )
        }
    }

}

