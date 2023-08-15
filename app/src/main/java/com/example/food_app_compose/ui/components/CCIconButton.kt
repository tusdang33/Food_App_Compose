package com.example.food_app_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.R

@Composable
fun CCIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enable: Boolean = true,
    size: Dp = 15.dp,
    backgroundColor: Color = Color.Unspecified,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable () -> Unit,
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(backgroundColor)
            .requiredHeightIn(size)
            .requiredWidthIn(size)
            .clickable(
                onClick = onClick,
                enabled = enable,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = rememberRipple()
            )
    ) {
        icon()
    }
    
}
@Preview
@Composable
fun PreFAButton() {
    CCIconButton(onClick = {},
    icon = {
        Image(painter = painterResource(id = R.drawable.active_profile_icon), contentDescription = "")
    })
}