package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun PlayButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_play),
        contentDescription = "play icon",
        modifier = Modifier
            .clip(CircleShape)
            .clickable { }
            .size(54.dp)
            .background(Color(0xFFFF5524))
            .padding(PaddingValues(16.dp))
            .then(modifier)
    )
}


@Preview
@Composable
fun PlayButtonPreview() {
    PlayButton()
}