package com.pasukanlangit.id.moviekmm.android.presentations.pages.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.pasukanlangit.id.moviekmm.android.presentations.components.PageScreen
import com.pasukanlangit.id.moviekmm.android.presentations.pages.detail.components.HeadingView
import com.pasukanlangit.id.moviekmm.android.presentations.theme.AppTheme
import com.pasukanlangit.id.moviekmm.android.presentations.theme.paddingHorizontal
import com.pasukanlangit.id.moviekmm.presentation.detail.DetailEvent
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalCoilApi
@AndroidEntryPoint
class DetailPageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val viewModel: DetailViewModel = hiltViewModel()
                val state = viewModel.state.value
                val data = state.detailData

                PageScreen(
                    isLoading = state.isLoading,
                    errorQueue = state.errorQueue,
                    removeHeadFromQueue = { viewModel.removeHeadQueue() }
                ) {
                    if(data == null){
                        if(state.isLoading){

                        }else{
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                            ) {
                                Text("Unable to load detail", style = MaterialTheme.typography.h1, modifier = Modifier.align(Alignment.Center))
                            }
                        }
                    }else{
                        LazyColumn {
                            item {
                                Column {
                                    HeadingView(
                                        data = data,
                                        activity = this@DetailPageActivity,
                                        onFavoriteButtonClicked = {
                                            viewModel.onTriggerEvent(DetailEvent.FavOrUnFavDetail(id = data.idTable, it))
                                        }
                                    )

                                    Spacer(modifier = Modifier.height(18.dp))
                                    Text(data.overview, style = MaterialTheme.typography.subtitle1.copy(fontSize = 13.sp), modifier = Modifier.padding(horizontal = paddingHorizontal))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val KEY_ID = "KEY_ID"
        const val KEY_TYPE = "KEY_TYPE"
    }
}