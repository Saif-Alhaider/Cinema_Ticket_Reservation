package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.ui.component.ItemButton
import com.example.cinematicketreservation.presentation.ui.component.MovieDescription
import com.example.cinematicketreservation.presentation.ui.component.MovieTitle
import com.example.cinematicketreservation.presentation.ui.screen.home.Genre

@Composable
fun SlidingPanel(
    movieTitle: String,
    movieDescription: String,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
    genres: List<String>
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .fillMaxWidth()
            .fillMaxHeight(0.55f)
            .background(Color.White)
            .offset(y = 32.dp)
            .then(modifier)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ) {
            RatingSection(modifier = Modifier.padding(PaddingValues(horizontal = 50.dp)))
            MovieTitle(movieText = movieTitle)
            Genre(genres)
            CastSection(
                actorsimages = listOf(
                    R.drawable.image_1,
                    R.drawable.image_2,
                    R.drawable.image_3,
                    R.drawable.image_4,
                    R.drawable.image_1,
                    R.drawable.image_2,
                    R.drawable.image_3,
                    R.drawable.image_4
                ),
                contentPadding = PaddingValues(horizontal = 16.dp)
            )
            MovieDescription(movieDescription)
            ItemButton(
                onClick = onClickButton,
                text = stringResource(R.string.booking),
                textColor = Color.White,
                iconResource = R.drawable.ic_card, iconColor = Color.White.copy(alpha = .87f),
                modifier = Modifier.padding(bottom = 32.dp + 16.dp)
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SlidingPanelPreview() {
    SlidingPanel(
        "Morbius",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
        onClickButton = {},
        genres = listOf()
    )
}