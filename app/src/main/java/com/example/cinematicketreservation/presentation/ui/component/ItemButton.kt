package com.example.cinematicketreservation.presentation.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun ItemButton(
    @StringRes text: Int,
    color: Color = Color(0xFFFF5524),
    border: BorderStroke? = null,
    textColor: Color = Color.Black,
    fontSize: TextUnit = 16.sp
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(color),
        border = border
    ) {
        Text(
            text = stringResource(text),
            color = textColor,
            fontFamily = FontFamily(
                Font(R.font.kumbh_sans_medium, FontWeight.Medium)
            ),
            fontSize = fontSize
        )
    }
}

@Preview
@Composable
fun ItemButtonPreview() {
    ItemButton(text = R.string.now_showing)
}