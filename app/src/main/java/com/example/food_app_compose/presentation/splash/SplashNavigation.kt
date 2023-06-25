package com.example.food_app_compose.presentation.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val splashRoute = "splash_route"

fun NavController.navigateToSplash() {
    this.navigate(splashRoute)
}

fun NavGraphBuilder.splashGraph(
    navigateToSignIn: ()->Unit,
    navigateToHome: ()->Unit
) {
    composable(route = splashRoute) {
        SplashRoute(
            navigateToSignIn = navigateToSignIn,
            navigateToHome = navigateToHome,
        )
    }
}