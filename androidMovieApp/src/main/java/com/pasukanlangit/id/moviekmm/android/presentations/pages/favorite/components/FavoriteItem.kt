package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.components.AppImage
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.presentation.utils.ImageIMDB

@ExperimentalCoilApi
@Composable
fun FavoriteItem(
    item: ListItem,
    onItemClick: (Int) -> Unit
){
    Card(
        shape =  MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primaryVariant)
            .clickable {
                onItemClick(item.id)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
        ) {
            AppImage(
                url = ImageIMDB.getPosterSmall(item.poster),
                modifier = Modifier
                    .width(70.dp)
                    .fillMaxHeight(),
                contentDescription =  item.title
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(color = MaterialTheme.colors.primaryVariant)
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                Text(item.title, style = MaterialTheme.typography.h3.copy(color = Color.White), maxLines = 2, overflow = TextOverflow.Ellipsis)
                Text(item.genres, style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(item.desc, style = MaterialTheme.typography.subtitle2, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }
        }
    }
}