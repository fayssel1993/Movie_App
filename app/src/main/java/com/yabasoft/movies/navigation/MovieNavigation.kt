package com.yabasoft.movies.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yabasoft.movies.screens.details.MovieDetails
import com.yabasoft.movies.screens.home.HomeScreen

/**
 * Created by Fayssel Yabahddou on 20/4/2023.
 */

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen().route
    ) {
        composable(MovieScreens.HomeScreen().route) {
            HomeScreen(
                modifier = Modifier,
                navController = navController
            )
        }

        composable(
            MovieScreens.DetailsScreen().route + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            MovieDetails(navHostController = navController, args = backStackEntry.arguments?.getString("movie"))
        }
    }
}