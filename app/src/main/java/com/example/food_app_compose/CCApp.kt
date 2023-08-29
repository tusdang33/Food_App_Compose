package com.example.food_app_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.navigation.CCBottomNavGraph
import com.example.food_app_compose.ui.components.CCBottomNavigationBar
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CCApp() {
    val appState = rememberAppState()
    CCComposeTheme() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                CompositionLocalProvider(
                    LocalTextStyle provides CCTheme.typography.body,
                    LocalContentColor provides CCTheme.colors.white
                ) {
                    if (appState.isShowBottomBar) {
                        CCBottomNavigationBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .background(CCTheme.colors.white),
                            destinations = appState.itemNavigation,
                            currentDestination = appState.currentDestination,
                            onNavigateToDestination = {
                                appState.navigateToTopLevelDestination(it)
                            },
                        )
                    }
                }
            }
        ) { contentPadding ->
            CCBottomNavGraph(
                modifier = Modifier
                    .padding(contentPadding)
                    .consumeWindowInsets(contentPadding),
                navController = appState.navController
            )
        }
    }
}