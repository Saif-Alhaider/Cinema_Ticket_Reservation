package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun SeatIndicatorSection(modifier: Modifier=Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        SeatIndicator(
            circleColor = Color.White,
            text = stringResource(R.string.available),
            textColor = Color.White.copy(alpha = .87f)
        )
        SeatIndicator(
            circleColor = Color(0xFF3C3C3C),
            text = stringResource(R.string.taken),
            textColor = Color(0xFFB5B5B5)
        )
        SeatIndicator(
            circleColor = Color(0xFFFF5524),
            text = stringResource(R.string.selected),
            textColor = Color.White.copy(alpha = .87f)
        )
    }
}

@Preview
@Composable
fun SeatIndicatorSectionPreview() {
    SeatIndicatorSection()
}