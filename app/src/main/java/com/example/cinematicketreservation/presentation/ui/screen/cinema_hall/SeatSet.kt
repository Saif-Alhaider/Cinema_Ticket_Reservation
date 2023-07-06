package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.viewModel.state.CinemaHallUiState

@Composable
fun SeatSet(
    onSeatClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    seatSet: Pair<CinemaHallUiState.Seat, CinemaHallUiState.Seat>
) {
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
                colorFilter = ColorFilter.tint(color = if (seatSet.first.isTaken) Color(0xFF404040) else firstSeatColor),
                modifier = Modifier.clickable {
                    if (!seatSet.first.isTaken) isFirstSeatActive.value = !isFirstSeatActive.value
                    onSeatClick(seatSet.first.id)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_cinema_seat),
                contentDescription = "cinema seat",
                colorFilter = ColorFilter.tint(color = if (seatSet.second.isTaken) Color(0XFF404040) else secondSeatColor),
                modifier = Modifier.clickable {
                    if (!seatSet.second.isTaken) isSecondSeatActive.value =
                        !isSecondSeatActive.value
                    onSeatClick(seatSet.second.id)
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_seat_combination),
            contentDescription = "cinema seat",
            colorFilter = ColorFilter.tint(
                color = if (seatSet.first.isTaken && seatSet.second.isTaken) Color(
                    0x613C3C3C
                ) else combinationSeatColor
            ),

            )
    }
}

@Preview
@Composable
fun SeatSetPreview() {
    SeatSet(
        seatSet = Pair(
            CinemaHallUiState.Seat("1a/1", false),
            CinemaHallUiState.Seat("1a/2", true)
        ),
        onSeatClick = {}
    )
}