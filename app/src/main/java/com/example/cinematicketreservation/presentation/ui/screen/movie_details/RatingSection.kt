package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.MovieRating

@Composable
fun RatingSection(modifier: Modifier=Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        MovieRating("6.8", "/10", "IMDb")
        MovieRating("63%", "", "Rotten Tomatoes")
        MovieRating("4", "/10", "IGN")
    }
}