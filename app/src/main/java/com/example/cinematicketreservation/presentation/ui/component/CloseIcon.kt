package com.example.cinematicketreservation.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun CloseIcon(modifier: Modifier =Modifier ) {

    Box(modifier = modifier.wrapContentWidth().clip(CircleShape)) {
        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "close icon",
            modifier = Modifier
                .sizeIn(
                    maxWidth = Dp.Unspecified,
                    maxHeight = Dp.Unspecified
                )
                .padding(PaddingValues(8.dp))
        )
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .blur(16.dp)
                .background(Color.White.copy(alpha = .4f))

        )
    }
}

@Preview
@Composable
fun CloseIconPreview() {
    CloseIcon()
}