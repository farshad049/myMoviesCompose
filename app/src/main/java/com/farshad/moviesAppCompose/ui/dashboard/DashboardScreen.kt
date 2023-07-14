package com.farshad.moviesAppCompose.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.data.model.ui.Resource
import com.farshad.moviesAppCompose.ui.dashboard.model.DashboardUiModel
import com.farshad.moviesAppCompose.uiCompose.comon.HeaderWithViewAll
import com.farshad.moviesAppCompose.uiCompose.comon.ImageThumbnailRow
import com.farshad.moviesAppCompose.uiCompose.comon.LoadingAnimation
import com.farshad.moviesAppCompose.uiCompose.comon.SuggestionChipRow
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme
import com.farshad.moviesAppCompose.util.DarkAndLightPreview
import com.farshad.moviesAppCompose.util.SampleDomainMovieModel

@Composable
fun DashboardScreen(
    movieAndGenre: DashboardUiModel,
    onImageClick: (Int) -> Unit,
    onCategoryChipClick: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 8.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            DashboardImageThumbnailRow(
                modifier = Modifier.height(310.dp),
                movies = movieAndGenre.randomMovies,
                onClick = onImageClick
            )

            HeaderWithViewAll(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                title = stringResource(id = R.string.categories),
                onViewAllClick = {}
            )

            SuggestionChipRow(
                modifier = Modifier.padding(horizontal = 8.dp),
                genreChipList = movieAndGenre.genre,
                onClick = { onCategoryChipClick(it) }
            )

            HeaderWithViewAll(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                title = stringResource(id = R.string.top_rated_movies),
                onViewAllClick = {}
            )

            ImageThumbnailRow(
                movies = movieAndGenre.movie,
                onClick = {}
            )

        }

    }
}

@Composable
fun DashboardScreenWithViewModel(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
    val data by dashboardViewModel.combinedData.collectAsStateWithLifecycle(initialValue = Resource.Loading)

    when (data) {
        is Resource.Success -> {
//            DashboardScreen(
//                movieAndGenre = (data as Resource.Success<DashboardUiModel>).data,
//                onImageClick = {},
//                onCategoryChipClick = {}
//            )
            LoadingAnimation()
        }

        is Resource.Loading -> {
            LoadingAnimation()
        }
        else -> {}
    }

}


@DarkAndLightPreview
@Composable
private fun Preview(
    @PreviewParameter(SampleDomainMovieModel::class) movieAndGenre: DashboardUiModel
) {
    AppTheme() {
        DashboardScreen(
            movieAndGenre = movieAndGenre,
            onImageClick = {},
            onCategoryChipClick = {}
        )
    }
}