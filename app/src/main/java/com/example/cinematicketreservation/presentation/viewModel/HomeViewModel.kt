package com.example.cinematicketreservation.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cinematicketreservation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()
    val moviesList =
        mutableListOf<MovieUiState>(
            MovieUiState(
                title = "Morbius",
                description = "morbius dahwdawkd",
                imageRes = R.drawable.image_3
            ),
            MovieUiState(
                title = "Fantastic Beasts: The Secrets of Dumbledore",
                description = "Fantastic Beasts dahwdawkd",
                imageRes = R.drawable.image_1
            ),
            MovieUiState(
                title = "Doctor Strange In The Multiverse Of Madness",
                description = "Doctor Strange dahwdawkd",
                imageRes = R.drawable.image_2
            ),
        )

    fun updateState(index: Int) {
        Log.i("index", "index: $index ")
        _state.update {
            it.copy(
                title = moviesList[index].title,
                description = moviesList[index].description
            )
        }
    }
}