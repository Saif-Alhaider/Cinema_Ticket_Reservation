package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun MovieTime(
    movieDuration: String,
    modifier: Modifier = Modifier,
    textColor: Color
) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_clock),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color(0xFFB5B5B5))
        )
        SpacerHorizontal4Dp()
        Text(
            text = movieDuration,
            fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
            fontSize = 12.sp,
            color = textColor
        )
    }
}

@Preview
@Composable
fun MovieTimePreview() {
    MovieTime("2h 23m", textColor = Color.Black.copy(alpha = .87f))
}