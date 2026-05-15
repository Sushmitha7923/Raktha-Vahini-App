package com.raktavahini.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.raktavahini.app.ui.screens.RegisterScreen
import com.raktavahini.app.ui.screens.SearchScreen
import com.raktavahini.app.ui.screens.DonorListScreen

import com.raktavahini.app.viewmodel.DonorViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // Shared ViewModel
    val viewModel: DonorViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "register"
    ) {

        composable("register") {
            RegisterScreen(navController, viewModel)
        }

        composable("search") {
            SearchScreen(navController, viewModel)
        }

        composable(
            route = "list/{blood}",
            arguments = listOf(
                navArgument("blood") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val blood = backStackEntry.arguments?.getString("blood") ?: ""

            DonorListScreen(
                blood = blood,
                viewModel = viewModel
            )
        }
    }
}