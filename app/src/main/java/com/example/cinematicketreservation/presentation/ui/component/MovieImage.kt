package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun MovieImage(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "movie image",
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        contentScale = ContentScale.Crop
    )
}