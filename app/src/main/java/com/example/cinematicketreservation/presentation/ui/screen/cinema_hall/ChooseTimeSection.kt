package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.TimeCard
import com.example.cinematicketreservation.presentation.ui.screen.movie_details.DayCard
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun ChooseTimeSection(modifier: Modifier=Modifier) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        items(getTimeList()) { time ->
            TimeCard(time)
        }
    }
}


fun getTimeList(): List<String> {
    val currentTime = LocalTime.now().withMinute(0).withSecond(0)
    val formatter = DateTimeFormatter.ofPattern("H:mm")
    val timeList = mutableListOf<String>()

    var time = currentTime
    while (time.isBefore(LocalTime.of(23, 0))) {
        timeList.add(time.format(formatter))
        time = time.plusHours(1)
    }
    timeList.add("24:00")

    return timeList
}

@Preview(showBackground = true)
@Composable
fun ChooseTimeSectionPreview() {
    ChooseTimeSection()
}