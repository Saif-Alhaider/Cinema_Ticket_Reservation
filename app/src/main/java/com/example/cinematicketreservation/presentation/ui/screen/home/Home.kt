package com.example.cinematicketreservation.presentation.ui.screen.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cinematicketreservation.presentation.ui.component.MovieCard
import com.example.cinematicketreservation.presentation.ui.component.MovieDescription
import com.example.cinematicketreservation.presentation.ui.component.MovieTime
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical16Dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical32Dp
import com.example.cinematicketreservation.presentation.viewModel.HomeViewModel
import com.example.cinematicketreservation.presentation.viewModel.MovieUiState
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    HomeContent(
        viewModel.moviesList,
        viewModel.state.collectAsState(),
        viewModel::updateState
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    moviesData: List<MovieUiState>,
    screenState:
    State<MovieUiState>,
    updateUiState: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    val selectedItemIndex = remember { mutableStateOf(0) }
    val isFirstElement = remember { mutableStateOf(false) }

    Box() {
        HomeBackGround()
        Column(
            Modifier
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            SpacerVertical32Dp()
            LazyRow(
                state = listState,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                flingBehavior = snapFlingBehavior,
            ) {
                itemsIndexed(moviesData) { index, movie ->
                    updateUiState(index)
                    val scale =
                        if (selectedItemIndex.value == index && !isFirstElement.value) 1.1f else if (isFirstElement.value && selectedItemIndex.value != index) 1.1f else 1f
                    Box(
                        modifier = Modifier
                            .graphicsLayer(
                                scaleX = scale,
                                scaleY = scale,
                            )
                            .padding(16.dp)
                    ) {
                        MovieCard(
                            imageRes = movie.imageRes,
                        )
                    }

                }
            }

            SpacerVertical32Dp()
            MovieTime()
            SpacerVertical16Dp()
            MovieDescription(screenState.value.description)
            SpacerVertical32Dp()
            Genre()
        }
    }
    LaunchedEffect(listState) {

        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .distinctUntilChanged()
            .collect { visibleItems ->
                selectedItemIndex.value = (visibleItems.firstOrNull()?.index ?: -1) + 1
                isFirstElement.value = (visibleItems.lastOrNull()?.index ?: -1) == 1
                Log.i("gg", "HomeContent: ${isFirstElement.value}")
            }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview() {
    HomeScreen()
}
