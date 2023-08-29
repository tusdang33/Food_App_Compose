package com.example.food_app_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCHomeTitle(
	modifier: Modifier = Modifier,
	title: String,
	onSeeAll: (String) -> Unit,
) {
	Row(
		modifier = modifier,
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(text = title, style = CCTheme.typography.h3)
		Text(
			modifier = Modifier
				.weight(1f)
				.clickable { onSeeAll.invoke(title) },
			text = "See all",
			textAlign = TextAlign.End,
			style = CCTheme.typography.caption.copy(color = CCTheme.colors.active)
		)
	}
}

@Preview
@Composable
private fun PreviewCCHomeTitle() {
	CCComposeTheme {
		CCHomeTitle(title = "HEHEHEH", onSeeAll = {})
	}
}