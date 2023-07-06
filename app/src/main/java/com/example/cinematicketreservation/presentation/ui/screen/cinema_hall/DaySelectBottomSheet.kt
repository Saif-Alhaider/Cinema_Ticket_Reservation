package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.ui.component.ItemButton
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical24Dp
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.ChooseDateSection
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.MovieTicketPrice

@Composable
fun DaySelectBottomSheet(numberOfTickets:Int) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        SpacerVertical24Dp()
        ChooseDateSection()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            MovieTicketPrice(numberOfTickets)
            ItemButton(
                text = stringResource(R.string.buy_tickets),
                textColor = Color.White,
                iconResource = R.drawable.ic_card, iconColor = Color.White.copy(alpha = .87f),
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DaySelectBottomSheetPreview() {
    DaySelectBottomSheet(4)
}

