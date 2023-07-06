package com.example.cinematicketreservation.presentation.viewModel.state

import androidx.annotation.DrawableRes
import com.example.cinematicketreservation.R
import java.time.LocalDate
import java.time.LocalTime

data class CinemaHallUiState(
    @DrawableRes val movieBackDropImageRes: Int = R.drawable.image_5,
    val movieBookingDate: MovieBookingDate = MovieBookingDate(),
    val seats: List<Seat> = emptyList()
) {
    data class MovieBookingDate(
        val availableDays: List<LocalDate> = emptyList(),
        val availableTime: List<LocalTime> = emptyList(),
    )

    data class Seat(val id: String="", val isTaken: Boolean=false)
}
