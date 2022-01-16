package com.pasukanlangit.id.moviekmm.android.presentations.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.presentation.utils.ImageIMDB

@ExperimentalCoilApi
@Composable
fun ListItem(
    item: ListItem,
    onItemClick: (id: Int) -> Unit
){
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .padding(start = 8.dp)
            .clickable {
                onItemClick(item.id)
            },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AppImage(
            url = ImageIMDB.getPosterMedium(item.poster),
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentDescription = item.title
        )
        Text(
            item.title,
            style = MaterialTheme.typography.subtitle2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
        )
    }
}