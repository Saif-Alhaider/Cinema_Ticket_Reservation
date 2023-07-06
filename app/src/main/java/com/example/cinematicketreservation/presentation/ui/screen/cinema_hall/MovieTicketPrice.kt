package com.example.cinematicketreservation.presentation.ui.screen.cinema_hall

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun MovieTicketPrice() {
    Column() {
        Text(
            text = "$100.00",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
            letterSpacing = 1.3.sp,
            color = Color.Black.copy(alpha = .87f)
        )
        Text(text = "4 tickets", color = Color(0xFFB5B5B5))
    }
}

@Preview
@Composable
fun MovieTicketPricePreview() {
    MovieTicketPrice()
}