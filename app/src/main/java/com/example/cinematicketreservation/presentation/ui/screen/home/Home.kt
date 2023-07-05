package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cinematicketreservation.presentation.ui.component.MovieCard
import com.example.cinematicketreservation.presentation.ui.component.MovieTitle
import com.example.cinematicketreservation.presentation.ui.component.MovieTime
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical16Dp
import com.example.cinematicketreservation.presentation.ui.component.SpacerVertical32Dp
import com.example.cinematicketreservation.presentation.viewModel.HomeViewModel
import com.example.cinematicketreservation.presentation.viewModel.MovieUiState
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    HomeContent(
        viewModel.moviesList, viewModel.state.collectAsState(), viewModel::updateState
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    moviesData: List<MovieUiState>, screenState: State<MovieUiState>, updateUiState: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    val selectedItemIndex = remember { mutableStateOf(0) }
    val isFirstElement = remember { mutableStateOf(false) }

    Box() {
        HomeBackGround(screenState.value.imageRes)
        Column(
            Modifier.padding(top = 32.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            SpacerVertical32Dp()
            LazyRow(
                state = listState,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 32.dp),
                flingBehavior = snapFlingBehavior,
            ) {
                itemsIndexed(moviesData) { index, movie ->
                    val isCurrentElement = selectedItemIndex.value == index

                    val itemIndex = when {
                        isCurrentElement && !isFirstElement.value -> selectedItemIndex.value
                        isFirstElement.value-> 0
                        else -> selectedItemIndex.value
                    }

                    val scale = when {
                        isCurrentElement && !isFirstElement.value -> 1.1f
                        isFirstElement.value && !isCurrentElement -> 1.1f
                        else -> 1f
                    }
                    updateUiState(itemIndex)
                    Box(
                        modifier = Modifier
                            .graphicsLayer(
                                scaleX = scale,
                                scaleY = scale,
                            )
                            .padding(8.dp)
                    ) {
                        MovieCard(
                            imageRes = movie.imageRes,
                        )
                    }

                }
            }

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
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }.distinctUntilChanged()
            .collect { visibleItems ->
                selectedItemIndex.value = (visibleItems.firstOrNull()?.index ?: -1) + 1
                isFirstElement.value = (visibleItems.lastOrNull()?.index ?: -1) == 1
            }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeContentPreview() {
    HomeScreen()
}
