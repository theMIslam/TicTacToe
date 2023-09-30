package com.london.tictactoe.runtime.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.london.tictactoe.data.TicTacToeDestination
import com.london.tictactoe.ui.score.ScoreScreen
import com.london.tictactoe.ui.score.ScoreViewModel
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.ScoreAnimatedNavHost(navController: NavController) {
	navigation(
		startDestination = TicTacToeDestination.Score.Home.route,
		route = TicTacToeDestination.Score.Root.route
	) {
		composable(
			route = TicTacToeDestination.Score.Home.route,
			enterTransition = { fadeIn() },
			exitTransition = { fadeOut() },
			popEnterTransition = { fadeIn() },
			popExitTransition = { fadeOut() }
		) { backEntry ->
			val viewModel = hiltViewModel<ScoreViewModel>(backEntry)
			
			ScoreScreen(
				navController = navController,
				viewModel = viewModel
			)
		}
	}
}
