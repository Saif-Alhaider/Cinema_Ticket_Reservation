package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CinemaProjector() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.Black)
            .padding(10.dp)
            .background(Color.Red.copy(alpha = .6f))
    ) {
        Canvas(modifier = Modifier
            .fillMaxSize(), contentDescription = "cinema screen", onDraw = {

            val canvasWidth = size.width
            val arcHeight = 150f
            drawArc(
                color = Color.Black,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(0f, -arcHeight / 2),
                size = Size(canvasWidth, arcHeight)
            )
            drawArc(
                color = Color.Black,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(0f, arcHeight * 2),
                size = Size(canvasWidth, arcHeight)
            )
        })
    }
}

@Preview
@Composable
fun CinemaProjectorPreview() {
    CinemaProjector()
}