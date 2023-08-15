package com.example.food_app_compose.presentation.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val profileRoute = "profile_route"

fun NavController.navigateToProfile(navOptions: NavOptions? = null){
    this.navigate(profileRoute, navOptions)
}

fun NavGraphBuilder.profileGraph(){
    composable(
        route = profileRoute
    ){
        ProfileRoute()
    }
}