package com.farshad.moviesAppCompose.uiCompose.comon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.data.db.Entity.FavoriteMovieEntity
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.ui.movieDetail.model.UiMovieDetailModel
import com.farshad.moviesAppCompose.uiCompose.comon.model.UiModelMovieWithFavorite
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme
import com.farshad.moviesAppCompose.uiCompose.theme.myRed
import com.farshad.moviesAppCompose.uiCompose.theme.myYellow
import com.farshad.moviesAppCompose.util.Convertors
import com.farshad.moviesAppCompose.util.DarkAndLightPreview
import com.farshad.moviesAppCompose.util.SampleDomainMovieModel


@Composable
fun MovieHorizontalItem(
    modifier: Modifier = Modifier,
    movieWithFavorite: UiModelMovieWithFavorite,
    onRowClick: (Int)-> Unit,
    onFavoriteClick: (FavoriteMovieEntity)-> Unit
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .shadow(elevation = 3.dp, spotColor = MaterialTheme.colorScheme.onBackground)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium
            )
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onRowClick(movieWithFavorite.movie.id) }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxSize().weight(1.1f)) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movieWithFavorite.movie.poster)
                        .crossfade(500)
                        .error(R.drawable.ic_baseline_priority_high_24)
                        .build(),
                    placeholder = painterResource(id = R.drawable.place_holder) ,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Column(modifier= Modifier.weight(3f)) {
                Text(
                    text = movieWithFavorite.movie.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                        fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = Convertors().convertListToText(movieWithFavorite.movie.genres),
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    IconButton(
                        onClick = { onFavoriteClick(FavoriteMovieEntity(id = movieWithFavorite.movie.id, title = movieWithFavorite.movie.title)) }
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = if (movieWithFavorite.isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                            tint = myRed,
                            contentDescription =""
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        tint = myYellow,
                        contentDescription =""
                    )
                    Text(
                        text = movieWithFavorite.movie.imdb_rating,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.round_access_time_24),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                        contentDescription =""
                    )
                    Text(
                        text = movieWithFavorite.movie.runTime,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                }
            }
        }

    }

}





@DarkAndLightPreview
@Composable
private fun Preview(@PreviewParameter(SampleDomainMovieModel::class) movie: DomainMovieModel){
    AppTheme() {
        MovieHorizontalItem(
            movieWithFavorite = UiModelMovieWithFavorite(movie = movie, isFavorite = true),
            onRowClick = {},
            onFavoriteClick = {}
        )
    }

}