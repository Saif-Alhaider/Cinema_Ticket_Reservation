package com.example.cinematicketreservation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.cinemaHallRoute
import com.example.cinematicketreservation.presentation.ui.screen.home.homeRoute
import com.example.cinematicketreservation.presentation.ui.screen.movie_details.movieDetailsRoute

@Composable
fun CinemaTicketReservationNavGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.route
    ) {
        homeRoute(navController,innerPadding)
        movieDetailsRoute(navController)
        cinemaHallRoute(navController)

    }

}