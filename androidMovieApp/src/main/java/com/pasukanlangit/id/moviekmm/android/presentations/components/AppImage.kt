package com.pasukanlangit.id.moviekmm.android.presentations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter


//sealed class AppImageSize(val width: Dp?,val height: Dp?){
//    object ImageList: AppImageSize(100.dp, 150.dp)
//    object ImageHero: AppImageSize(null, 420.dp)
//}

@ExperimentalCoilApi
@Composable
fun AppImage(
    url: String?,
    modifier: Modifier,
    contentDescription: String
){
    val painter = rememberImagePainter(url)
    Box {
//        val modifier = remember { Modifier }
//        if(appImageSize.width != null && appImageSize.height != null){
//            modifier
//                .width(appImageSize.width)
//                .height(appImageSize.height)
//        }else{
//            if(appImageSize.width == null){
//                modifier
//                    .fillMaxWidth()
//            }
//            if(appImageSize.height == null){
//                modifier
//                    .fillMaxHeight()
//            }
//        }
        if(url == null){
            Box(
                modifier = modifier
            ){
                Text(
                    "Image Not Available",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }else{
            Image(
                painter = painter,
                modifier = modifier,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
        }

        when(painter.state){
            is ImagePainter.State.Loading -> {
                Box(
                    modifier = modifier
                ){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is ImagePainter.State.Error -> {
                Box(
                    modifier = modifier
                ){
                    Text(
                        "Image Error",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            else -> {}
        }
    }
}