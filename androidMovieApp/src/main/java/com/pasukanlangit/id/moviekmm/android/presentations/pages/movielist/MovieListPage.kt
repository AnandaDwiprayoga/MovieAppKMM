package com.pasukanlangit.id.moviekmm.android.presentations.pages.movielist

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.components.HeroSection
import com.pasukanlangit.id.moviekmm.android.presentations.components.HorizontalListWithLabel
import com.pasukanlangit.id.moviekmm.android.presentations.components.PageScreen
import com.pasukanlangit.id.moviekmm.domain.model.TypeShow
import com.pasukanlangit.id.moviekmm.android.presentations.pages.detail.DetailPageActivity

@ExperimentalCoilApi
@Composable
fun MovieListPage() {
    val viewModel: MovieListViewModel = hiltViewModel()
    val state = viewModel.state.value
    val context = LocalContext.current

    PageScreen(
        isLoading = state.isLoading,
        errorQueue = state.errorQueue,
        removeHeadFromQueue = { viewModel.removeHeadQueue() }
    ) {
        LazyColumn {
            item {
                Column {
                    //Hero Section
                    HeroSection(item = state.randomBanner, typeShow = TypeShow.MOVIE)
                    Spacer(modifier = Modifier.height(20.dp))

                    //Popular Section
                    HorizontalListWithLabel(
                        label = "Terbaru untuk kamu",
                        items = state.popularMovie,
                        onItemClick = {
                            context.startActivity(
                                Intent(context, DetailPageActivity::class.java).apply {
                                    putExtra(DetailPageActivity.KEY_ID, it)
                                    putExtra(DetailPageActivity.KEY_TYPE, TypeShow.MOVIE.uiValue)
                                }
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    //Top Rated Section
                    HorizontalListWithLabel(
                        label = "Pilihan terbaik buatmu",
                        items = state.topRatedMovie,
                        onItemClick = {
                            context.startActivity(
                                Intent(context, DetailPageActivity::class.java).apply {
                                    putExtra(DetailPageActivity.KEY_ID, it)
                                    putExtra(DetailPageActivity.KEY_TYPE, TypeShow.MOVIE.uiValue)
                                }
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}