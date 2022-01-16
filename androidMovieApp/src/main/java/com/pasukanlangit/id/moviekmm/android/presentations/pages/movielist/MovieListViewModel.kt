package com.pasukanlangit.id.moviekmm.android.presentations.pages.movielist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.UIComponentType
import com.pasukanlangit.id.moviekmm.domain.usecase.AppInteractors
import com.pasukanlangit.id.moviekmm.domain.utils.Queue
import com.pasukanlangit.id.moviekmm.presentation.movie.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val interactors: AppInteractors
): ViewModel(){
    private val _state: MutableState<MovieState> = mutableStateOf(MovieState())
    val state: State<MovieState> = _state

    init {
        getMoviePopular()
        getMovieTopRated()

        viewModelScope.launch {
            delay(1200L)
            for (i in 0 until 3){
                appendToMessageQueue(
                    GenericMessageInfo
                        .Builder()
                        .title("Error")
                        .uiComponentType(if(i == 0) UIComponentType.ALERT else UIComponentType.DIALOG)
                        .description( "Unkown Error $i")
                )
            }
        }

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


    private fun getMovieTopRated() {
        interactors
            .getMovieTopRated()
            .collectCommon(viewModelScope) {
                it.data?.let { data ->
                    val randomNumber = (data.indices).random()
                    _state.value = state.value.copy(topRatedMovie = data, randomBanner = data.getOrNull(randomNumber))
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

    private fun getMoviePopular() {
        interactors
            .getMoviePopular()
            .collectCommon(viewModelScope) {
                it.data?.let { data ->
                    _state.value = state.value.copy(popularMovie = data)
                }

                it.message?.let { message ->
                    appendToMessageQueue(message)
                }

                _state.value = state.value.copy(isLoading = it.isLoading)

            }
    }
}