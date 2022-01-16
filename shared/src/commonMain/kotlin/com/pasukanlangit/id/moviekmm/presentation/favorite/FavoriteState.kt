package com.pasukanlangit.id.moviekmm.presentation.favorite

import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.utils.Queue

data class FavoriteState(
    val favoriteTv: List<ListItem> = listOf(),
    val favoriteMovie: List<ListItem> = listOf()
){
    constructor(): this(
        favoriteTv = listOf(),
        favoriteMovie = listOf()
    )
}
