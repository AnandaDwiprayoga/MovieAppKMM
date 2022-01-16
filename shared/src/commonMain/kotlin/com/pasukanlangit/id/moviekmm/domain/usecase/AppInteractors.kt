package com.pasukanlangit.id.moviekmm.domain.usecase

import com.pasukanlangit.id.moviekmm.domain.usecase.detail.*
import com.pasukanlangit.id.moviekmm.domain.usecase.movie.GetMoviePopular
import com.pasukanlangit.id.moviekmm.domain.usecase.movie.GetMovieTopRated
import com.pasukanlangit.id.moviekmm.domain.usecase.tv.GetTvPopular
import com.pasukanlangit.id.moviekmm.domain.usecase.tv.GetTvTopRated

data class AppInteractors(
    val getMoviePopular: GetMoviePopular,
    val getMovieTopRated: GetMovieTopRated,
    val getTvPopular: GetTvPopular,
    val getTvTopRated: GetTvTopRated,
    val getDetailMovie: GetDetailMovie,
    val getDetailTv: GetDetailTv,
    val favOrUnFavDetail: FavOrUnFavDetail,
    val getFavMovie: GetFavMovie,
    val getFavTv: GetFavTv
)
