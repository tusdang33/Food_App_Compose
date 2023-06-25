package com.example.food_app_compose.presentation.order

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OrderRoute() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = " This is order")
    }
}