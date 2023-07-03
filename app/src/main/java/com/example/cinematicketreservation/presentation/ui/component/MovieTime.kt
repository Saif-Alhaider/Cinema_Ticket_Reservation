package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun MovieTime() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_clock),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                Color.Black
            )
        )
        SpacerHorizontal4Dp()
        Text(
            text = "2h 23m",
            fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun MovieTimePreview() {
    MovieTime()
}