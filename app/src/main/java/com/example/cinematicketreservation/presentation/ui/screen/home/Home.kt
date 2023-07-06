package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematicketreservation.AppDestination
import com.example.cinematicketreservation.presentation.ui.component.MovieTime
import com.example.cinematicketreservation.presentation.ui.component.MovieTitle
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical16Dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical32Dp
import com.example.cinematicketreservation.presentation.viewModel.HomeViewModel
import com.example.cinematicketreservation.presentation.viewModel.MovieUiState

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    HomeContent(
        viewModel.moviesData.data,
        viewModel.state.collectAsState(),
        viewModel::updateState
    ) { navController.navigate(AppDestination.MovieDetails.route) }
}

@Composable
fun HomeContent(
    moviesData: List<MovieUiState>,
    screenState: State<MovieUiState>,
    updateUiState: (Int) -> Unit,
    navigateMovie: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val imageWidth = 264.dp
    val scaledImageWidth = imageWidth + imageWidth * 0.07f
    val centerCarouselPadding =
        PaddingValues(horizontal = (screenWidth.div(2).dp - scaledImageWidth.div(2)))
    LazyColumn(
        Modifier.background(
            Brush.verticalGradient(
                0F to Color.Transparent,
                .3f to Color.Black,
                .8f to Color.White,
                1F to Color.White,
            )
        )
    ) {
        item {
            Box() {
                HomeBackGround(screenState.value.imageRes)
                Column(
                    Modifier.padding(top = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Header()
                    SpacerVertical32Dp()
                    MoviesCarousel(
                        movies = moviesData,
                        updateUiState = updateUiState,
                        contentPadding = centerCarouselPadding,
                        imageWidth = imageWidth,
                        imageHeight = 400.dp,
                        navigateMovie = navigateMovie
                    )
                    SpacerVertical32Dp()
                    SpacerVertical32Dp()
                    MovieTime(
                        screenState.value.duration,
                        textColor = Color.Black.copy(alpha = .87f)
                    )
                    SpacerVertical16Dp()
                    MovieTitle(screenState.value.title)
                    SpacerVertical32Dp()
                    Genre(screenState.value.genres)
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview() {
    val movieUiState = remember { mutableStateOf(MovieUiState()) }
    HomeContent(emptyList(), movieUiState,{},{})
}
