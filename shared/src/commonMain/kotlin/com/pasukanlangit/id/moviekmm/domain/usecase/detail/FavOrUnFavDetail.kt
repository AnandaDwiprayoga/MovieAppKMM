package com.pasukanlangit.id.moviekmm.domain.usecase.detail

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow

class FavOrUnFavDetail(
    private val repository: MainRepository
) {
    operator fun invoke(id: Long, type: TypeShow?, setToFav: Boolean){
        if(type == null) return
        when(type){
            TypeShow.MOVIE -> {
                if(setToFav){
                    repository.setDetailMovieToFav(id)
                    repository.setMovieToFav(id.toInt())
                }else {
                    repository.setDetailMovieToUnFav(id)
                    repository.setMovieToUnFav(id.toInt())
                }
            }
            TypeShow.TV_SHOW -> {
                if(setToFav){
                    repository.setDetailTvToFav(id)
                    repository.setTvToFav(id.toInt())
                }else {
                    repository.setDetailTvToUnFav(id)
                    repository.setTvToUnFav(id.toInt())
                }
            }
        }
    }
}