package com.pasukanlangit.id.moviekmm.android.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pasukanlangit.id.moviekmm.android.presentations.pages.favorite.FavoritePage
import com.pasukanlangit.id.moviekmm.android.presentations.pages.movielist.MovieListPage
import com.pasukanlangit.id.moviekmm.android.presentations.pages.tvlist.TvListPage

@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = HomeNavigationItem.Movie.route ){
        composable(HomeNavigationItem.Movie.route){
            MovieListPage()
        }
        composable(HomeNavigationItem.Tv.route){
            TvListPage()
        }
        composable(HomeNavigationItem.Favorite.route){
            FavoritePage()
        }
//        composable(
//            route = "${Screens.Detail.route}/{id}/{type}",
//            arguments = listOf(
//                navArgument("id"){
//                    type = NavType.IntType
//                },
//                navArgument("type"){
//                    type = NavType.StringType
//                }
//            )
//        ){
//            DetailPage()
//        }
    }
}