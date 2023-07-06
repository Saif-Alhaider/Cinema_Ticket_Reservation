package com.example.cinematicketreservation.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.cinematicketreservation.data.MoviesData
import com.example.cinematicketreservation.presentation.viewModel.state.MovieUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val moviesData: MoviesData) : ViewModel() {
    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()

    fun updateState(index: Int) {
        _state.update {
            it.copy(
                title = moviesData.data[index].title,
                description = moviesData.data[index].description,
                duration = moviesData.data[index].duration,
                imageRes = moviesData.data[index].imageRes,
                genres = moviesData.data[index].genres
            )
        }
    }
}