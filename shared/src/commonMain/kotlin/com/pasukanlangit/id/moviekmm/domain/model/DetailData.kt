package com.pasukanlangit.id.moviekmm.domain.model

data class DetailData(
    val idImdb: Int,
    val idTable: Long,
    val title: String,
    val overview: String,
    val genres: String,
    val backdropPath: String?,
    val subtitleDetail: String,
    val type: String,
    val isFav: Boolean
)
