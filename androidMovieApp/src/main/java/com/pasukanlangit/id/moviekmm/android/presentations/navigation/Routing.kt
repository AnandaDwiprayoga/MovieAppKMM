package com.pasukanlangit.id.moviekmm.android.presentations.navigation

import com.pasukanlangit.id.moviekmm.android.R

sealed class Screens(
    val route: String
){
    object Movie: Screens("movie_list")
    object Tv: Screens("tv_list")
    object Favorite: Screens("favorite")
//    object Detail: Screens("detail")
}
sealed class HomeNavigationItem(val route: String, val icon: Int, val label: String){
    object Movie: HomeNavigationItem(Screens.Movie.route, R.drawable.btm_movie_icon, "Movie")
    object Tv: HomeNavigationItem(Screens.Tv.route, R.drawable.btm_tv_icon, "Tv")
    object Favorite: HomeNavigationItem(Screens.Favorite.route, R.drawable.btm_favorite, "Favorite")
}



