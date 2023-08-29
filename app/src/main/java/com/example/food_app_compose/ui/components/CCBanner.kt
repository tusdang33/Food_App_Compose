package com.example.food_app_compose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.food_app_compose.ui.theme.CCComposeTheme

@Composable
fun CCBanner(
	modifier: Modifier = Modifier,
	banner: String
) {
	Box(
		modifier = modifier.fillMaxWidth(),
		contentAlignment = Alignment.Center
	) {
		AsyncImage(
			modifier = Modifier
				.requiredHeightIn(170.dp)
				.requiredWidthIn(335.dp)
				.clip(RoundedCornerShape(12.dp)),
			model = banner,
			contentDescription = banner,
			contentScale = ContentScale.FillBounds
		)
	}
	
}

@Preview
@Composable
private fun PreviewCCBanner() {
	CCComposeTheme {
		CCBanner(banner = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOhSm1nr8n_izyS5M1Khv2tpsuC-DjCC1uH_4lXOLtPfVG_S0znW0dKJRbMTgJR_EFnRs&usqp=CAU")
	}
}