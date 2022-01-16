package com.pasukanlangit.id.moviekmm.datasource.network.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MovieResponse(

	@SerialName("page")
	val page: Int,

	@SerialName("total_pages")
	val totalPages: Int,

	@SerialName("results")
	val results: List<MovieItem>,

	@SerialName("total_results")
	val totalResults: Int
)

@kotlinx.serialization.Serializable
data class MovieItem(

	@SerialName("overview")
	val overview: String,

	@SerialName("original_language")
	val originalLanguage: String,

	@SerialName("original_title")
	val originalTitle: String,

	@SerialName("video")
	val video: Boolean,

	@SerialName("title")
	val title: String,

	@SerialName("genre_ids")
	val genreIds: List<Int>,

	@SerialName("poster_path")
	val posterPath: String?,

	@SerialName("backdrop_path")
	val backdropPath: String?,

	@SerialName("release_date")
	val releaseDate: String?,

	@SerialName("popularity")
	val popularity: Double,

	@SerialName("vote_average")
	val voteAverage: Double,

	@SerialName("id")
	val id: Int,

	@SerialName("adult")
	val adult: Boolean,

	@SerialName("vote_count")
	val voteCount: Int
)
