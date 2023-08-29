package com.example.food_app_compose.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.components.CCBanner
import com.example.food_app_compose.ui.components.CCFoodCard
import com.example.food_app_compose.ui.components.CCHomeHeader
import com.example.food_app_compose.ui.components.CCHomeTitle
import com.example.food_app_compose.ui.components.CCRestaurantCard
import com.example.food_app_compose.ui.theme.CCComposeTheme

@Composable
fun HomeRoute() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {
        CCHomeHeader(modifier = Modifier.padding(top = 10.dp))
        CCBanner(banner = "https://picsum.photos/536/354")
        CCHomeTitle(title = "Featured \nPartners", onSeeAll = {})
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints.copy(maxWidth = constraints.maxWidth + 40.dp.roundToPx()))
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, 0)
                    }
                },
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(10) {
                CCFoodCard(foodImage = "https://picsum.photos/536/354")
            }
        }
        CCBanner(banner = "https://picsum.photos/536/354")
        CCHomeTitle(title = "Featured \nPartners", onSeeAll = {})
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints.copy(maxWidth = constraints.maxWidth + 40.dp.roundToPx()))
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, 0)
                    }
                },
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(10) {
                CCFoodCard(foodImage = "https://picsum.photos/536/354")
            }
        }
        CCHomeTitle(title = "Featured \nPartners", onSeeAll = {})
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints.copy(maxWidth = constraints.maxWidth + 40.dp.roundToPx()))
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, 0)
                    }
                },
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(10) {
                CCRestaurantCard(restaurantImage = "https://picsum.photos/536/354")
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeRoute() {
    CCComposeTheme {
        HomeRoute()
    }
}