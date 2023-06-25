package com.example.food_app_compose.presentation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.food_app_compose.presentation.profile.ProfileRoute

const val searchRoute = "search_route"

fun NavController.navigateToSearch(){
    this.navigate(searchRoute)
}

fun NavGraphBuilder.searchGraph(){
    composable(
        route = searchRoute
    ){
        SearchRoute()
    }
}