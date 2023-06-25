package com.example.food_app_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.food_app_compose.presentation.splash.common.ItemNavigation
import com.example.food_app_compose.presentation.home.homeRoute
import com.example.food_app_compose.presentation.home.navigateToHome
import com.example.food_app_compose.presentation.order.navigateToOrder
import com.example.food_app_compose.presentation.order.orderRoute
import com.example.food_app_compose.presentation.profile.navigateToProfile
import com.example.food_app_compose.presentation.profile.profileRoute
import com.example.food_app_compose.presentation.search.navigateToSearch
import com.example.food_app_compose.presentation.search.searchRoute
import com.example.food_app_compose.presentation.splash.splashRoute


@Composable
fun rememberBottomBarState(
    navController: NavHostController = rememberNavController()
): CCBottomBarState {
    return remember {
        CCBottomBarState(navController = navController)
    }
}

class CCBottomBarState(val navController: NavHostController) {
    val itemNavigation = ItemNavigation.values().asList()

    val currentDestination: NavDestination?
        @Composable
        get() = this.navController.currentBackStackEntryAsState().value?.destination

    val isShowBottomBar : Boolean
    @Composable
    get() = run {
        val blackList = listOf(
            splashRoute
        )

        when {
            blackList.contains(currentDestination?.route) -> false
            else -> true
        }
    }

    fun navigateToDestination(route: String){
        when(route){
            homeRoute->navController.navigateToHome()
            searchRoute->navController.navigateToSearch()
            orderRoute->navController.navigateToOrder()
            profileRoute->navController.navigateToProfile()
        }
    }
}