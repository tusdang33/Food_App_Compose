package com.example.food_app_compose.presentation.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val profileRoute = "profile_route"

fun NavController.navigateToProfile(){
    this.navigate(profileRoute)
}

fun NavGraphBuilder.profileGraph(){
    composable(
        route = profileRoute
    ){
        ProfileRoute()
    }
}