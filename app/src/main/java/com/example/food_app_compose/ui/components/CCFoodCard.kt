package com.example.food_app_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.HorizontalAlign
import androidx.constraintlayout.compose.VerticalAlign
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCFoodCard(
	modifier: Modifier = Modifier,
	foodImage: String
) {
	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.spacedBy(10.dp)
	) {
		AsyncImage(
			modifier = Modifier
				.requiredWidthIn(200.dp)
				.requiredHeightIn(160.dp)
				.clip(RoundedCornerShape(10.dp)),
			model = ImageRequest.Builder(LocalContext.current)
				.data(foodImage)
				.crossfade(true)
				.build(),
			contentDescription = foodImage,
			contentScale = ContentScale.FillBounds
		)
		Text(text = "FoodName", style = CCTheme.typography.subhead)
		Text(text = "Address", style = CCTheme.typography.body, color = CCTheme.colors.bodyText)
		Row(
			modifier = Modifier.width(200.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				modifier = Modifier
					.wrapContentSize()
					.clip(RoundedCornerShape(6.dp))
					.background(color = CCTheme.colors.active)
					.padding(vertical = 4.dp, horizontal = 8.dp),
				text = "4.5",
				style = CCTheme.typography.caption.copy(color = CCTheme.colors.white, fontWeight = FontWeight.SemiBold)
			)
			Text(
				modifier = Modifier.weight(1f),
				text = "25min",
				style = CCTheme.typography.button.copy(color = CCTheme.colors.bodyText),
				textAlign = TextAlign.Center
			)
			Text(
				modifier = Modifier,
				text = "Free delivery",
				style = CCTheme.typography.button.copy(color = CCTheme.colors.bodyText),
				textAlign = TextAlign.End,
				softWrap = false
			)
		}
		
	}
}

@Preview(showBackground = true)
@Composable
private fun PreviewCCFoodCard() {
	CCComposeTheme {
		CCFoodCard(
			modifier = Modifier.fillMaxSize(),
			foodImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOhSm1nr8n_izyS5M1Khv2tpsuC-DjCC1uH_4lXOLtPfVG_S0znW0dKJRbMTgJR_EFnRs&usqp=CAU"
		)
	}
}