package com.example.cinematicketreservation.data

import android.content.Context
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.viewModel.MovieUiState
import javax.inject.Inject


class MoviesData @Inject constructor(private val context: Context) {
    val data
        get() =
            mutableListOf<MovieUiState>(
                MovieUiState(
                    title = context.getString(R.string.morbius),
                    description = context.getString(R.string.morbius_description),
                    imageRes = R.drawable.image_3,
                    duration = "1h 45m",
                    genres = listOf(
                        context.getString(R.string.action),
                        context.getString(R.string.science_fiction),
                        context.getString(R.string.fantasy)
                    ),
                    youtubeKey = "oZ6iiRrz1SY"
                ),
                MovieUiState(
                    title = context.getString(R.string.fantastic_beasts_the_secrets_of_dumbledore),
                    description = context.getString(R.string.fantastic_beasts_description),
                    imageRes = R.drawable.image_1,
                    duration = "2h 6m",
                    genres = listOf(
                        context.getString(R.string.adventure),
                        context.getString(R.string.fantasy)
                    ),
                    youtubeKey = "Y9dr2zw-TXQ"
                ),
                MovieUiState(
                    title = context.getString(R.string.doctor_strange_in_the_multiverse_of_madness),
                    description = context
                        .getString(R.string.doctor_strange_in_the_multiverse_of_madness_description),
                    imageRes = R.drawable.image_2,
                    duration = "2h 23m",
                    genres = listOf(
                        context.getString(R.string.adventure),
                        context.getString(R.string.fantasy),
                        context.getString(R.string.action)
                    ),
                    youtubeKey = "aWzlQ2N6qqg"
                ),
            )
}