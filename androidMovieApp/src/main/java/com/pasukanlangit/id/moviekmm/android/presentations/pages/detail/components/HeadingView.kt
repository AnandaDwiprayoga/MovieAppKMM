package com.pasukanlangit.id.moviekmm.android.presentations.pages.detail.components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.components.AppImage
import com.pasukanlangit.id.moviekmm.android.presentations.components.LogoAflix
import com.pasukanlangit.id.moviekmm.android.presentations.theme.overlayBrushBottom
import com.pasukanlangit.id.moviekmm.android.presentations.theme.overlayBrushTop
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingHorizontal
import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.presentation.utils.ImageIMDB

@ExperimentalCoilApi
@Composable
fun HeadingView(
    data: DetailData,
    activity: Activity,
    onFavoriteButtonClicked: (Boolean) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {
        AppImage(
            url = ImageIMDB.getBannerMedium(data.backdropPath),
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = data.title
        )

        //overlay top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = overlayBrushTop),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                activity.finish()
            }) {
                Icon(Icons.Filled.ArrowBack, "icon back", tint = Color.White)
            }

            val isFav = remember { mutableStateOf(data.isFav) }
            IconButton(onClick = {
                isFav.value = !isFav.value
                onFavoriteButtonClicked(isFav.value)
            }) {
                if(isFav.value){
                    Icon(Icons.Filled.Favorite, "icon fav", tint = Color.Red)
                }else{
                    Icon(Icons.Filled.FavoriteBorder, "icon un fav", tint = Color.White)
                }
            }
        }

        //overlay bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(brush = overlayBrushBottom),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = paddingHorizontal, vertical = 6.dp)
            ) {
                Text(data.title, style = MaterialTheme.typography.h1.copy(fontSize = 20.sp))
                Spacer(modifier = Modifier.height(4.dp))
                Text(data.subtitleDetail, style = MaterialTheme.typography.h3)
                Text(data.genres, style = MaterialTheme.typography.subtitle1)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = paddingHorizontal)
                    .padding(vertical = 6.dp)
            ) {
                LogoAflix(modifier = Modifier.size(22.dp))
                Text(data.type, style = MaterialTheme.typography.h3.copy(letterSpacing = 2.sp))
            }
        }
    }
}