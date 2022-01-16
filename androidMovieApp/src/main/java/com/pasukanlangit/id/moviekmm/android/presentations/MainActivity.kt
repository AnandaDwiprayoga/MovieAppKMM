package com.pasukanlangit.id.moviekmm.android.presentations

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pasukanlangit.id.moviekmm.android.presentations.components.HomeBottomNavigationMenu
import com.pasukanlangit.id.moviekmm.android.presentations.navigation.Navigation
import com.pasukanlangit.id.moviekmm.android.presentations.theme.AppTheme
import com.pasukanlangit.id.moviekmm.android.presentations.theme.GreyColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalCoilApi
@ExperimentalPagerApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val viewModel = hiltViewModel<MainViewModel>()
//            val state = viewModel.moviePopular.value
//
//            AppTheme(
//                isLoading = state?.isLoading ?: false
//            ) {
//                LazyColumn {
//                    items(state?.data ?: listOf()){ movie ->
//                        Text(text = movie.title)
//                        Spacer(modifier = Modifier.height(8.dp))
//                    }
//                }
//            }
            AppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        HomeBottomNavigationMenu(
                            navController = navController,
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                            activeColor = MaterialTheme.colors.secondary,
                            unselectedColor = GreyColor
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }

        }
    }
}
