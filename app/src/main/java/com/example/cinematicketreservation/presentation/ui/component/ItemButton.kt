package com.example.cinematicketreservation.presentation.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketreservation.R

@Composable
fun ItemButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
    fontSize: TextUnit = 16.sp,
    backgroundColor: Color = Color(0xFFFF5524),
    textColor: Color = Color.Black,
    border: BorderStroke? = null,
    @DrawableRes iconResource: Int? = null,
    iconColor: Color = Color.Black.copy(alpha = .87f)
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor),
        border = border,
        modifier = Modifier
            .defaultMinSize(minWidth = 100.dp)
            .then(modifier)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            iconResource?.let { resourceId ->
                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = "card icon",
                    colorFilter = ColorFilter.tint(color = iconColor)
                )
                SpacerHorizontal4Dp()
            }
            Text(
                text = text,
                color = textColor,
                fontFamily = FontFamily(
                    Font(R.font.kumbh_sans_medium, FontWeight.Medium)
                ),
                fontSize = fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
fun ItemButtonPreview() {
    ItemButton(text = "Now Playing", iconResource = R.drawable.ic_card)
}