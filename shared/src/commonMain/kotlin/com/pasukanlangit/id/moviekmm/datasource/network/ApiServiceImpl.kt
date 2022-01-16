package com.pasukanlangit.id.moviekmm.datasource.network

import com.pasukanlangit.id.moviekmm.BuildKonfig
import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailMovieResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailTvResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.TvResponse
import io.ktor.client.*
import io.ktor.client.request.*
import com.pasukanlangit.id.moviekmm.datasource.network.dto.MovieResponse

class ApiServiceImpl(
    private val httpClient: HttpClient
): ApiService {
    override suspend fun getPopularMovie(): MovieResponse =
        httpClient.get {
            url("${base_url}movie/popular?api_key=${BuildKonfig.API_KEY}")
        }

    override suspend fun getTopRatedMovie(): MovieResponse =
        httpClient.get {
            url("${base_url}movie/top_rated?api_key=${BuildKonfig.API_KEY}")
        }

    override suspend fun getPopularTv(): TvResponse =
        httpClient.get {
            url("${base_url}tv/popular?api_key=${BuildKonfig.API_KEY}")
        }

    override suspend fun getTopRatedTv(): TvResponse =
        httpClient.get {
            url("${base_url}tv/top_rated?api_key=${BuildKonfig.API_KEY}")
        }

    override suspend fun getTvDetail(idTv: Int): DetailTvResponse =
        httpClient.get {
            url("${base_url}tv/${idTv}?api_key=${BuildKonfig.API_KEY}")
        }

    override suspend fun getMovieDetail(idMovie: Int): DetailMovieResponse =
        httpClient.get {
            url("${base_url}movie/${idMovie}?api_key=${BuildKonfig.API_KEY}")
        }

    companion object {
        const val base_url = "https://api.themoviedb.org/3/"
    }
}