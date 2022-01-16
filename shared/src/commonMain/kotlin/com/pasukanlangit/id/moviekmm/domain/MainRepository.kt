package com.pasukanlangit.id.moviekmm.domain

import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import kotlinx.coroutines.flow.Flow


interface MainRepository {
    suspend fun getAllMovies(): List<ListItem>
    suspend fun getTopRatedMovies(): List<ListItem>

    suspend fun getAllTv(): List<ListItem>
    suspend fun getTopRatedTv(): List<ListItem>

    suspend fun getDetailTv(idTv: Int): DetailData?
    suspend fun getDetailMovie(idMovie: Int): DetailData?

    fun setMovieToFav(id: Int)
    fun setMovieToUnFav(id: Int)

    fun setTvToFav(id: Int)
    fun setTvToUnFav(id: Int)

    fun setDetailMovieToFav(idTable: Long)
    fun setDetailMovieToUnFav(idTable: Long)
    fun setDetailTvToFav(idTable: Long)
    fun setDetailTvToUnFav(idTable: Long)

    fun getMoviesFav() : Flow<List<ListItem>>
    fun getTvFav() : Flow<List<ListItem>>
}