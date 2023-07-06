package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
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
fun TimeCard(time: String) {
    val isSelected = remember { mutableStateOf(false) }
    val isSelectedTextColor =
        (if (isSelected.value) Color.White else Color.Black).copy(alpha = .87f)
    val isSelectedModifier =
        if (isSelected.value) Modifier.activeCard() else Modifier.disabbledCard()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .then(isSelectedModifier)
            .clickable { isSelected.value = !isSelected.value }
            .defaultMinSize(64.dp)
    ) {
        Text(
            text = time,
            color = isSelectedTextColor,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimeCardPreview() {
    TimeCard("12:30")
}