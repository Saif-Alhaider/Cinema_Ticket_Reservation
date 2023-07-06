package com.example.cinematicketreservation.presentation.ui.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.activeCard() = then(
    Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(
            Brush.linearGradient(
                0f to Color(0xFF938C81),
                1f to Color(0xFFB8AC99),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            )
        )
)