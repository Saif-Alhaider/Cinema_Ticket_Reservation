package com.example.cinematicketreservation.presentation.ui.screen.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun MovieDetailsScreen(navController: NavController) {
    MovieDetailsContent(){navController.popBackStack()}
}
@Composable
fun MovieDetailsContent(onClickClose:()->Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        ) {
        UpperSection(onClickClose)
        SlidingPanel(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsPreview() {
    MovieDetailsContent(){}
}