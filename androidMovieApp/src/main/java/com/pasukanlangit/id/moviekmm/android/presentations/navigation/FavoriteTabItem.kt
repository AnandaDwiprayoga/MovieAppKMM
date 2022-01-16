package com.pasukanlangit.id.moviekmm.android.presentations.navigation

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components.FavoriteList
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow

@ExperimentalCoilApi
sealed class FavoriteTabItem(
    val index: Int,
    val title: String,
    val content: @Composable () -> Unit
){
    data class FavMovie(val favMovie: List<ListItem>): FavoriteTabItem(0,"MOVIES", { FavoriteList(items = favMovie, typeShow = TypeShow.MOVIE) })
    data class FavTv(val favTv: List<ListItem>): FavoriteTabItem(1,"TV", { FavoriteList(items = favTv, typeShow = TypeShow.TV_SHOW) })
}
