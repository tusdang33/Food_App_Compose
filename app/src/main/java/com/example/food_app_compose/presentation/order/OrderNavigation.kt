package com.example.food_app_compose.presentation.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val orderRoute = "order_route"

fun NavController.navigateToOrder(navOptions: NavOptions? = null){
    this.navigate(orderRoute, navOptions)
}

fun NavGraphBuilder.orderGraph(){
    composable(
        route = orderRoute
    ){
        OrderRoute()
    }
}