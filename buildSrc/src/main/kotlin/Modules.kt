object Modules {
    const val app = ":androidMovieApp"
    const val shared = ":shared"
    const val features = ":features"
    const val movieList = "$features:movielist"
    const val tvList = "$features:tvlist"
    const val movieListDataSource = "${movieList}:movielist_datasource"
    const val movieListDomain = "${movieList}:movielist_domain"
}