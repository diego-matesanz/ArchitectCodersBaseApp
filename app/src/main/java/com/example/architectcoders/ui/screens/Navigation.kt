package com.example.architectcoders.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.architectcoders.books
import com.example.architectcoders.ui.screens.detail.DetailScreen
import com.example.architectcoders.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onClick = { book ->
                navController.navigate("detail/${book.id}")
            })
        }
        composable(
            "detail/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            DetailScreen(
                book = books.first { it.id == bookId },
                onBack = { navController.popBackStack() }
            )
        }
    }
}