package com.farshad.moviesAppCompose.ui.movieListByGenre

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.ui.movieListByGenre.model.UiGenresModel
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme
import com.farshad.moviesAppCompose.util.DarkAndLightPreview


@Composable
fun GenreFilterLazyRow(
    modifier: Modifier= Modifier,
    list: List<UiGenresModel.GenreWithFavorite>,
    onClick: (Int)-> Unit
){
    val listForRow by remember { mutableStateOf(list) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(
            items = listForRow, key = {it.hashCode()}
        ){item->
            GenreFilterItem(
                uiGenresModel = item,
                onClick = {onClick(it)}
                )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreFilterItem(
    uiGenresModel: UiGenresModel.GenreWithFavorite,
    onClick: (Int) -> Unit
){
    FilterChip(
        selected = uiGenresModel.isSelected,
        onClick = {onClick(uiGenresModel.genre.id)},
        label = { Text(text = uiGenresModel.genre.name)},
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            labelColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    )

}







@DarkAndLightPreview
@Composable
private fun Preview(){
    AppTheme() {
        Column() {
            GenreFilterItem(
                uiGenresModel = UiGenresModel.GenreWithFavorite(genre = GenresModel(id = 1, name = "comedy"),isSelected = false),
                onClick = {}
            )

        }
    }
}