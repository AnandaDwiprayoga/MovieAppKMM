package com.pasukanlangit.id.moviekmm.presentation.movie

import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.utils.Queue

data class MovieState(
    val isLoading: Boolean = false,
    val randomBanner: ListItem? = null,
    val popularMovie: List<ListItem> = listOf(),
    val topRatedMovie: List<ListItem> = listOf(),
    val errorQueue: Queue<GenericMessageInfo.Builder> = Queue(mutableListOf())
){
    constructor(): this(
        isLoading = false,
        randomBanner = null,
        popularMovie = listOf(),
        topRatedMovie = listOf(),
        errorQueue = Queue(mutableListOf())
    )
}