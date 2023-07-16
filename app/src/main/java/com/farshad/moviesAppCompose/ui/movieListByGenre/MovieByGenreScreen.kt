package com.farshad.moviesAppCompose.ui.movieListByGenre

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.ui.dashboard.model.DashboardUiModel
import com.farshad.moviesAppCompose.ui.movieListByGenre.model.UiGenresModel
import com.farshad.moviesAppCompose.uiCompose.comon.MovieHorizontalLazyColumn
import com.farshad.moviesAppCompose.util.DarkAndLightPreview
import com.farshad.moviesAppCompose.util.SampleDomainMovieModel


@Composable
fun MovieByGenreScreen(
    modifier: Modifier = Modifier,
    genreList: UiGenresModel,
    movieList: List<DomainMovieModel>,
    onGenreClick: (GenresModel) -> Unit,
    onMovieClick: (Int) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column() {
            GenreFilterLazyRow(
                list = genreList.genreList,
                onClick = onGenreClick
            )

            MovieHorizontalLazyColumn(
                movieList = movieList,
                onRowClick = { onMovieClick(it) }
            )
        }
    }
}


//@DarkAndLightPreview
//@Composable
//private fun Preview(@PreviewParameter(SampleDomainMovieModel::class) movieAndGenre: DashboardUiModel) {
//    val a= UiGenresModel(
//        genreList = movieAndGenre.genre.map {
//             UiGenresModel.GenreWithFavorite(
//                 genre = it,isSelected = false
//            )
//        }
//    )
//    MovieByGenreScreen(
//        genreList = a,
//        movieList = movieAndGenre.movie,
//        onGenreClick ={},
//        onMovieClick ={}
//    )
//}

