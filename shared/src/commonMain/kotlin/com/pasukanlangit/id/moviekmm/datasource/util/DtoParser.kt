package com.pasukanlangit.id.moviekmm.datasource.util

import com.pasukanlangit.id.moviekmm.datasource.network.dto.*
import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow

fun TvItem.toTv(): ListItem =
    ListItem(
        id = this.id,
        title = this.name,
        poster = this.posterPath,
        genres = this.genreIds.joinToString(",") { getGenreTVById(it) },
        desc = this.overview
    )

fun List<TvItem>.toListTv(): List<ListItem> =
    this.map { movie -> movie.toTv() }


fun MovieItem.toMovie(): ListItem =
    ListItem(
        id = this.id,
        title = this.title,
        poster = this.posterPath,
        genres = this.genreIds.joinToString(",") { getGenreTVById(it) },
        desc = this.overview
    )

fun DetailMovieResponse.toDetailMovieDomain(): DetailData =
    DetailData(
        idImdb = this.id,
        idTable = 0,
        title = this.title,
        overview = this.overview,
        genres = getGenreString(this.genres),
        backdropPath = this.backdropPath,
        subtitleDetail = getSubtitleDetailMovie(adult, releaseDate, runtime) ,
        type = TypeShow.MOVIE.uiValue,
        isFav = false,
    )

fun getSubtitleDetailMovie(adult: Boolean, releaseDate: String, runtime: Int): String {
    val yearRelease = releaseDate.split("-")[0]
    val minAge = if(adult) "18+" else "13+"

    return "$minAge | $yearRelease | $runtime min"
}


fun DetailTvResponse.toDetailTvDomain(): DetailData =
    DetailData(
        idImdb = this.id,
        idTable = 0,
        title = this.name,
        overview = this.overview,
        genres = getGenreString(this.genres),
        backdropPath = this.backdropPath,
        subtitleDetail = getSubtitleDetailTv(firstAirDate = firstAirDate, numberOfSessions = numberOfSeasons, numberOfEpisodes = numberOfEpisodes),
        type = TypeShow.TV_SHOW.uiValue,
        isFav = false,
    )

fun getGenreString(genres: List<GenreDetail>): String{
    val genresString = StringBuilder()
    genres.map { genre -> genresString.append("${genre.name},") }
    return genresString.removeSuffix(",").toString()
}

fun getSubtitleDetailTv(firstAirDate: String, numberOfSessions: Int, numberOfEpisodes: Int): String {
    val yearRelease = firstAirDate.split("-")[0]
    return "$yearRelease | $numberOfSessions sessions | $numberOfEpisodes episodes"
}
fun List<MovieItem>.toListMovie(): List<ListItem> =
    this.map { movie -> movie.toMovie() }

