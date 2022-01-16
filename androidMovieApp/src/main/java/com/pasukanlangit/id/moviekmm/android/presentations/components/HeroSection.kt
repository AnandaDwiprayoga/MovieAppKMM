package com.pasukanlangit.id.moviekmm.android.presentations.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.theme.overlayBrushBottom
import com.pasukanlangit.id.moviekmm.android.presentations.theme.overlayBrushTop
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingHorizontal
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow
import com.pasukanlangit.id.moviekmm.presentation.utils.ImageIMDB

@ExperimentalCoilApi
@Composable
fun HeroSection(
    item: ListItem?,
    typeShow: TypeShow
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp),
    ){
        if(item == null){
            //Todo: handle when item null
        }else{
            AppImage(
                url = ImageIMDB.getBannerMedium(item.poster),
                modifier = Modifier.fillMaxSize(),
                contentDescription = item.title
            )
        }

        //overlay top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(brush = overlayBrushTop)
        )

        //center overflow
        BoxWithConstraints(
            Modifier
                .fillMaxSize()
        ) {
            val aspectRatio = maxWidth / maxHeight
            Box(
                Modifier
                    .fillMaxSize()
                    .scale(maxOf(aspectRatio, 1f), maxOf(1 / aspectRatio, 1f))
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0x00000000),
                                Color(0xC6001121)
                            ),
                        ),
                    )
            )
        }

        LogoAflix(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.TopStart)
                .padding(start = paddingHorizontal, top = 6.dp)
        )


        //overlay bottom
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(brush = overlayBrushBottom),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                LogoAflix(modifier = Modifier.size(26.dp))
                Text(typeShow.uiValue,style = MaterialTheme.typography.h3)
            }
            Text(item?.title ?: "",style = MaterialTheme.typography.h1, maxLines = 1, overflow = TextOverflow.Ellipsis)
//            val genres = StringBuilder("")
//            for(genre in item?.genres ?: listOf()){
//                genres.append(" $genre,")
//            }
            Text(item?.genres ?: "",style = MaterialTheme.typography.subtitle1)
        }
    }
}