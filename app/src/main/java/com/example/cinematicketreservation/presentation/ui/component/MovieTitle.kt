package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun MovieTitle(movieText: String) {
    Text(
        text = movieText,
        fontFamily = FontFamily(Font(R.font.kumbh_sans_medium)),
        fontSize = 24.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        lineHeight = 32.sp,
        modifier = Modifier.padding(horizontal = 50.dp)
    )
}