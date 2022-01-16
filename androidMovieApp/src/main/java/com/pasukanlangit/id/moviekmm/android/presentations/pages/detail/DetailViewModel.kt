package com.pasukanlangit.id.moviekmm.android.presentations.pages.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.domain.model.GenericMessageInfo
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow
import com.pasukanlangit.id.moviekmm.domain.model.UIComponentType
import com.pasukanlangit.id.moviekmm.domain.usecase.AppInteractors
import com.pasukanlangit.id.moviekmm.domain.utils.Queue
import com.pasukanlangit.id.moviekmm.presentation.detail.DetailEvent
import com.pasukanlangit.id.moviekmm.presentation.detail.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoilApi
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val appInteractors: AppInteractors,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private var type: String? = null
    private var jobFavOrUnFav: Job? = null

    private val _state: MutableState<DetailState> = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    init {
        type = savedStateHandle.get<String>(DetailPageActivity.KEY_TYPE)
        savedStateHandle.get<Int>(DetailPageActivity.KEY_ID)?.let { id ->
            onTriggerEvent(DetailEvent.GetDetail(id, type))
        }
    }

    fun onTriggerEvent(event: DetailEvent){
        when(event){
            is DetailEvent.GetDetail -> {
                getDetail(event.id, event.type)
            }
            is DetailEvent.FavOrUnFavDetail -> {
                jobFavOrUnFav?.cancel()
                jobFavOrUnFav = viewModelScope.launch {
                       appInteractors.favOrUnFavDetail(event.id, type = TypeShow.values().singleOrNull { it.uiValue == type }, event.setToFav)
                }
            }
        }
    }

    fun removeHeadQueue(){
        try {
            val currentQueue = state.value.errorQueue
            currentQueue.remove()
            _state.value = state.value.copy(errorQueue = Queue(currentQueue.items))
        }catch (e: Exception){
            appendErrorMessage(
                GenericMessageInfo
                    .Builder()
                    .title("Error")
                    .uiComponentType(UIComponentType.ALERT)
                    .description(e.message ?: "Unkown Error")
            )
        }
    }


    private fun getDetail(id: Int, type: String?) {
        when(type){
            TypeShow.MOVIE.uiValue -> getMovieById(id)
            TypeShow.TV_SHOW.uiValue -> getTvById(id)
            else -> appendErrorMessage(
                GenericMessageInfo.Builder()
                    .title("Error")
                    .description("Please specify detail type")
                    .uiComponentType(UIComponentType.DIALOG)
            )
        }
    }



    private fun appendErrorMessage(error: GenericMessageInfo.Builder) {
        val currentError = state.value.errorQueue
        currentError.add(error)
        _state.value = state.value.copy(errorQueue = Queue(currentError.items))
    }

    private fun getTvById(id: Int) {
        appInteractors
            .getDetailTv(id)
            .collectCommon(viewModelScope) {
                it.data?.let { detailTv ->
                    _state.value = state.value.copy(detailData = detailTv)
                }

                it.message?.let { message ->
                    appendErrorMessage(message)
                }

                _state.value = state.value.copy(isLoading = it.isLoading)
            }
    }

    private fun getMovieById(id: Int) {
        appInteractors
            .getDetailMovie(id)
            .collectCommon(viewModelScope) {
                it.data?.let { detailMovie ->
                    _state.value = state.value.copy(detailData = detailMovie)
                }

                it.message?.let { message ->
                    appendErrorMessage(message)
                }

                _state.value = state.value.copy(isLoading = it.isLoading)
            }
    }
}