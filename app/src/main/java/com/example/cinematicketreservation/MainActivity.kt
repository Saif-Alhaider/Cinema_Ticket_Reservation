package com.example.cinematicketreservation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketreservation.presentation.AppDestination
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.CinemaHall
import com.example.cinematicketreservation.presentation.ui.screen.home.BottomNavigation
import com.example.cinematicketreservation.presentation.ui.screen.home.HomeScreen
import com.example.cinematicketreservation.presentation.ui.screen.movie_details.MovieDetails
import com.example.cinematicketreservation.ui.theme.CinemaTicketReservationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)
        val selectedRoute = mutableStateOf(AppDestination.Home.route)
        setContent {
            CinemaTicketReservationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            selectedRoute = selectedRoute.value,
                            onItemClick = { selectedRoute.value = it })
                    }
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = AppDestination.Home.route
                    ) {
                        composable(AppDestination.Home.route)
                        { Box(Modifier.padding(innerPadding)) { HomeScreen() } }
                        composable(AppDestination.MovieDetails.route) { MovieDetails() }
                        composable(AppDestination.CinemaHall.route) { CinemaHall() }
                    }
                }
            }
        }
    }
}


