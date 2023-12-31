package com.london.tictactoe.runtime.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.london.tictactoe.data.TicTacToeDestination
import com.london.tictactoe.ui.game.GameScreen
import com.london.tictactoe.ui.game.GameViewModel
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.GameAnimatedNavHost(navController: NavController) {
	navigation(
		startDestination = TicTacToeDestination.Game.Home.route,
		route = TicTacToeDestination.Game.Root.route
	) {
		composable(
			route = TicTacToeDestination.Game.Home.route,
			arguments = TicTacToeDestination.Game.Home.arguments,
			enterTransition = { fadeIn() },
			exitTransition = { fadeOut() },
			popEnterTransition = { fadeIn() },
			popExitTransition = { fadeOut() }
		) { backEntry ->
			val viewModel = hiltViewModel<GameViewModel>(backEntry)
			
			GameScreen(
				navController = navController,
				viewModel = viewModel
			)
		}
	}
}
