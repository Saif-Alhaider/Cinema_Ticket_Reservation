package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematicketreservation.R
import com.example.cinematicketreservation.presentation.ui.screen.cinema_hall.navigateToCinemaHall
import com.example.cinematicketreservation.presentation.viewModel.MovieDetailsViewModel
import com.example.cinematicketreservation.presentation.viewModel.state.MovieUiState

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val movie = viewModel.state.collectAsState().value
    MovieDetailsContent(
        onClickClose = { navController.popBackStack() },
        onClickButton = {
            navController
                .navigateToCinemaHall(
                    context
                        .getString(R.string.doctor_strange_in_the_multiverse_of_madness)
                )
        }, movie = movie
    )
}

@Composable
fun MovieDetailsContent(onClickClose: () -> Unit, onClickButton: () -> Unit, movie: MovieUiState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        UpperSection(onClickClose,movie.secondPosterRes,movie.youtubeKey)
        SlidingPanel(
            movieTitle = movie.title,
            movieDescription = movie.description,
            onClickButton = onClickButton,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsPreview() {
    MovieDetailsContent({}, {}, MovieUiState(title = "Doctor Strange"))
}