package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "CinemaHall"

fun NavController.navigateToCinemaHall(movieName: String) {
    navigate("$ROUTE/$movieName")
}

fun NavGraphBuilder.cinemaHallRoute(navController: NavController) {
    composable(
        "$ROUTE/{${CinemaHallArgs.MOVIE_NAME}}",
        arguments = listOf(navArgument(CinemaHallArgs.MOVIE_NAME) { NavType.StringType })
    ) {
        CinemaHallScreen(navController = navController)
    }
}

class CinemaHallArgs(savedStateHandle: SavedStateHandle) {
    val movieName: String = checkNotNull(savedStateHandle["movieName"])

    companion object {
        const val MOVIE_NAME = "movieName"
    }
}