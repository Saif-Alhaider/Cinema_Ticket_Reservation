package com.example.cinematicketreservation.presentation.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ROUTE = "home"

fun NavGraphBuilder.homeRoute(navController: NavController, innerPadding: PaddingValues) {
    composable(ROUTE)
    { Box(Modifier.padding(innerPadding)) { HomeScreen(navController = navController) } }
}

