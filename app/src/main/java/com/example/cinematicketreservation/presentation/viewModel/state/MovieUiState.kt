package com.example.cinematicketreservation.presentation.viewModel.state

import androidx.annotation.DrawableRes
import com.example.cinematicketreservation.R

data class MovieUiState(
    val title: String = "",
    val description: String = "",
    @DrawableRes val imageRes: Int = R.drawable.image_1,
    val duration: String = "",
    val genres: List<String> = emptyList(),
    val youtubeKey: String = ""
)
