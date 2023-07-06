package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.cinematicketreservation.AppDestination

@Composable
fun MovieDetailsScreen(navController: NavController) {
    MovieDetailsContent(
        onClickClose = { navController.popBackStack() },
        onClickButton = { navController.navigate(AppDestination.CinemaHall.route) })
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
    MovieDetailsContent({},{})
}