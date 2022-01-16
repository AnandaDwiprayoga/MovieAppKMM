package com.pasukanlangit.id.moviekmm.datasource

import com.pasukanlangit.id.moviekmm.datasource.cache.AflixCache
import com.pasukanlangit.id.moviekmm.datasource.network.ApiService
import com.pasukanlangit.id.moviekmm.datasource.util.*
import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainRepositoryImpl(
    private val apiService: ApiService,
    private val aflixCache: AflixCache
): MainRepository {

    override suspend fun getAllMovies(): List<ListItem> {
        try {
            val resultApi = apiService
                .getPopularMovie()
                .results

            aflixCache.insertListMoviePopular(resultApi.toMovieEntities())
            delay(1000L)
            val resultCache = aflixCache.getListMoviePopular()
            return resultCache.toMovieDomains()
        }catch (exc: Exception) {
            val resultCache = aflixCache.getListMoviePopular()
            throw DataError.ListItemError(
                message = exc.message,
                data = resultCache.toMovieDomains()
            )
        }
    }

    override suspend fun getTopRatedMovies(): List<ListItem> {
        try {
            val resultApi = apiService
                .getTopRatedMovie()
                .results

            aflixCache.insertListMovieTopRated(resultApi.toMovieEntities())
            val resultCache = aflixCache.getListMovieTopRated()
            return resultCache.toMovieDomains()
        }catch (exc: Exception){
            val resultCache = aflixCache.getListMovieTopRated()
            throw DataError.ListItemError(
                message = exc.message,
                data = resultCache.toMovieDomains()
            )
        }
    }

    override suspend fun getAllTv(): List<ListItem>{
        try {
            val resultApi = apiService
                .getPopularTv()
                .results

            aflixCache.insertListTvPopular(resultApi.toTvEntities())
            val resultCache = aflixCache.getListTvPopular()
            return resultCache.toTvDomains()
        }catch (exc: Exception){
            val resultCache = aflixCache.getListTvPopular()
            throw DataError.ListItemError(
                message = exc.message,
                data = resultCache.toTvDomains()
            )
        }
    }


    override suspend fun getTopRatedTv(): List<ListItem> {
        try {
            val resultApi =  apiService
                .getTopRatedTv()
                .results

            aflixCache.insertListTvTopRated(resultApi.toTvEntities())
            val resultCache = aflixCache.getListTvTopRated()
            return resultCache.toTvDomains()
        }catch (exc: Exception){
            val resultCache = aflixCache.getListTvTopRated()
            throw DataError.ListItemError(
                message = exc.message,
                data = resultCache.toTvDomains()
            )
        }
    }

    override suspend fun getDetailTv(idTv: Int): DetailData? {
        try {
            val resultApi = apiService
                .getTvDetail(idTv)

            aflixCache.insertDetailTv(resultApi.toDetailEntity())
            val resultCache = aflixCache.getDetailTv(idTv)
            return resultCache?.toDetailData()
        }catch (exc: Exception){
            val resultCache = aflixCache.getDetailTv(idTv)
            throw DataError.DetailError(
                message = exc.message,
                data = resultCache?.toDetailData()
            )
        }
    }


    override suspend fun getDetailMovie(idMovie: Int): DetailData? {
        try {
            val resultApi = apiService
                .getMovieDetail(idMovie)

            aflixCache.insertDetailMovie(resultApi.toDetailEntity())
            val resultCache = aflixCache.getDetailMovie(idMovie)
            return resultCache?.toDetailData()
        }catch (exc: Exception){
            val resultCache = aflixCache.getDetailMovie(idMovie)
            throw DataError.DetailError(
                message = exc.message,
                data = resultCache?.toDetailData()
            )
        }
    }

    override fun setMovieToFav(id: Int) =
        aflixCache.setMovieItemToFav(id.toLong())

    override fun setMovieToUnFav(id: Int) =
        aflixCache.setMovieItemToUnFav(id.toLong())

    override fun setTvToFav(id: Int) =
        aflixCache.setTvItemToFav(id.toLong())


    override fun setTvToUnFav(id: Int) =
        aflixCache.setTvItemToUnFav(id.toLong())

    override fun setDetailMovieToFav(idTable: Long) {
        aflixCache.setDetailFavMovie(idTable)
    }

    override fun setDetailMovieToUnFav(idTable: Long) {
        aflixCache.setDetailUnFavMovie(idTable)
    }

    override fun setDetailTvToFav(idTable: Long) {
        aflixCache.setDetailFavTv(idTable)
    }

    override fun setDetailTvToUnFav(idTable: Long) {
        aflixCache.setDetailUnFavTv(idTable)
    }

    override fun getMoviesFav(): Flow<List<ListItem>> =
        aflixCache.getListMovieFav().map { it.toMovieDomains() }

    override fun getTvFav(): Flow<List<ListItem>> =
        aflixCache.getListTvFav().map { it.toTvDomains() }

}