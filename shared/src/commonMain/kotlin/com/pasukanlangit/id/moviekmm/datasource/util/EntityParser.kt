package com.pasukanlangit.id.moviekmm.datasource.util

import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailMovieResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailTvResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.MovieItem
import com.pasukanlangit.id.moviekmm.datasource.network.dto.TvItem
import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Detail_Entity
import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Movie_Entity
import com.pasukanlangit.id.moviekmm.datasource.sqldelight.Tv_Entity
import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow

fun MovieItem.toMovieEntity(): Movie_Entity =
    Movie_Entity(
        id = this.id.toLong(),
        title = this.title,
        posterPath = this.posterPath,
        genres = this.genreIds.joinToString(separator = ",") { getGenreMoviesById(it) },
        overview = this.overview,
        isFav = null,
        type = null
    )

fun List<MovieItem>.toMovieEntities(): List<Movie_Entity> = this.map { it.toMovieEntity() }

fun TvItem.toTvEntity(): Tv_Entity =
    Tv_Entity(
        id = this.id.toLong(),
        name = this.name,
        posterPath = this.posterPath,
        genres = this.genreIds.joinToString(separator = ",") { getGenreMoviesById(it) },
        overview = this.overview,
        isFav = null,
        type = null
    )

fun List<TvItem>.toTvEntities(): List<Tv_Entity> = this.map { it.toTvEntity() }


fun Movie_Entity.toMovieDomain(): ListItem =
    ListItem(
        id = this.id.toInt(),
        title = this.title,
        poster = this.posterPath,
        genres = this.genres ?: "",
        desc = this.overview
    )

fun List<Movie_Entity>.toMovieDomains(): List<ListItem> = this.map { it.toMovieDomain() }

fun Tv_Entity.toTvDomain(): ListItem =
    ListItem(
        id = this.id.toInt(),
        title = this.name,
        poster = this.posterPath,
        genres = this.genres ?: "",
        desc = this.overview
    )

fun List<Tv_Entity>.toTvDomains(): List<ListItem> = this.map { it.toTvDomain() }

fun Detail_Entity.toDetailData(): DetailData =
    DetailData(
        idImdb = id.toInt(),
        idTable = idDetail,
        title = this.title,
        overview = this.overview,
        genres = this.genres,
        backdropPath = this.backdropPath,
        subtitleDetail = this.subtitleDetail,
        type = if(this.type?.toInt()?.equals(0) == true) TypeShow.MOVIE.uiValue else TypeShow.TV_SHOW.uiValue,
        isFav = this.isFav?.toInt()?.equals(1) ?: false
    )

fun DetailTvResponse.toDetailEntity(): Detail_Entity =
    Detail_Entity(
        id = 0,
        idDetail = this.id.toLong(),
        title = this.name,
        overview = this.overview,
        genres = getGenreString(this.genres),
        backdropPath = this.backdropPath,
        subtitleDetail = getSubtitleDetailTv(firstAirDate = firstAirDate, numberOfSessions = numberOfSeasons, numberOfEpisodes = numberOfEpisodes),
        type = null,
        isFav = null
    )

fun DetailMovieResponse.toDetailEntity(): Detail_Entity =
    Detail_Entity(
        id = 0,
        idDetail = this.id.toLong(),
        title = this.title,
        overview = this.overview,
        genres = getGenreString(this.genres),
        backdropPath = this.backdropPath,
        subtitleDetail = getSubtitleDetailMovie(adult, releaseDate, runtime),
        type = null,
        isFav = null
    )