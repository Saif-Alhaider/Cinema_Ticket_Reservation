package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cinematicketreservation.presentation.ui.component.MovieCard
import com.example.cinematicketreservation.presentation.viewModel.MovieUiState
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesCarousel(
    modifier: Modifier = Modifier,
    imageWidth: Dp,
    imageHeight:Dp,
    movies: List<MovieUiState>,
    navigateMovie:()->Unit,
    updateUiState: (Int) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val listState = rememberLazyListState()
    val selectedItemIndex = remember { mutableStateOf(0) }
    val isFirstElement = remember { mutableStateOf(false) }
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }.distinctUntilChanged()
            .collect { visibleItems ->
                selectedItemIndex.value = (visibleItems.firstOrNull()?.index ?: -1) + 1
                isFirstElement.value = (visibleItems.lastOrNull()?.index ?: -1) == 1
            }
    }
    LazyRow(
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = contentPadding,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState),
        modifier = modifier
    ) {
        itemsIndexed(movies) { index, movie ->
            val isCurrentElement = selectedItemIndex.value == index

            val itemIndex = when {
                isCurrentElement && !isFirstElement.value -> selectedItemIndex.value
                isFirstElement.value -> 0
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
                    .padding(horizontal = 8.dp)
            ) {
                MovieCard(
                    imageRes = movie.imageRes,
                    width = imageWidth,
                    height = imageHeight,
                    onImageClick = navigateMovie
                )
            }

        }
    }
}