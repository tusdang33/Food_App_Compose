package com.example.food_app_compose.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.food_app_compose.ui.theme.CCTheme
import kotlinx.coroutines.delay

@Composable
fun CCLoading(
	modifier: Modifier = Modifier,
	circleSize: Dp = 15.dp,
	circleColor: Color = CCTheme.colors.active,
	spaceBetween: Dp = 10.dp,
	travelDistance: Dp = 20.dp
) {
	val circles = listOf(
		remember { Animatable(initialValue = 0f) },
		remember { Animatable(initialValue = 0f) },
		remember { Animatable(initialValue = 0f) }
	)
	
	circles.forEachIndexed { index, anim ->
		LaunchedEffect(key1 = anim) {
			delay(index * 100L)
			anim.animateTo(
				targetValue = 1f,
				animationSpec = infiniteRepeatable(
					animation = keyframes {
						durationMillis = 1200
						0.0f at 0 with LinearOutSlowInEasing
						1.0f at 300 with LinearOutSlowInEasing
						0.0f at 600 with LinearOutSlowInEasing
						0.0f at 1200 with LinearOutSlowInEasing
					},
					repeatMode = RepeatMode.Restart
				)
			)
		}
	}
	
	val circleValues = circles.map { it.value }
	val distance = with(LocalDensity.current) { travelDistance.toPx() }
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(color = CCTheme.colors.inactive.copy(alpha = 0.3f)).zIndex(2f),
		contentAlignment = Alignment.Center
	) {
		Row(
			modifier = modifier,
			horizontalArrangement = Arrangement.spacedBy(spaceBetween),
		) {
			circleValues.forEach { value ->
				Box(
					modifier = Modifier
						.size(circleSize)
						.graphicsLayer {
							translationY = -value * distance
						}
						.background(
							color = circleColor,
							shape = CircleShape
						)
				)
			}
		}
	}
}