package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.ItemButton
import com.example.cinematicketreservation.presentation.ui.component.SpacerHorizontal8Dp

@Composable
fun Header() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        ItemButton(text = "Now Showing", textColor = Color.White)
        SpacerHorizontal8Dp()
        ItemButton(
            text = "Coming Soon",
            backgroundColor = Color.Transparent,
            border = BorderStroke(1.dp, Color(0x4DE5E5E5))
        )
    }
}