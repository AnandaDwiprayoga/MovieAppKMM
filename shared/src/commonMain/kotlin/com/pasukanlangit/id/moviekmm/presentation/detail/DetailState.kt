package com.pasukanlangit.id.moviekmm.presentation.detail

import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.utils.Queue

data class DetailState(
    val isLoading: Boolean = false,
    val detailData: DetailData? = null,
    val errorQueue: Queue<GenericMessageInfo.Builder> = Queue(mutableListOf())
){
    constructor(): this(
        isLoading = false,
        detailData = null,
        errorQueue = Queue(mutableListOf())
    )
}