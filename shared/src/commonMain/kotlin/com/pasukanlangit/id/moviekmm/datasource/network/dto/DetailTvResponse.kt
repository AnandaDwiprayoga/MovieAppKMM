package com.pasukanlangit.id.moviekmm.datasource.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailTvResponse(

    @SerialName("original_language")
	val originalLanguage: String,

    @SerialName("number_of_episodes")
	val numberOfEpisodes: Int,

    @SerialName("type")
	val type: String,

    @SerialName("backdrop_path")
	val backdropPath: String?,

    @SerialName("genres")
	val genres: List<GenreDetail>,

    @SerialName("popularity")
	val popularity: Double,

    @SerialName("id")
	val id: Int,

    @SerialName("number_of_seasons")
	val numberOfSeasons: Int,

    @SerialName("vote_count")
	val voteCount: Int,

    @SerialName("first_air_date")
	val firstAirDate: String,

    @SerialName("overview")
	val overview: String,

    @SerialName("poster_path")
	val posterPath: String,

    @SerialName("original_name")
	val originalName: String,

    @SerialName("vote_average")
	val voteAverage: Double,

    @SerialName("name")
	val name: String,

    @SerialName("tagline")
	val tagline: String,

    @SerialName("in_production")
	val inProduction: Boolean,

    @SerialName("last_air_date")
	val lastAirDate: String,

    @SerialName("homepage")
	val homepage: String,

    @SerialName("status")
	val status: String
)
