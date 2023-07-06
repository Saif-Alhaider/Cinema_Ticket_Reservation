package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MovieTimeChip(duration:String) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(CircleShape)
    ) {
        MovieTime(
            movieDuration = duration,
            modifier = Modifier
                .padding(PaddingValues(vertical = 5.dp, horizontal = 8.dp)),
            textColor = Color.White.copy(alpha = .87f)
        )
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .blur(16.dp)
                .background(Color.White.copy(alpha = .4f))

        )
    }
}

@Preview
@Composable
fun MovieTimeChipPreview() {
    MovieTimeChip("2h 23m")
}