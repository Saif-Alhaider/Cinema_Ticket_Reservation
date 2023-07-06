package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical16Dp

@Composable
fun ChooseDateSection() {
    Column {
        ChooseDaySection()
        SpacerVertical16Dp()
        ChooseTimeSection()
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseDateSectionPreview() {
    ChooseDateSection()
}