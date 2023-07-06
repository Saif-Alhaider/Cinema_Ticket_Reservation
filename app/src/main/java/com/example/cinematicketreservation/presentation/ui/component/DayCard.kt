package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.modifier.activeCard
import com.example.cinematicketreservation.presentation.ui.modifier.disabbledCard

@Composable
fun DayCard(date: String, day: String) {
    val isSelected = remember { mutableStateOf(false) }
    val isSelectedTextColor =
        (if (isSelected.value) Color.White else Color.Black).copy(alpha = .87f)
    val isSelectedModifier =
        if (isSelected.value) Modifier.activeCard() else Modifier.disabbledCard()
    Box(
        Modifier
            .width(54.dp)
            .height(64.dp)
            .then(isSelectedModifier)
            .clickable { isSelected.value = !isSelected.value }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = date, color = isSelectedTextColor)
            Text(text = day, color = isSelectedTextColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DayCardPreview() {
    DayCard("14", "Sat")
}

