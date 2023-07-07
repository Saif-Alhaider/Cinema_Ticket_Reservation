package com.example.cinematicketreservation.presentation.viewModel

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
        _state.value.seats.find { it.id == seatId }
            ?.let { removeSeat(seatId) }
            ?: addSingleSeat(seatId)
    }

    private fun addSingleSeat(seatId: String) {
        _state.update {
            it.copy(
                seats = it.seats.toMutableList().apply {
                    add(CinemaHallUiState.Seat(id = seatId))
                }
            )
        }
    }

    private fun removeSeat(seatId: String) {
        _state.update {
            it.copy(
                seats = _state.value.seats.toMutableList()
                    .apply { removeIf { seat -> seat.id == seatId } }
            )
        }
    }
}