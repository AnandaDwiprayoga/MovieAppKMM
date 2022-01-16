package com.pasukanlangit.id.moviekmm.datasource.cache

import com.pasukanlangit.id.moviekmm.datasource.sqldelight.*
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class AflixCacheImpl(
    aflixDatabase: AflixDatabase
): AflixCache {

    private val movieQueries: MovieDBQueries = aflixDatabase.movieDBQueries
    private val tvQueries: TvDBQueries = aflixDatabase.tvDBQueries
    private val detailQueries: DetailDbQueries = aflixDatabase.detailDbQueries

    override fun insertListMoviePopular(items: List<Movie_Entity>) {
        items.forEach { item ->
            movieQueries.insertMoviePopular(
                id = item.id,
                overview = item.overview,
                title = item.title,
                genres = item.genres,
                posterPath = item.posterPath,
                isFav = item.isFav
            )
        }
    }

    override fun insertListMovieTopRated(items: List<Movie_Entity>) {
        items.forEach { item ->
            movieQueries.insertMovieTopRated(
                id = item.id,
                overview = item.overview,
                title = item.title,
                genres = item.genres,
                posterPath = item.posterPath,
                isFav = item.isFav
            )
        }
    }

    override fun getListMoviePopular(): List<Movie_Entity> = movieQueries.selectMoviePopular().executeAsList()

    override fun getListMovieTopRated(): List<Movie_Entity> = movieQueries.selectMovieTopRated().executeAsList()

    override fun setMovieItemToFav(id: Long) = movieQueries.setMovieToFav(id)

    override fun setMovieItemToUnFav(id: Long) = movieQueries.unFavMovie(id)

    override fun getListMovieFav(): Flow<List<Movie_Entity>> =
        movieQueries.selectAllMovieFav().asFlow().mapToList()

    override fun insertListTvPopular(items: List<Tv_Entity>) {
        items.forEach { item ->
            tvQueries.insertTvPopular(
                id = item.id,
                overview = item.overview,
                name = item.name,
                genres = item.genres,
                posterPath = item.posterPath,
                isFav = item.isFav
            )
        }
    }

    override fun insertListTvTopRated(items: List<Tv_Entity>) {
        items.forEach { item ->
            tvQueries.insertTvTopRated(
                id = item.id,
                overview = item.overview,
                name = item.name,
                genres = item.genres,
                posterPath = item.posterPath,
                isFav = item.isFav
            )
        }
    }

    override fun getListTvPopular(): List<Tv_Entity> = tvQueries.selectTvPopular().executeAsList()

    override fun getListTvTopRated(): List<Tv_Entity> = tvQueries.selectTvTopRated().executeAsList()

    override fun setTvItemToFav(id: Long) = tvQueries.setTvToFav(id)

    override fun setTvItemToUnFav(id: Long) = tvQueries.unFavTv(id)

    override fun getListTvFav(): Flow<List<Tv_Entity>> =
        tvQueries.selectAllTvFav().asFlow().mapToList()

    override fun insertDetailTv(data: Detail_Entity) {
        //for some reasons (still don't know yet) query inserting twice, so we need to check first to avoiding duplicate imdb id
        val detailTv = detailQueries.getDetailTV(data.idDetail).executeAsList()
        if(detailTv.isEmpty()){
            detailQueries.insertDetailTv(
                idDetail = data.idDetail,
                title = data.title,
                overview = data.overview,
                genres = data.genres,
                backdropPath = data.backdropPath,
                subtitleDetail = data.subtitleDetail
            )
        }

    }

    override fun insertDetailMovie(data: Detail_Entity) {
        //for some reasons (still don't know yet) query inserting twice, so we need to check first to avoiding duplicate imdb id
        val detailMovie = detailQueries.getDetailMovie(data.idDetail).executeAsList()
        if(detailMovie.isEmpty()) {
            detailQueries.insertDetailMovie(
                idDetail = data.idDetail,
                title = data.title,
                overview = data.overview,
                genres = data.genres,
                backdropPath = data.backdropPath,
                subtitleDetail = data.subtitleDetail
            )
        }
    }

    override fun getDetailTv(id: Int): Detail_Entity? = detailQueries.getDetailTV(id.toLong()).executeAsOneOrNull()

    override fun getDetailMovie(id: Int): Detail_Entity? = detailQueries.getDetailMovie(id.toLong()).executeAsOneOrNull()


    override fun setDetailFavMovie(id: Long) =
        detailQueries.setDetailMovieToFav(id)

    override fun setDetailUnFavMovie(id: Long) =
        detailQueries.setDetailMovieToUnFav(id)

    override fun setDetailFavTv(id: Long) =
        detailQueries.setDetailTvToFav(id)

    override fun setDetailUnFavTv(id: Long) =
        detailQueries.setDetailTvToUnFav(id)

}