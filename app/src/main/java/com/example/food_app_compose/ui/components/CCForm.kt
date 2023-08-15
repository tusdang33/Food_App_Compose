package com.example.food_app_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CCForm(
	modifier: Modifier = Modifier,
	label: String? = null,
	value: TextFieldValue,
	onValueChange: (TextFieldValue) -> Unit,
	enabled: Boolean = true,
	readOnly: Boolean = false,
	textColor: Color = CCTheme.colors.main,
	fontSize: TextUnit = TextUnit.Unspecified,
	fontStyle: FontStyle? = null,
	fontWeight: FontWeight? = null,
	fontFamily: FontFamily? = null,
	letterSpacing: TextUnit = TextUnit.Unspecified,
	textDecoration: TextDecoration? = null,
	textAlign: TextAlign? = null,
	placeholder: @Composable (() -> Unit)? = null,
	leadingIcon: @Composable (() -> Unit)? = null,
	trailingIcon: @Composable (() -> Unit)? = null,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
	keyboardActions: KeyboardActions = KeyboardActions.Default,
	singleLine: Boolean = false,
	maxLines: Int = Int.MAX_VALUE,
	textStyle: TextStyle = LocalTextStyle.current,
	backgroundColor: Color = CCTheme.colors.white,
	cursorColor: Color = CCTheme.colors.accent,
	interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
	
	val style = textStyle.merge(
		TextStyle(
			color = textColor,
			fontSize = fontSize,
			fontWeight = fontWeight,
			textAlign = textAlign,
			fontFamily = fontFamily,
			textDecoration = textDecoration,
			fontStyle = fontStyle,
			letterSpacing = letterSpacing
		)
	)
	
	val colors = TextFieldDefaults.textFieldColors(
		containerColor = backgroundColor,
		focusedIndicatorColor = Color.Transparent,
		unfocusedIndicatorColor = Color.Transparent,
		disabledSupportingTextColor = Color.Transparent,
		cursorColor = cursorColor
	)
	
	Column(modifier = modifier) {
		Text(
			text = (label ?: "").uppercase(),
			style = CCTheme.typography.caption.copy(
				color = CCTheme.colors.main.copy(alpha = 0.5f),
				fontWeight = FontWeight.Light
			)
		)
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			leadingIcon?.invoke()
			TextField(
				modifier = Modifier.fillMaxWidth(),
				value = value,
				onValueChange = onValueChange,
				enabled = enabled,
				readOnly = readOnly,
				textStyle = style,
				placeholder = placeholder,
				leadingIcon = leadingIcon,
				trailingIcon = trailingIcon,
				keyboardActions = keyboardActions,
				keyboardOptions = keyboardOptions,
				singleLine = singleLine,
				maxLines = maxLines,
				colors = colors,
				interactionSource = interactionSource
			)
			trailingIcon?.invoke()
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CCForm(
	modifier: Modifier = Modifier,
	label: String? = null,
	value: String,
	onValueChange: (String) -> Unit,
	enabled: Boolean = true,
	readOnly: Boolean = false,
	textColor: Color = CCTheme.colors.main,
	fontSize: TextUnit = TextUnit.Unspecified,
	fontStyle: FontStyle? = null,
	fontWeight: FontWeight? = null,
	fontFamily: FontFamily? = null,
	lineHeight: TextUnit = TextUnit.Unspecified,
	letterSpacing: TextUnit = TextUnit.Unspecified,
	textDecoration: TextDecoration? = null,
	textAlign: TextAlign? = null,
	placeholder: @Composable (() -> Unit)? = null,
	leadingIcon: @Composable (() -> Unit)? = null,
	trailingIcon: @Composable (() -> Unit)? = null,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
	keyboardActions: KeyboardActions = KeyboardActions.Default,
	singleLine: Boolean = false,
	maxLines: Int = Int.MAX_VALUE,
	visualTransformation: VisualTransformation = VisualTransformation.None,
	textStyle: TextStyle = LocalTextStyle.current,
	backgroundColor: Color = CCTheme.colors.white,
	cursorColor: Color = CCTheme.colors.accent,
	interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
	
	val style = textStyle.merge(
		TextStyle(
			color = textColor,
			fontSize = fontSize,
			fontWeight = fontWeight,
			textAlign = textAlign,
			fontFamily = fontFamily,
			textDecoration = textDecoration,
			fontStyle = fontStyle,
			letterSpacing = letterSpacing,
			lineHeight = lineHeight
		)
	)
	
	val colors = TextFieldDefaults.textFieldColors(
		containerColor = backgroundColor,
		focusedIndicatorColor = CCTheme.colors.inactive,
		unfocusedIndicatorColor = CCTheme.colors.inactive,
		disabledSupportingTextColor = Color.Transparent,
		cursorColor = cursorColor
	)
	
	Column(modifier = modifier) {
		if (!label.isNullOrBlank()) {
			Text(
				modifier = Modifier.fillMaxWidth(),
				text = label.uppercase(),
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.Normal
				)
			)
		}
		Spacer(modifier = Modifier.height(5.dp))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			BasicTextField(
				modifier = Modifier
					.fillMaxWidth()
					.requiredHeightIn(
						min = 24.dp
					),
				value = value,
				cursorBrush = SolidColor(cursorColor),
				onValueChange = onValueChange,
				enabled = enabled,
				readOnly = readOnly,
				textStyle = style,
				keyboardActions = keyboardActions,
				keyboardOptions = keyboardOptions,
				singleLine = singleLine,
				maxLines = maxLines,
				interactionSource = interactionSource,
				visualTransformation = visualTransformation,
				decorationBox = @Composable { innerTextField ->
					TextFieldDefaults.TextFieldDecorationBox(
						value = value,
						innerTextField = innerTextField,
						leadingIcon = leadingIcon,
						trailingIcon = trailingIcon,
						enabled = enabled,
						singleLine = singleLine,
						visualTransformation = visualTransformation,
						interactionSource = interactionSource,
						colors = colors,
						placeholder = placeholder,
						contentPadding = TextFieldDefaults
							.textFieldWithoutLabelPadding(
								top = 10.dp, bottom = 8.dp,
								start = 0.dp
							)
					)
				},
			)
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCCForm() {
	CCComposeTheme {
		var text by remember {
			mutableStateOf("")
		}
		CCForm(
			value = text,
			onValueChange = {
				text = it
			},
			label = "Test Label",
			trailingIcon = {
				Image(
					painter = painterResource(id = R.drawable.arrow_left),
					contentDescription = ""
				)
			}
		)
	}
}