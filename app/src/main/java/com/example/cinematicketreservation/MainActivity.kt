package com.example.cinematicketreservation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cinematicketreservation.presentation.ui.screen.home.HomeScreen
import com.example.cinematicketreservation.ui.theme.CinemaTicketReservationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaTicketReservationTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}


