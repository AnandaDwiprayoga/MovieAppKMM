package com.pasukanlangit.id.moviekmm.domain.usecase.movie

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.DataError
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.getExceptionFromDataError
import com.pasukanlangit.id.moviekmm.domain.utils.CommonFlow
import com.pasukanlangit.id.moviekmm.domain.utils.DataState
import com.pasukanlangit.id.moviekmm.domain.utils.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetMovieTopRated(
    private val repository: MainRepository
) {
    operator fun invoke(): CommonFlow<DataState<List<ListItem>>> = flow {
        emit(DataState.loading())
        try {
            val response = repository.getTopRatedMovies()
            emit(DataState.data(data = response))
        }catch (e: DataError){
            emit(getExceptionFromDataError(e))
        }
    }.asCommonFlow()
}