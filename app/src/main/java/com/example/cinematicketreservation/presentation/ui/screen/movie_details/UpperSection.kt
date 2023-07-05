package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinematicketreservation.R

@Composable
fun UpperSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        MovieImage(image = R.drawable.image_4, modifier = Modifier.align(Alignment.TopStart))
        PlayButton(modifier = Modifier.align(Alignment.Center))
        AppBar()
    }
}

@Preview(showSystemUi = true)
@Composable
fun UpperSectionPreview() {
    UpperSection()
}