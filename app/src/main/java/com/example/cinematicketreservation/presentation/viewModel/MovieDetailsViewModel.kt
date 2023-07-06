package com.example.cinematicketreservation.presentation.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematicketreservation.data.MoviesData
import com.example.cinematicketreservation.presentation.ui.screen.movie_details.MovieDetailsArgs
import com.example.cinematicketreservation.presentation.viewModel.state.MovieUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesData: MoviesData,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()
    private val args = MovieDetailsArgs(savedStateHandle)

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        val movie = moviesData.data.find { it.title == args.movieName }
        movie?.let { _state.update { movie } }
    }

}