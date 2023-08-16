package com.example.food_app_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.food_app_compose.presentation.authentication.signin.navigation.navigateToSignIn
import com.example.food_app_compose.presentation.authentication.signin.navigation.signInGraph
import com.example.food_app_compose.presentation.authentication.signup.navigation.navigateToSignUp
import com.example.food_app_compose.presentation.authentication.signup.navigation.signUpGraph
import com.example.food_app_compose.presentation.home.homeGraph
import com.example.food_app_compose.presentation.home.navigateToHome
import com.example.food_app_compose.presentation.order.orderGraph
import com.example.food_app_compose.presentation.profile.profileGraph
import com.example.food_app_compose.presentation.search.searchGraph
import com.example.food_app_compose.presentation.splash.splashGraph
import com.example.food_app_compose.presentation.splash.splashRoute

@Composable
fun CCBottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = splashRoute) {
        splashGraph(
            navigateToHome = { navController.navigateToHome() },
            navigateToSignIn = { navController.navigateToSignIn() })
        homeGraph()
        searchGraph()
        orderGraph()
        profileGraph()
        signInGraph(
            navigateToHome = { navController.navigateToHome() },
            navigateToSignUp = { navController.navigateToSignUp() })
        signUpGraph(
            navigateToSignIn = { navController.navigateToSignIn() },
            navigateToHome = { navController.navigateToHome() }
        )
    }
}
