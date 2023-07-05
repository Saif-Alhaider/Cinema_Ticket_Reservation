package com.example.cinematicketreservation.presentation.viewModel

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
                description = "Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, Dr. Michael Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals itself to be a remedy potentially worse than the disease.",
                imageRes = R.drawable.image_3,
                duration = "1h 45m",
                genres = listOf("Action", "Science", "Fiction", "Fantasy")
            ),
            MovieUiState(
                title = "Fantastic Beasts: The Secrets of Dumbledore",
                description = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers.",
                imageRes = R.drawable.image_1,
                duration = "2h 6m",
                genres = listOf("Adventure", "Fantasy")
            ),
            MovieUiState(
                title = "Doctor Strange In The Multiverse Of Madness",
                description = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
                imageRes = R.drawable.image_2,
                duration = "2h 23m",
                genres = listOf("Adventure", "Fantasy", "Action")
            ),
        )

    fun updateState(index: Int) {
        _state.update {
            it.copy(
                title = moviesList[index].title,
                description = moviesList[index].description,
                duration = moviesList[index].duration,
                imageRes = moviesList[index].imageRes,
                genres = moviesList[index].genres
            )
        }
    }
}