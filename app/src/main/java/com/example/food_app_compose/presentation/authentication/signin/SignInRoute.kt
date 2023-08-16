package com.example.food_app_compose.presentation.authentication.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.components.CCActionBar
import com.example.food_app_compose.ui.components.CCButton
import com.example.food_app_compose.ui.components.CCForm
import com.example.food_app_compose.ui.components.CCIconButton
import com.example.food_app_compose.ui.components.CCLoading
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun SignInRoute(
	navigateToHome: () -> Unit,
	navigateToSignUp: () -> Unit,
	signInViewModel: SignInViewModel = hiltViewModel()
) {
	val signInUiState by signInViewModel.uiState.collectAsStateWithLifecycle()
	val signInOneTimeEvent by signInViewModel.oneTimeEvent.collectAsStateWithLifecycle(initialValue = null)

	SignInScreen(
		modifier = Modifier
			.background(CCTheme.colors.white)
			.fillMaxSize()
			.padding(20.dp),
		signInUiState = signInUiState,
		onEvent = signInViewModel::onEvent,
		navigateToSignUp = navigateToSignUp
	)
	
	when (signInOneTimeEvent) {
		is SignInOneTimeEvent.Loading -> {
			CCLoading()
		}
		
		is SignInOneTimeEvent.Success -> {
			navigateToHome.invoke()
		}
		
		is SignInOneTimeEvent.Fail -> {
			//noop
		}
		
		else -> {
			//noop
		}
	}
}

@Composable
fun SignInScreen(
	modifier: Modifier = Modifier,
	signInUiState: SignInUiState,
	onEvent: (SignInEvent) -> Unit,
	navigateToSignUp: () -> Unit,
) {
	Surface(modifier = modifier) {
		Column(
			modifier = Modifier.background(CCTheme.colors.white),
			verticalArrangement = Arrangement.spacedBy(20.dp)
		) {
			CCActionBar(modifier = Modifier.fillMaxWidth()) {
				Text(
					text = stringResource(id = R.string.sign_in),
					style = CCTheme.typography.body.copy(fontWeight = FontWeight.SemiBold)
				)
			}
			Text(
				modifier = Modifier.padding(vertical = 20.dp),
				text = stringResource(id = R.string.signin_title),
				style = CCTheme.typography.h1
			)
			Text(
				modifier = Modifier,
				text = stringResource(id = R.string.signin_description),
				style = CCTheme.typography.body.copy(color = CCTheme.colors.bodyText)
			)
			
			CCForm(
				modifier = Modifier.fillMaxWidth(),
				value = signInUiState.email,
				onValueChange = {
					onEvent(SignInEvent.OnEmailChange(it))
				},
				label = stringResource(id = R.string.email_label),
				textStyle = CCTheme.typography.body
			)
			CCForm(
				modifier = Modifier.wrapContentHeight(),
				value = signInUiState.password,
				onValueChange = {
					onEvent(SignInEvent.OnPasswordChange(it))
				},
				label = stringResource(id = R.string.password_label),
				textStyle = CCTheme.typography.body,
				visualTransformation = if (signInUiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
				trailingIcon = {
					CCIconButton(
						onClick = {
							onEvent(SignInEvent.OnPasswordVisibleChange(!signInUiState.isPasswordVisible))
						},
						icon = {
							Icon(
								modifier = Modifier.size(36.dp),
								painter = painterResource(id = R.drawable.invisible),
								contentDescription = ""
							)
						})
				}
			)
			
			CCButton(
				modifier = Modifier.fillMaxWidth(),
				onClick = {
					onEvent(SignInEvent.OnLogin)
				}
			) {
				Text(text = stringResource(id = R.string.signin_button))
			}
			Spacer(modifier = Modifier.height(5.dp))
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.offset(0.dp, (-20).dp),
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = stringResource(id = R.string.dont_have_account))
				Spacer(modifier = Modifier.width(5.dp))
				Text(
					modifier = Modifier.clickable {
						navigateToSignUp.invoke()
					},
					text = stringResource(id = R.string.create_account),
					color = CCTheme.colors.active
				)
			}
		}
		
	}
}

@Preview
@Composable
private fun PreviewSignInScreen() {
	CCComposeTheme {
		SignInScreen(
			modifier = Modifier
				.background(Color.White)
				.fillMaxSize()
				.padding(20.dp),
			signInUiState = SignInUiState(),
			onEvent = {
				
			}
		) {}
	}
}