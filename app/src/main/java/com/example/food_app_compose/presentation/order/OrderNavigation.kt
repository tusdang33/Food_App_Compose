package com.example.food_app_compose.presentation.order

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val orderRoute = "order_route"

fun NavController.navigateToOrder(){
    this.navigate(orderRoute)
}

fun NavGraphBuilder.orderGraph(){
    composable(
        route = orderRoute
    ){
        OrderRoute()
    }
}