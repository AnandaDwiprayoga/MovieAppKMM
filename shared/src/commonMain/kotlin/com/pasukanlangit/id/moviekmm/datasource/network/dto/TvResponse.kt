package com.pasukanlangit.id.moviekmm.datasource.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvResponse(

	@SerialName("page")
	val page: Int,

	@SerialName("total_pages")
	val totalPages: Int,

	@SerialName("results")
	val results: List<TvItem>,

	@SerialName("total_results")
	val totalResults: Int
)

@Serializable
data class TvItem(

	@SerialName("first_air_date")
	val firstAirDate: String,

	@SerialName("overview")
	val overview: String,

	@SerialName("original_language")
	val originalLanguage: String,

	@SerialName("genre_ids")
	val genreIds: List<Int>,

	@SerialName("poster_path")
	val posterPath: String?,

	@SerialName("origin_country")
	val originCountry: List<String>,

	@SerialName("backdrop_path")
	val backdropPath: String?,

	@SerialName("original_name")
	val originalName: String,

	@SerialName("popularity")
	val popularity: Double,

	@SerialName("vote_average")
	val voteAverage: Double,

	@SerialName("name")
	val name: String,

	@SerialName("id")
	val id: Int,

	@SerialName("vote_count")
	val voteCount: Int
)
