package com.pasukanlangit.id.moviekmm.datasource.network

import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailMovieResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.DetailTvResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.TvResponse
import com.pasukanlangit.id.moviekmm.datasource.network.dto.MovieResponse


interface ApiService {

    suspend fun getPopularMovie() : MovieResponse

    suspend fun getTopRatedMovie() : MovieResponse

    suspend fun getPopularTv() : TvResponse

    suspend fun getTopRatedTv() : TvResponse

    suspend fun getTvDetail(idTv: Int) : DetailTvResponse

    suspend fun getMovieDetail(idMovie: Int) : DetailMovieResponse
}