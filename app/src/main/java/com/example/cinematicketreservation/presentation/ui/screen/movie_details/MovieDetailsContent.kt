package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.navigateToCinemaHall

@Composable
fun MovieDetailsScreen(navController: NavController) {
    val context = LocalContext.current
    MovieDetailsContent(
        onClickClose = { navController.popBackStack() },
        onClickButton = {
            navController
                .navigateToCinemaHall(
                    context
                        .getString(R.string.doctor_strange_in_the_multiverse_of_madness)
                )
        })
}

@Composable
fun MovieDetailsContent(onClickClose: () -> Unit, onClickButton: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        UpperSection(onClickClose)
        SlidingPanel(
            onClickButton = onClickButton,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsPreview() {
    MovieDetailsContent({}, {})
}