package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasukanlangit.id.moviekmm.domain.usecase.AppInteractors
import com.pasukanlangit.id.moviekmm.presentation.favorite.FavoriteState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val appInteractors: AppInteractors
): ViewModel(){
    private val _state: MutableState<FavoriteState> = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getFavoriteMovie()
        getFavoriteTv()
    }

    private fun getFavoriteTv() {
        appInteractors
            .getFavTv()
            .collectCommon(viewModelScope) { data ->
                _state.value = state.value.copy(favoriteTv = data)
            }
    }

    private fun getFavoriteMovie() {
        appInteractors
            .getFavMovie()
            .collectCommon(viewModelScope) { data ->
                _state.value = state.value.copy(favoriteMovie = data)
            }
    }

}