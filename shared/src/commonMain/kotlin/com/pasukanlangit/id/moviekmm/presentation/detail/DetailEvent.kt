package com.pasukanlangit.id.moviekmm.presentation.detail

sealed class DetailEvent {
    data class GetDetail(val id: Int,val type: String?): DetailEvent()
    data class FavOrUnFavDetail(val id: Long, val setToFav: Boolean): DetailEvent()
}
