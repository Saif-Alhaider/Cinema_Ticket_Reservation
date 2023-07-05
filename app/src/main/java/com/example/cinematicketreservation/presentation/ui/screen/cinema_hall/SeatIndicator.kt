package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerHorizontal4Dp

@Composable
fun SeatIndicator(circleColor: Color, text: String, textColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(13.dp)
                .background(circleColor, shape = CircleShape)
        )
        SpacerHorizontal4Dp()
        Text(text = text, color = textColor)
    }
}

@Preview
@Composable
fun SeatIndicatorPreview() {
    SeatIndicator(
        circleColor = Color.White,
        text = "Available",
        textColor = Color.White.copy(alpha = .87f)
    )
}