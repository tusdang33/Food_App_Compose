package com.example.food_app_compose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CCComposeTheme(
    content: @Composable () -> Unit
) {
    val ccColor = CCColors(
        active = CCActiveColor,
        accent = CCAccentColor,
        main = CCMainColor,
        bodyText = CCBodyText,
        inactive = CCInactive,
        white = CCWhite,
    )

    @Suppress("DEPRECATION")
    val ccTypography = CCTypography(
        h1 = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 34.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 42.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h2 = TextStyle(
            fontFamily = YuGothicUi,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        h3 = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 32.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        headline = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 34.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 42.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        body = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        subhead = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 28.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        caption = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 20.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        button = TextStyle(
            fontFamily = YuGothicUi,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 22.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
    )

    CompositionLocalProvider(
        LocalCCColors provides ccColor,
        LocalCCTypography provides ccTypography,
        content = content
    )
}

object CCTheme {
    val colors: CCColors
        @Composable
        get() = LocalCCColors.current

    val typography: CCTypography
        @Composable
        get() = LocalCCTypography.current
}