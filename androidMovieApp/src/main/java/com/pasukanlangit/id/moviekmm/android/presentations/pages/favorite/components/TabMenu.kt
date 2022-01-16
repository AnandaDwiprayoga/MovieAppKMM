package com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.pasukanlangit.id.moviekmm.android.presentations.navigation.FavoriteTabItem
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun TabMenu(pagerState: PagerState, items: List<FavoriteTabItem>){
    val coroutineScope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {
            TabRowDefaults.Indicator(
                color = Color.Transparent
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        items.forEachIndexed { index, tabItem ->
            Tab(
                selected = index == pagerState.currentPage ,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(tabItem.index)
                    }
                },

                ) {
                TabItem(label = tabItem.title, isSelected = index == pagerState.currentPage)
            }
        }
    }
}