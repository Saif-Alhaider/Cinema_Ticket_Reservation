package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "movie details"

fun NavController.navigateToMovieDetails(movieName: String) {
    navigate("$ROUTE/$movieName")
}

fun NavGraphBuilder.movieDetailsRoute(navController: NavController) {
    composable(
        "$ROUTE/{${MovieDetailsArgs.MOVIE_NAME}}",
        arguments = listOf(navArgument(MovieDetailsArgs.MOVIE_NAME) { NavType.StringType })
    ) {
        MovieDetailsScreen(navController = navController)
    }
}

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
    val movieName: String = checkNotNull(savedStateHandle["movieName"])

    companion object {
        const val MOVIE_NAME = "movieName"
    }
}