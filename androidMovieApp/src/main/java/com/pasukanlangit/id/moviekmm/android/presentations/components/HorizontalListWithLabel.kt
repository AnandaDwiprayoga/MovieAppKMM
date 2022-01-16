package com.pasukanlangit.id.moviekmm.android.presentations.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingHorizontal
import com.pasukanlangit.id.moviekmm.domain.model.ListItem

@ExperimentalCoilApi
@Composable
fun HorizontalListWithLabel(
    label: String,
    items: List<ListItem>,
    onItemClick: (Int) -> Unit
){
    Text(label, style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = paddingHorizontal))
    Spacer(modifier = Modifier.height(6.dp))
    LazyRow{
        items(items){ movie ->
            ListItem(item = movie, onItemClick = { onItemClick(it) })
        }
    }
}