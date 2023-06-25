package com.example.food_app_compose.presentation.splash

import android.net.wifi.hotspot2.pps.HomeSp
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun SplashRoute(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
) {

}

@Composable
fun SplashScreen(

) {
    Surface(modifier = Modifier.fillMaxSize()) {
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
                    text = "Tamang \nFoodService",
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
                text = "Welcome",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = CCTheme.typography.h1.copy(fontWeight = FontWeight(800))
            )
            Text(
                modifier = Modifier.padding(24.dp),
                text = "It’s a pleasure to meet you. We are excited that you’re here so let’s get started!",
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