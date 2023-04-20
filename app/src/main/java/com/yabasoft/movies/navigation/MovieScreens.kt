package com.yabasoft.movies.navigation

/**
 * Created by Fayssel Yabahddou on 20/4/2023.
 */
sealed class MovieScreens(val route: String) {
    class HomeScreen : MovieScreens("home")
    class DetailsScreen : MovieScreens("details")
}
