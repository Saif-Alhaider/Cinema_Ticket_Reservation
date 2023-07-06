package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R

@Composable
fun HomeBackGround(@DrawableRes backgroundImage: Int) {
    val saturationFactor = 1.1f
    val colorMatrix = floatArrayOf(
        0.213f + 0.787f * saturationFactor,
        0.715f - 0.715f * saturationFactor,
        0.072f - 0.072f * saturationFactor,
        0f,
        0f,
        0.213f - 0.213f * saturationFactor,
        0.715f + 0.285f * saturationFactor,
        0.072f - 0.072f * saturationFactor,
        0f,
        0f,
        0.213f - 0.213f * saturationFactor,
        0.715f - 0.715f * saturationFactor,
        0.072f + 0.928f * saturationFactor,
        0f,
        0f,
        0f,
        0f,
        0f,
        1f,
        0f
    )
    val gradientBrush = Brush.verticalGradient(
        0f to Color(0xFF000000),
        1f to Color(0xFF000000),
    )
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier.fillMaxSize()
        ) {
        Image(
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
            painter = painterResource(id = backgroundImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .blur(radius = 100.dp)
                .height(300.dp)
                .fadingEdge(gradientBrush)

        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeBackgroundPreview() {
    HomeBackGround(R.drawable.image_1)
}

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(alpha = 0.99f)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }