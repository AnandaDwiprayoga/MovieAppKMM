package com.pasukanlangit.id.moviekmm.datasource.cache

import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Detail_Entity
import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Movie_Entity
import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Tv_Entity
import kotlinx.coroutines.flow.Flow

interface AflixCache {
    fun insertListMoviePopular(items: List<Movie_Entity>)
    fun insertListMovieTopRated(items: List<Movie_Entity>)
    fun getListMoviePopular(): List<Movie_Entity>
    fun getListMovieTopRated(): List<Movie_Entity>
    fun setMovieItemToFav(id: Long)
    fun setMovieItemToUnFav(id: Long)
    fun getListMovieFav(): Flow<List<Movie_Entity>>

    fun insertListTvPopular(items: List<Tv_Entity>)
    fun insertListTvTopRated(items: List<Tv_Entity>)
    fun getListTvPopular(): List<Tv_Entity>
    fun getListTvTopRated(): List<Tv_Entity>
    fun setTvItemToFav(id: Long)
    fun setTvItemToUnFav(id: Long)
    fun getListTvFav(): Flow<List<Tv_Entity>>

    fun insertDetailTv(data: Detail_Entity)
    fun insertDetailMovie(data: Detail_Entity)
    fun getDetailTv(id: Int): Detail_Entity?
    fun getDetailMovie(id: Int): Detail_Entity?
    fun setDetailFavMovie(idTable: Long)
    fun setDetailUnFavMovie(idTable: Long)
    fun setDetailFavTv(idTable: Long)
    fun setDetailUnFavTv(idTable: Long)
}