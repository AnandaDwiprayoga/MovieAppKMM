package com.pasukanlangit.id.moviekmm.android.di

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.usecase.AppInteractors
import com.pasukanlangit.id.moviekmm.domain.usecase.detail.*
import com.pasukanlangit.id.moviekmm.domain.usecase.movie.GetMoviePopular
import com.pasukanlangit.id.moviekmm.domain.usecase.movie.GetMovieTopRated
import com.pasukanlangit.id.moviekmm.domain.usecase.tv.GetTvPopular
import com.pasukanlangit.id.moviekmm.domain.usecase.tv.GetTvTopRated
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideInteractors(mainRepository: MainRepository) =
        AppInteractors(
            getMoviePopular = GetMoviePopular(repository = mainRepository),
            getMovieTopRated = GetMovieTopRated(repository = mainRepository),
            getTvPopular = GetTvPopular(repository = mainRepository),
            getTvTopRated = GetTvTopRated(repository = mainRepository),
            getDetailMovie = GetDetailMovie(repository = mainRepository),
            getDetailTv = GetDetailTv(repository = mainRepository),
            favOrUnFavDetail = FavOrUnFavDetail(repository = mainRepository),
            getFavMovie = GetFavMovie(repository = mainRepository),
            getFavTv = GetFavTv(repository = mainRepository)
        )
}