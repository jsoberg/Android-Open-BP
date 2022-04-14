package com.soberg.openbp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.soberg.openbp.ui.reading.list.BpReadingListScreen

@Composable
fun OpenBpNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = OpenBpScreen.List.route,
        modifier = modifier
    ) {
        composable(OpenBpScreen.List.route) {
            BpReadingListScreen(
                viewModel = hiltViewModel(),
            )
        }
    }
}