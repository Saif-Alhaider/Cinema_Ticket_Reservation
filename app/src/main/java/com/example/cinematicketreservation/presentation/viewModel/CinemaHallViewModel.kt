package com.example.cinematicketreservation.presentation.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematicketreservation.data.MoviesData
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.CinemaHallArgs
import com.example.cinematicketreservation.presentation.viewModel.state.CinemaHallUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CinemaHallViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val moviesData: MoviesData
) : ViewModel() {
    private val _state = MutableStateFlow(CinemaHallUiState())
    val state = _state.asStateFlow()
    private val args = CinemaHallArgs(savedStateHandle)

    init {
        getMovieTicketDetails()
    }

    private fun getMovieTicketDetails() {
        val movie = moviesData.data.find { it.title == args.movieName }
        movie?.let { _state.update { it.copy(movieBackDropImageRes = movie.backdropRes) } }
    }

    fun addSeats(seatId: String) {
        val updateList = _state.value.seats.toMutableList()
        if (_state.value.seats.any { seatId == it.id }) {
            updateList.removeIf{it.id == seatId}
        } else {
            updateList.add(CinemaHallUiState.Seat(id = seatId))
        }
        _state.update { it.copy(seats = updateList) }
    }
}