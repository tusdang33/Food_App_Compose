package com.example.food_app_compose.common

import androidx.annotation.DrawableRes
import com.example.food_app_compose.R
import com.example.food_app_compose.presentation.home.homeRoute
import com.example.food_app_compose.presentation.order.orderRoute
import com.example.food_app_compose.presentation.profile.profileRoute
import com.example.food_app_compose.presentation.search.searchRoute

enum class TopLevelDestination(
    @DrawableRes
    val selectedIconRes: Int,
    @DrawableRes
    val unselectedIconRes: Int,
    val nameItem: String,
    val route: String
) {
    HOME(
        R.drawable.active_home_icon,
        R.drawable.deactive_home_icon,
        "Home",
        homeRoute
    ),
    SEARCH(
        R.drawable.active_search_icon,
        R.drawable.deactive_search_icon,
        "Search",
        searchRoute
    ),
    ORDER(
        R.drawable.active_order_icon,
        R.drawable.deactive_order_icon,
        "Order",
        orderRoute
    ),
    PROFILE(
        R.drawable.active_profile_icon,
        R.drawable.deactive_profile_icon,
        "Profile",
        profileRoute
    ),
}