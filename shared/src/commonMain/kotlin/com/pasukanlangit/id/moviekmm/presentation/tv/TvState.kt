package com.pasukanlangit.id.moviekmm.presentation.tv

import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.utils.Queue

data class TvState(
    val isLoading: Boolean = false,
    val randomBanner: ListItem? = null,
    val popularTv: List<ListItem> = listOf(),
    val topRatedTv: List<ListItem> = listOf(),
    val errorQueue: Queue<GenericMessageInfo.Builder> = Queue(mutableListOf())
){
    constructor(): this(
        isLoading = false,
        randomBanner = null,
        popularTv = listOf(),
        topRatedTv = listOf(),
        errorQueue = Queue(mutableListOf())
    )
}