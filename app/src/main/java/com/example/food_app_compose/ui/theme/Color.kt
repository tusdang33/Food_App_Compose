package com.example.food_app_compose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val CCActiveColor = Color(0xFFEEA734)
internal val CCAccentColor = Color(0xFFEF9920)
internal val CCMainColor = Color(0xFF010F07)
internal val CCBodyText = Color(0xFF868686)
internal val CCInactive = Color(0xFFE3E3E3)
internal val CCWhite = Color(0xFFFFFFFF)

@Immutable
data class CCColors(
    val active: Color,
    val accent: Color,
    val main: Color,
    val bodyText: Color,
    val inactive: Color,
    val white: Color,
)

//Local
val LocalCCColors = staticCompositionLocalOf {
    CCColors(
        active = Color.Unspecified,
        accent = Color.Unspecified,
        main = Color.Unspecified,
        bodyText = Color.Unspecified,
        inactive = Color.Unspecified,
        white = Color.Unspecified
    )
}