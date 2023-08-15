package com.example.food_app_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.food_app_compose.presentation.authentication.signin.signInGraph
import com.example.food_app_compose.presentation.authentication.signin.signInRoute
import com.example.food_app_compose.presentation.home.homeGraph
import com.example.food_app_compose.presentation.home.navigateToHome
import com.example.food_app_compose.presentation.order.navigateToOrder
import com.example.food_app_compose.presentation.order.orderGraph
import com.example.food_app_compose.presentation.profile.profileGraph
import com.example.food_app_compose.presentation.search.searchGraph
import com.example.food_app_compose.presentation.splash.splashGraph
import com.example.food_app_compose.presentation.splash.splashRoute

@Composable
fun CCBottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = signInRoute) {
        splashGraph(
            navigateToHome = { navController.navigateToHome() },
            navigateToSignIn = { navController.navigateToOrder() })
        homeGraph()
        searchGraph()
        orderGraph()
        profileGraph()
        signInGraph(
            navigateToHome = {navController.navigateToHome()},
            navigateToSignUp = {navController.navigateToHome()})
    }
}
