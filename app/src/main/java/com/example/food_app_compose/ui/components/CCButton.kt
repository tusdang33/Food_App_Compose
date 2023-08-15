package com.example.food_app_compose.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCButton(
	modifier: Modifier = Modifier,
	buttonSize: Dp = 48.dp,
	enable: Boolean = true,
	shape: Shape = RoundedCornerShape(8.dp),
	enableColor: Color = CCTheme.colors.active,
	disableColor: Color = CCTheme.colors.inactive,
	textStyle: TextStyle = CCTheme.typography.button.copy(color = CCTheme.colors.white),
	contentPaddingValues: PaddingValues = ButtonDefaults.ContentPadding,
	interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
	onClick: () -> Unit,
	content: @Composable RowScope.() -> Unit
) {
	val enabled by remember(enable) {
		mutableStateOf(enable)
	}
	
	val backgroundColor by animateColorAsState(
		targetValue = when (enabled) {
			true -> enableColor
			false -> disableColor
		}, label = ""
	)
	
	Box(
		propagateMinConstraints = true,
		modifier = Modifier
			.requiredHeightIn(buttonSize)
			.then(modifier)
			.clip(shape)
			.background(backgroundColor)
			.clickable(
				interactionSource = interactionSource,
				indication = rememberRipple(),
				enabled = enabled,
				role = Role.Button,
				onClick = onClick
			)
			.padding(contentPaddingValues)
	) {
		CompositionLocalProvider(LocalTextStyle provides textStyle) {
			Row(
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
				content = content,
			)
		}
	}
	
}

@Preview(showBackground = true)
@Composable
private fun PreviewCCButton() {
	CCComposeTheme {
		CCButton(
			onClick = {},
			enable = true,
			enableColor = CCTheme.colors.accent,
			disableColor = CCTheme.colors.inactive
		) {
			Text(text = "heheheh")
		}
	}
}