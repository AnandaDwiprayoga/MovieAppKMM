package com.pasukanlangit.id.moviekmm.domain.usecase.detail

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.DataError
import com.pasukanlangit.id.moviekmm.domain.model.DetailData
import com.pasukanlangit.id.moviekmm.domain.model.getExceptionFromDataError
import com.pasukanlangit.id.moviekmm.domain.utils.CommonFlow
import com.pasukanlangit.id.moviekmm.domain.utils.DataState
import com.pasukanlangit.id.moviekmm.domain.utils.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetDetailTv(
    private val repository: MainRepository
) {
    operator fun invoke(id: Int): CommonFlow<DataState<DetailData>> = flow {
        emit(DataState.loading())
        try {
            val response = repository.getDetailTv(id)
            emit(DataState.data(data = response))
        }catch (e: DataError){
            emit(getExceptionFromDataError(e))
        }
    }.asCommonFlow()
}