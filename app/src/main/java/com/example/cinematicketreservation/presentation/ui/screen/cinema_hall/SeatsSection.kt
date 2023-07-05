package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeatsSection() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        CinemaProjector()

        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            itemsIndexed(generateSeatList()) { index, seatId ->
                val rotateAngle = if (index % 3 == 0 ) 15f else if( index % 3 == 2) -15f else 0f
                SeatSet(Modifier.rotate(rotateAngle).padding(15.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SeatSectionPreview() {
    SeatsSection()
}

fun generateSeatList(): List<String> {
    val rows = listOf('A', 'B', 'C')
    val columns = listOf('1', '2', '3')
    val seats = listOf('1', '2')

    val random = Random()
    val seatList = mutableListOf<String>()

    while (seatList.size < 15) {
        val row = rows[random.nextInt(rows.size)]
        val column = columns[random.nextInt(columns.size)]
        val seat = seats[random.nextInt(seats.size)]

        val seatElement = "$row$column$seat"

        if (!seatList.contains(seatElement)) {
            seatList.add(seatElement)
        }
    }

    return seatList
}