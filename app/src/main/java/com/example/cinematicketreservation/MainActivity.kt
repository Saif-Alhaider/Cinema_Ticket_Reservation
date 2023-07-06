package com.example.cinematicketreservation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketreservation.presentation.ui.screen.home.BottomNavigation
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
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            CinemaTicketReservationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = {
                        if (navBackStackEntry?.destination?.route == AppDestination.Home.route) {
                            BottomNavigation(
                                selectedRoute = selectedRoute.value,
                                onItemClick = { selectedRoute.value = it })
                        }

                    }
                ) { innerPadding ->
                    CinemaTicketReservationNavGraph(
                        navController = navController,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}


