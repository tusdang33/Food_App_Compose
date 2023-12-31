package com.example.food_app_compose.presentation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.food_app_compose.presentation.profile.ProfileRoute

const val searchRoute = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null){
    this.navigate(searchRoute, navOptions)
}

fun NavGraphBuilder.searchGraph(){
    composable(
        route = searchRoute
    ){
        SearchRoute()
    }
}