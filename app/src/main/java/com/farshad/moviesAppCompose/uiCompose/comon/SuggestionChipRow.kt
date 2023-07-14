package com.farshad.moviesAppCompose.uiCompose.comon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.farshad.moviesAppCompose.data.model.network.GenresModel
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme
import com.farshad.moviesAppCompose.util.DarkAndLightPreview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.farshad.moviesAppCompose.util.SampleGenresModel

@Composable
fun SuggestionChipRow(
    modifier: Modifier= Modifier,
    genreChipList: List<GenresModel>,
    onClick: (Int)-> Unit
){
    val listForRow by remember { mutableStateOf(genreChipList) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
       items(
           items = listForRow, key = {it.hashCode()}
       ){item->
           ChipSuggestionItem(
               genreItem = item,
               onChipClick = {onClick(it)}
           )
       }
    }
}


@Composable
fun ChipSuggestionItem(
    genreItem: GenresModel,
    onChipClick: (Int)-> Unit
){
    SuggestionChip(
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            labelColor = MaterialTheme.colorScheme.onSurface
        ),
        border = null,
        label = { Text(text = genreItem.name) } ,
        onClick = { onChipClick(genreItem.id) },
    )
}



@DarkAndLightPreview
@Composable
private fun Preview(
    @PreviewParameter(SampleGenresModel::class) genreItem: GenresModel){
    AppTheme() {
        SuggestionChipRow(
            genreChipList = listOf(genreItem),
            onClick = {}
        )
    }
}