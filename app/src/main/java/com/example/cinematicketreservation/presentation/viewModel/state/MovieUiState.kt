package com.example.cinematicketreservation.presentation.viewModel.state

import androidx.annotation.DrawableRes
import com.example.cinematicketreservation.R

data class MovieUiState(
    val title: String = "",
    val description: String = "",
    @DrawableRes val posterRes: Int = R.drawable.image_1,
    @DrawableRes val secondPosterRes: Int = R.drawable.image_8,
    @DrawableRes val backdropRes: Int = R.drawable.image_6,
    val duration: String = "",
    val genres: List<String> = emptyList(),
    val youtubeKey: String = "",
    )
