package com.example.food_app_compose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.food_app_compose.R

internal val YuGothicUi = FontFamily(
    Font(R.font.yu_gothic_ui_light, FontWeight.ExtraLight),
    Font(R.font.yu_gothic_ui_semi_light, FontWeight.Light),
    Font(R.font.yu_gothic_ui_regular, FontWeight.Normal),
    Font(R.font.yu_gothic_ui_semi_bold, FontWeight.SemiBold),
    Font(R.font.yu_gothic_ui_bold, FontWeight.Bold),
)

@Immutable
data class CCTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val headline: TextStyle,
    val body: TextStyle,
    val subhead: TextStyle,
    val caption: TextStyle,
    val button: TextStyle,
)

val TextStyle.yuGothicUi: TextStyle
    get() = this.copy(fontFamily = YuGothicUi)

val LocalCCTypography = staticCompositionLocalOf {
    CCTypography(
        h1 = TextStyle.Default,
        h2 = TextStyle.Default,
        h3 = TextStyle.Default,
        headline = TextStyle.Default,
        body = TextStyle.Default,
        subhead = TextStyle.Default,
        caption = TextStyle.Default,
        button = TextStyle.Default,
    )
}