package com.example.food_app_compose.presentation.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchRoute() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = " This is search")
    }
}