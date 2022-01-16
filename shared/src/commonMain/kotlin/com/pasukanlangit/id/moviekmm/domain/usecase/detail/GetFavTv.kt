package com.pasukanlangit.id.moviekmm.domain.usecase.detail

import com.pasukanlangit.id.moviekmm.domain.MainRepository
import com.pasukanlangit.id.moviekmm.domain.model.ListItem
import com.pasukanlangit.id.moviekmm.domain.utils.CommonFlow
import com.pasukanlangit.id.moviekmm.domain.utils.asCommonFlow

class GetFavTv(
    private val repository: MainRepository
) {
    operator fun invoke(): CommonFlow<List<ListItem>> = repository.getTvFav().asCommonFlow()
}