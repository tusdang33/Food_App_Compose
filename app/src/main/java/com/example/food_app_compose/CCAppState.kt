package com.example.food_app_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.food_app_compose.common.TopLevelDestination
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
fun rememberAppState(
    navController: NavHostController = rememberNavController()
): CCAppState {
    return remember {
        CCAppState(navController = navController)
    }
}

class CCAppState(val navController: NavHostController) {
    val itemNavigation = TopLevelDestination.values().asList()
    
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination
    
    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> TopLevelDestination.HOME
            searchRoute -> TopLevelDestination.SEARCH
            orderRoute -> TopLevelDestination.ORDER
            profileRoute -> TopLevelDestination.PROFILE
            else -> null
        }
    
    val isShowBottomBar: Boolean
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
    
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
        
        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
            TopLevelDestination.SEARCH -> navController.navigateToSearch(topLevelNavOptions)
            TopLevelDestination.ORDER -> navController.navigateToOrder(topLevelNavOptions)
            TopLevelDestination.PROFILE -> navController.navigateToProfile(topLevelNavOptions)
        }
    }
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false