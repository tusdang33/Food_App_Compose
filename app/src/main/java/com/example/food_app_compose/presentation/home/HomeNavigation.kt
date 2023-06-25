package com.example.food_app_compose.presentation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeRoute = "home_route"

fun NavController.navigateToHome(

){
    this.navigate(homeRoute)
}

fun NavGraphBuilder.homeGraph(
){
    composable(
        route = homeRoute
    ){
        HomeRoute()
    }
}