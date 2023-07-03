package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.ui.component.ItemButton
import com.example.cinematicketreservation.presentation.ui.component.SpacerHorizontal4Dp

@Composable
fun Genre() {
    Row {
        ItemButton(
            text = R.string.fantasy,
            color = Color.Transparent,
            border = BorderStroke(1.dp, Color(0xFFE5E5E5)),
            fontSize = 12.sp
        )
        SpacerHorizontal4Dp()
        ItemButton(
            text = R.string.adventure,
            color = Color.Transparent,
            border = BorderStroke(1.dp, Color(0xFFE5E5E5)),
            fontSize = 12.sp
        )
    }
}