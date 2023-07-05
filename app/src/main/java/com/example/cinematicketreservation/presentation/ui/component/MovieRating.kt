package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun MovieRating(rating: String, ratingForm: String, cooperationRating: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(
                text = rating,
                color = Color.Black.copy(alpha = .87f),
                fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
                fontSize = 16.sp
            )
            Text(
                text = ratingForm,
                color = Color(0xFFB5B5B5),
                fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
                fontSize = 16.sp
            )
        }
        Text(
            text = cooperationRating,
            color = Color(0xFFB5B5B5),
            fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun MovieRatingPreview() {
    MovieRating("6.8", "/10", "IMDb")
}