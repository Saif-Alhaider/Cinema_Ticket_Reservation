package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun SeatSet(modifier: Modifier=Modifier) {
    val isFirstSeatActive = remember { mutableStateOf(false) }
    val isSecondSeatActive = remember { mutableStateOf(false) }
    val firstSeatColor = if (isFirstSeatActive.value) Color(0xFFFF5524) else Color.White
    val secondSeatColor = if (isSecondSeatActive.value) Color(0xFFFF5524) else Color.White
    val combinationSeatColor =
        if (isFirstSeatActive.value || isSecondSeatActive.value) Color(0xFFFF5524) else Color(
            0xFF3C3C3C
        )
    Box(modifier.wrapContentWidth()) {
        Row(
            Modifier
                .padding(horizontal = 8.dp)
                .matchParentSize(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_cinema_seat),
                contentDescription = "cinema seat",
                colorFilter = ColorFilter.tint(color = firstSeatColor),
                modifier = Modifier.clickable { isFirstSeatActive.value = !isFirstSeatActive.value }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_cinema_seat),
                contentDescription = "cinema seat",
                colorFilter = ColorFilter.tint(color = secondSeatColor),
                modifier = Modifier.clickable {
                    isSecondSeatActive.value = !isSecondSeatActive.value
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_seat_combination),
            contentDescription = "cinema seat",
            colorFilter = ColorFilter.tint(color = combinationSeatColor),

        )
    }
}

@Preview
@Composable
fun SeatSetPreview() {
    SeatSet()
}