package com.pasukanlangit.id.moviekmm.presentation.utils

object ImageIMDB {
    fun getPosterMedium(filename: String?) : String = if(filename != null) "https://image.tmdb.org/t/p/w342/$filename" else "https://www.bigpharmacy.com.my/scripts/timthumb.php?src=https://www.bigpharmacy.com.my//site_media/img/100938EA.jpg&amp;w=600&amp;zc=1"

    fun getPosterSmall(filename: String?) : String =  if(filename != null) "https://image.tmdb.org/t/p/w185/$filename" else "https://www.bigpharmacy.com.my/scripts/timthumb.php?src=https://www.bigpharmacy.com.my//site_media/img/100938EA.jpg&amp;w=600&amp;zc=1"

    fun getBannerMedium(filename: String?) : String =  if(filename != null) "https://image.tmdb.org/t/p/w780/$filename" else "https://www.bigpharmacy.com.my/scripts/timthumb.php?src=https://www.bigpharmacy.com.my//site_media/img/100938EA.jpg&amp;w=600&amp;zc=1"
}