package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.presentation.ui.component.ItemButton

@Composable
fun Genre(genres: List<String>) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(PaddingValues(horizontal = 16.dp))
            .fillMaxWidth()
    ) {
        genres.forEach {
            GenreItemButton(it, modifier = Modifier.padding(PaddingValues(horizontal = 4.dp)))
        }
    }
}

@Composable
fun GenreItemButton(text: String, modifier: Modifier = Modifier) {
    ItemButton(
        text = text,
        backgroundColor = Color.Transparent,
        border = BorderStroke(1.dp, Color(0xFFE5E5E5)),
        fontSize = 12.sp,
        modifier = modifier
    )
}