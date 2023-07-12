package com.farshad.moviesAppCompose.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.uiCompose.comon.HeaderWithViewAll
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme

val image="https://m.media-amazon.com/images/M/MV5BMTQ5NTI4NDAxMV5BMl5BanBnXkFtZTcwMTQxNDY3Mw@@._V1_.jpg"

@Composable
fun DashboardScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RandomMovieImage(modifier = Modifier
                .padding(all = 6.dp)
                .weight(4f), imageUrl = image)

            HeaderWithViewAll(
                modifier = Modifier.weight(3f),
                title = stringResource(id = R.string.categories),
                onViewAllClick = {}
            )
        }

    }
}

@Composable
fun RandomMovieImage(
    modifier: Modifier= Modifier,
    imageUrl: String
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(130.dp)
        .shadow(elevation = 8.dp)
        .background(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.outline
        )
        .clip(MaterialTheme.shapes.medium)
        .border(
            width = 1.dp,
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primary
        )
        .drawWithCache {
            val gradient = Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Black),
                startY = size.height / 3,
                endY = size.height
            )
            onDrawWithContent {
                drawContent()
                drawRect(gradient, blendMode = BlendMode.Multiply)
            }
        }
        ,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(500)
                .error(R.drawable.ic_baseline_priority_high_24)
                .build(),
            placeholder = painterResource(id = R.drawable.place_holder) ,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}







@Preview(showBackground = true)
@Composable
private fun Preview(){
    AppTheme(darkTheme = false) {
        DashboardScreen()
    }
}