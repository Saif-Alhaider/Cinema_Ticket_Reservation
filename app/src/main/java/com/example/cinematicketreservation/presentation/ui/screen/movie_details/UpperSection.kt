package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.cinematicketreservation.R

@Composable
fun UpperSection(onClickClose: () -> Unit) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        MovieImage(image = R.drawable.image_4, modifier = Modifier.align(Alignment.TopStart))
        PlayButton(modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                val intent =
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=roJ0ZpDwAeY")
                    )
                startActivity(context,intent,null)
            })
        AppBar(onClickClose)
    }
}

@Preview(showSystemUi = true)
@Composable
fun UpperSectionPreview() {
    UpperSection() {}
}