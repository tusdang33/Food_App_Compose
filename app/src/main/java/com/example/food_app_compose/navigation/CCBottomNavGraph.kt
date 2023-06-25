package com.example.food_app_compose.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.food_app_compose.presentation.home.HomeRoute
import com.example.food_app_compose.presentation.home.homeGraph
import com.example.food_app_compose.presentation.home.homeRoute
import com.example.food_app_compose.presentation.order.OrderRoute
import com.example.food_app_compose.presentation.order.orderGraph
import com.example.food_app_compose.presentation.profile.ProfileRoute
import com.example.food_app_compose.presentation.profile.profileGraph
import com.example.food_app_compose.presentation.search.SearchRoute
import com.example.food_app_compose.presentation.search.searchGraph
import com.example.food_app_compose.presentation.splash.splashGraph
import com.example.food_app_compose.presentation.splash.splashRoute

@Composable
fun CCBottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = splashRoute) {
        splashGraph()
        homeGraph()
        searchGraph()
        orderGraph()
        profileGraph()
    }
}
