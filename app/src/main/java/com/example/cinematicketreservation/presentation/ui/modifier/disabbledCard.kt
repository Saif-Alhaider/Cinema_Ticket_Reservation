package com.example.cinematicketreservation.presentation.ui.modifier

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.disabbledCard() = then(Modifier.border(
    BorderStroke(width = 1.5.dp, Color(0xFFb5b5b5)),
    RoundedCornerShape(16.dp)
))