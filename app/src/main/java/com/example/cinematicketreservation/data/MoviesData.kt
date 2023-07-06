package com.example.cinematicketreservation.data

import android.content.Context
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.viewModel.state.MovieUiState
import javax.inject.Inject


class MoviesData @Inject constructor(private val context: Context) {
    val data
        get() =
            mutableListOf<MovieUiState>(
                MovieUiState(
                    title = context.getString(R.string.morbius),
                    description = context.getString(R.string.morbius_description),
                    duration = "1h 45m",
                    genres = listOf(
                        context.getString(R.string.action),
                        context.getString(R.string.science_fiction),
                        context.getString(R.string.fantasy)
                    ),
                    youtubeKey = "oZ6iiRrz1SY",
                    posterRes = R.drawable.image_3,
                    secondPosterRes = R.drawable.image_9,
                    backdropRes = R.drawable.image_7

                ),
                MovieUiState(
                    title = context.getString(R.string.fantastic_beasts_the_secrets_of_dumbledore),
                    description = context.getString(R.string.fantastic_beasts_description),
                    duration = "2h 6m",
                    genres = listOf(
                        context.getString(R.string.adventure),
                        context.getString(R.string.fantasy)
                    ),
                    youtubeKey = "Y9dr2zw-TXQ",
                    posterRes = R.drawable.image_1,
                    secondPosterRes = R.drawable.image_4,
                    backdropRes = R.drawable.image_5
                ),
                MovieUiState(
                    title = context.getString(R.string.doctor_strange_in_the_multiverse_of_madness),
                    description = context
                        .getString(R.string.doctor_strange_in_the_multiverse_of_madness_description),
                    duration = "2h 23m",
                    genres = listOf(
                        context.getString(R.string.adventure),
                        context.getString(R.string.fantasy),
                        context.getString(R.string.action)
                    ),
                    youtubeKey = "aWzlQ2N6qqg",
                    posterRes = R.drawable.image_2,
                    secondPosterRes = R.drawable.image_8,
                    backdropRes = R.drawable.image_6,
                ),
            )
}