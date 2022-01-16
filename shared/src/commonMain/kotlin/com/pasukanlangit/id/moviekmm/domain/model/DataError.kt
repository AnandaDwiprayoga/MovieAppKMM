package com.pasukanlangit.id.moviekmm.domain.model

import com.pasukanlangit.id.moviekmm.domain.model.DataError.MessageOnly
import com.pasukanlangit.id.moviekmm.domain.utils.DataState

sealed class DataError: Exception(){
    data class ListItemError(override val message: String?, val data: List<ListItem> = listOf()): DataError()
    data class DetailError(override val message: String?, val data: DetailData? = null): DataError()
    data class MessageOnly(override val message: String?): DataError()
}


//inline function for better performance, coz under the hood lambda function will transform into class/object,
// since it not contain lambdas function, i think it not necessary to make inline function, but
// read about this article https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
inline fun <reified T> getExceptionFromDataError(exc: DataError, type: UIComponentType = UIComponentType.ALERT, title: String = "Error"): DataState<T> {
    val message = GenericMessageInfo
        .Builder()
        .title(title)
        .uiComponentType(type)
        .description(exc.message ?: "Unkown Error")

    return when(exc){
        is DataError.ListItemError -> {
            DataState.data(message = message, data = exc.data as T)
        }
        is DataError.DetailError -> {
            DataState.data(message = message, data = exc.data as T)
        }
        is MessageOnly -> { DataState.error(message = message)
        }
    }
}
