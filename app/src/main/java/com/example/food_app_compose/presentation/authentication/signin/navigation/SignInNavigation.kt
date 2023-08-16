package com.example.food_app_compose.presentation.authentication.signin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val signInRoute = "sign_in_route"

fun NavController.navigateToSignIn() {
	this.navigate(signInRoute)
}

fun NavGraphBuilder.signInGraph(
	navigateToHome: () -> Unit,
	navigateToSignUp: () -> Unit
) {
	composable(route = signInRoute) {
		SignInRoute(
			navigateToHome = navigateToHome,
			navigateToSignUp = navigateToSignUp
		)
	}
}