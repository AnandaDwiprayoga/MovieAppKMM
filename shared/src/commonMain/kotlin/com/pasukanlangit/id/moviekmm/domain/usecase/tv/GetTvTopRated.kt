package com.pasukanlangit.id.moviekmm.domain.usecase.tv

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.DataError
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.model.getExceptionFromDataError
import com.pasukanlangit.id.moviekmm.domain.utils.CommonFlow
import com.pasukanlangit.id.moviekmm.domain.utils.DataState
import com.pasukanlangit.id.moviekmm.domain.utils.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetTvTopRated(
    private val repository: MainRepository
) {
    operator fun invoke(): CommonFlow<DataState<List<ListItem>>> = flow {
        emit(DataState.loading())
        try {
            val response = repository.getTopRatedTv()
            emit(DataState.data(data = response))

//            kotlinx.coroutines.delay(20000L)
//            emit(DataState.error(message = "This is error Example"))
        }catch (e: DataError){
            emit(getExceptionFromDataError(e))
        }
    }.asCommonFlow()
}