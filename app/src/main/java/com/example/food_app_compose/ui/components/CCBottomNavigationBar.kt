package com.example.food_app_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.example.food_app_compose.R
import com.example.food_app_compose.common.TopLevelDestination
import com.example.food_app_compose.isTopLevelDestinationInHierarchy
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCBottomNavigationBar(
    modifier: Modifier = Modifier,
    destinations: List<TopLevelDestination>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (TopLevelDestination) -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 6.dp)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        destinations.forEach { itemNavigation ->
            val selected =
                currentDestination.isTopLevelDestinationInHierarchy(itemNavigation)
            CCBottomNavigationItem(
                modifier = Modifier,
                selected = selected,
                onClick = { onNavigateToDestination(itemNavigation) },
                icon = {
                    CCIconButton(onClick = {}, backgroundColor = Color.Transparent) {
                        Image(
                            painter = painterResource(
                                id = if (selected) itemNavigation.selectedIconRes else itemNavigation.unselectedIconRes
                            ), contentDescription = ""
                        )
                    }
                },
                label = {
                    Text(
                        text = itemNavigation.nameItem,
                        style = LocalTextStyle.current.copy(color = if (selected) CCTheme.colors.active else CCTheme.colors.bodyText)
                    )
                }
            )
        }
    }
}

@Preview()
@Composable
fun PreviewNavItem() {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        CCIconButton(
            onClick = { },
            size = 15.dp,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = ""
                )
            }
        )

        CCIconButton(
            onClick = { },
            size = 15.dp,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = ""
                )
            }
        )

        CCIconButton(
            onClick = { },
            size = 15.dp,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = ""
                )
            }
        )

        CCIconButton(
            onClick = { },
            size = 15.dp,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = ""
                )
            }
        )
    }
}