package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.R
import com.pasukanlangit.id.moviekmm.android.presentations.pages.detail.DetailPageActivity
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow

@ExperimentalCoilApi
@Composable
fun FavoriteList(
    items: List<ListItem>,
    typeShow: TypeShow
){
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        if(items.isEmpty()){
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_empty_fav),
                    contentDescription = "icon empty",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(150.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(text = "Empty List", style = MaterialTheme.typography.h2, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }else{
            LazyColumn {
                items(items){ item ->
                    FavoriteItem(item, onItemClick = {
                        context.startActivity(
                            Intent(context, DetailPageActivity::class.java).apply {
                                putExtra(DetailPageActivity.KEY_ID, it)
                                putExtra(DetailPageActivity.KEY_TYPE, typeShow.uiValue)
                            }
                        )
                    })
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }
    }

}