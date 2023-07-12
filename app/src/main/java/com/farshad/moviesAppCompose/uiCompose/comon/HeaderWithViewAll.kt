package com.farshad.moviesAppCompose.uiCompose.comon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme

@Composable
fun HeaderWithViewAll(
    modifier: Modifier = Modifier,
    title: String,
    onViewAllClick: () -> Unit
){
    Box(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                modifier = Modifier.clickable { onViewAllClick() },
                text = stringResource(id = R.string.View_all),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview(){
    AppTheme() {
        HeaderWithViewAll(title = "action," ) {null}
    }
}