package com.example.cinematicketreservation.presentation

import androidx.annotation.DrawableRes
import com.example.cinematicketreservation.R

sealed class AppDestination(
    val route: String,
    @DrawableRes val imageIconRes: Int? = null,
    val title: String = route.uppercase()
) {
    object Home : AppDestination("home", imageIconRes = R.drawable.ic_video_play)
    object MovieDetails : AppDestination("movie details")
    object CinemaHall : AppDestination("cinema hall")
    object Search : AppDestination("search",imageIconRes = R.drawable.ic_search)
    object Tickets : AppDestination("tickets",imageIconRes = R.drawable.ic_ticket)
    object Profile : AppDestination("profile", imageIconRes = R.drawable.ic_user)
}
