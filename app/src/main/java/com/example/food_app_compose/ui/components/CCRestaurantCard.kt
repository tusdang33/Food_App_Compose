package com.example.food_app_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCRestaurantCard(
	modifier: Modifier = Modifier,
	restaurantImage: String
) {
	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.spacedBy(10.dp)
	) {
		AsyncImage(
			modifier = Modifier
				.requiredWidthIn(defaultRestaurantCardWidth)
				.requiredHeightIn(defaultRestaurantCardHeight)
				.clip(RoundedCornerShape(12.dp)),
			model = ImageRequest.Builder(LocalContext.current)
				.data(restaurantImage)
				.crossfade(true)
				.build(),
			contentDescription = restaurantImage,
			contentScale = ContentScale.FillBounds
		)
		Text(text = "FoodName", style = CCTheme.typography.subhead)
		Row(
			modifier = Modifier.width(defaultRestaurantCardWidth),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceAround
		) {
			Text(
				modifier = Modifier,
				text = stringResource(id = R.string.dot) + "${(1..3).random()}",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center
			)
			Text(
				modifier = Modifier,
				text = stringResource(id = R.string.dot) + "${(10..60).random()}min",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center
			)
			Text(
				modifier = Modifier,
				text = stringResource(id = R.string.dot) + "Free delivery",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
			
			Text(
				modifier = Modifier,
				text = stringResource(id = R.string.dot) + "Free delivery",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
		}
		Row(
			modifier = Modifier.width(defaultRestaurantCardWidth),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceAround
		) {
			Text(
				modifier = Modifier,
				text = "4.3",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
			Image(
				painter = painterResource(id = R.drawable.star),
				contentDescription = "",
			)
			Text(
				modifier = Modifier,
				text = "200+ rating",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
			Image(painter = painterResource(id = R.drawable.timer), contentDescription = "")
			Text(
				modifier = Modifier,
				text = "25 min",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
			Image(painter = painterResource(id = R.drawable.dollar), contentDescription = "")
			Text(
				modifier = Modifier,
				text = "• Free",
				style = CCTheme.typography.caption.copy(
					color = CCTheme.colors.bodyText,
					fontWeight = FontWeight.SemiBold
				),
				textAlign = TextAlign.Center,
			)
		}
	}
}

@Preview
@Composable
private fun PreviewCCRestaurantCard() {
	CCComposeTheme {
		CCRestaurantCard(restaurantImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOhSm1nr8n_izyS5M1Khv2tpsuC-DjCC1uH_4lXOLtPfVG_S0znW0dKJRbMTgJR_EFnRs&usqp=CAU")
	}
}

val defaultRestaurantCardWidth = 335.dp
val defaultRestaurantCardHeight = 185.dp