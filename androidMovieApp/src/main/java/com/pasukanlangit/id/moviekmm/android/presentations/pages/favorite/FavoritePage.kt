package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.pasukanlangit.id.moviekmm.android.presentations.components.PageScreen
import com.pasukanlangit.id.moviekmm.android.presentations.navigation.FavoriteTabItem
import com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components.TabMenu
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingHorizontal
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingVertical

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun FavoritePage() {
    val pagerState = rememberPagerState()
    val viewModel: FavoriteViewModel = hiltViewModel()
    val state = viewModel.state.value

    val favoriteTabs = listOf(
        FavoriteTabItem.FavMovie(
            favMovie = state.favoriteMovie
        ),
        FavoriteTabItem.FavTv(
            favTv = state.favoriteTv
        ),
    )
    PageScreen(
        removeHeadFromQueue = {}
//        isLoading = state,
//        errorQueue = state
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
        ) {
            Text("Your Favorite ❤", style = MaterialTheme.typography.body1)

            Spacer(modifier = Modifier.height(16.dp))
            //tab menu
            TabMenu(
                pagerState = pagerState,
                items = favoriteTabs
            )

            Spacer(modifier = Modifier.height(18.dp))
            //content
            HorizontalPager(
                count = favoriteTabs.size,
                state = pagerState
            ) { index ->
                favoriteTabs[index].content()
            }
        }
    }

}