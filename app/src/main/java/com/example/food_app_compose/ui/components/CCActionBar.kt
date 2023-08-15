package com.example.food_app_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.components.FAActionBarDefaults.MinHeight
import com.example.food_app_compose.ui.components.FAActionBarDefaults.PaddingHorizontal
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCActionBar(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (RowScope.() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .sizeIn(minHeight = MinHeight)
            .padding(horizontal = PaddingHorizontal)
    ) {
        val (leadRef, trailRef, contentRef) = createRefs()

        Box(modifier = Modifier.constrainAs(leadRef) {
            centerVerticallyTo(parent)
            start.linkTo(parent.start)
        }) {
            if (leadingIcon != null) {
                leadingIcon()
            }
        }

        Box(modifier = Modifier.constrainAs(trailRef) {
            centerVerticallyTo(parent)
            end.linkTo(parent.end)
        }) {
            if (trailingIcon != null) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = trailingIcon
                )
            }
        }

        Box(modifier = Modifier.constrainAs(contentRef) {
            centerTo(parent)
        }) {
            CompositionLocalProvider(LocalTextStyle provides CCTheme.typography.h2) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewActionBar() {
    CCComposeTheme() {
        CCActionBar(
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_left),
                        contentDescription = ""
                    )
                }
            }
        ) {
            Text(
                text = "Featured Partners",
                style = CCTheme.typography.subhead .copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

object FAActionBarDefaults {
    val PaddingHorizontal = 12.dp
    val MinHeight = 60.dp
}