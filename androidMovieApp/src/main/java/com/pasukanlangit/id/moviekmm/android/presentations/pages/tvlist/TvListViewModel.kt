package com.pasukanlangit.id.moviekmm.android.presentations.pages.tvlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.UIComponentType
import com.pasukanlangit.id.moviekmm.domain.usecase.AppInteractors
import com.pasukanlangit.id.moviekmm.domain.utils.Queue
import com.pasukanlangit.id.moviekmm.presentation.tv.TvState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvListViewModel @Inject constructor(
    private val interactors: AppInteractors
): ViewModel(){
    private val _state: MutableState<TvState> = mutableStateOf(TvState())
    val state: State<TvState> = _state

    init {
        getTvPopular()
        getTvTopRated()
    }

    fun removeHeadQueue(){
        try {
            val currentQueue = state.value.errorQueue
            currentQueue.remove()
            _state.value = state.value.copy(errorQueue = Queue(currentQueue.items))
        }catch (e: Exception){
            appendToMessageQueue(
                GenericMessageInfo
                    .Builder()
                    .title("Error")
                    .uiComponentType(UIComponentType.ALERT)
                    .description(e.message ?: "Unkown Error")
            )
        }
    }

    private fun getTvTopRated() {
        interactors
            .getTvTopRated()
            .collectCommon(viewModelScope) {
                it.data?.let { data ->
                    val randomNumber = (data.indices).random()
                    _state.value = state.value.copy(topRatedTv = data, randomBanner = data.getOrNull(randomNumber))
                }

                it.message?.let { message ->
                    appendToMessageQueue(message)
                }

                _state.value = state.value.copy(isLoading = it.isLoading)

            }

    }

    private fun appendToMessageQueue(message: GenericMessageInfo.Builder) {
        val currentError = state.value.errorQueue
        currentError.add(message)
        _state.value = state.value.copy(errorQueue = Queue(currentError.items))
    }

    private fun getTvPopular() {
        interactors
            .getTvPopular()
            .collectCommon(viewModelScope) {
                it.data?.let { data ->
                    _state.value = state.value.copy(popularTv = data)
                }

                it.message?.let { message ->
                    appendToMessageQueue(message)
                }

                _state.value = state.value.copy(isLoading = it.isLoading)

            }

    }
}