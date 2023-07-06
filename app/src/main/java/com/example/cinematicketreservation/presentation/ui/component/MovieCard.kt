package com.example.cinematicketreservation.presentation.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp,
    @DrawableRes imageRes: Int = R.drawable.image_1,
) {
    Image(
        painter = painterResource(id = imageRes), contentDescription = "Movie Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .size(width = width, height = height)
            .then(modifier)
    )
}

@Preview
@Composable
fun MovieCardPreview() {
    MovieCard(width = 264.dp, height = 400.dp)
}