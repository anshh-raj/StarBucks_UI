package com.example.starbucksui.data.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starbucksui.data.screens.HomeScreen
import com.example.starbucksui.data.screens.ProductDetailScreen
import com.example.starbucksui.data.screens.StartScreen

@Composable
fun Navigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = start) {
        composable(start){
            StartScreen(navHostController)
        }
        composable(home){
            HomeScreen(navHostController)
        }
        composable(product_detail){
            ProductDetailScreen(navHostController)
        }
    }
}

const val start = "start_screen"
const val home = "Home_screen"
const val product_detail = "product_detail_screen"