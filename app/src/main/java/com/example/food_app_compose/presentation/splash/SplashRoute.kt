package com.example.food_app_compose.presentation.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCTheme
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val splashEvent by splashViewModel.oneTimeEvent.collectAsStateWithLifecycle(initialValue = null)
    
    SideEffect{
        splashViewModel.onEvent(SplashEvent.CheckCurrentUser)
    }

    when(splashEvent){
        is SplashOneTimeEvent.LoginSuccess -> navigateToHome.invoke()
        is SplashOneTimeEvent.LoginFail -> navigateToSignIn.invoke()
        else -> {/*noop*/}
    }
    
    SplashScreen(modifier = Modifier.fillMaxSize())
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        val color = CCTheme.colors.accent
        Canvas(modifier = Modifier) {
            drawCircle(
                radius = 270.dp.toPx(),
                center = Offset(100.dp.toPx(), 120.dp.toPx()),
                color = color.copy(alpha = 0.1f)
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp),
            ) {
                val (imageRef, textRef) = createRefs()
                Image(
                    modifier = Modifier.constrainAs(imageRef) {
                        top.linkTo(textRef.top)
                        bottom.linkTo(textRef.bottom)
                        end.linkTo(textRef.start)
                        start.linkTo(parent.start)
                    },
                    painter = painterResource(id = R.drawable.logo_app),
                    contentDescription = "logo_app"
                )
                Text(
                    modifier = Modifier.constrainAs(textRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.top)
                        start.linkTo(imageRef.end)
                        end.linkTo(parent.end)
                    },
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.splash_title),
                    fontSize = 37.sp,
                    fontWeight = FontWeight(800)
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.human_img),
                    contentDescription = "human"
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = stringResource(id = R.string.welcome),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = CCTheme.typography.h1.copy(fontWeight = FontWeight(800))
            )
            Text(
                modifier = Modifier.padding(24.dp),
                text = stringResource(id = R.string.splash_description),
                textAlign = TextAlign.Center, style = CCTheme.typography.body
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewSplashScreen() {
    SplashScreen()
}