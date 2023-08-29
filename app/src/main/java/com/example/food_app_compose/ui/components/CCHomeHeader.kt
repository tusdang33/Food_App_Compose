package com.example.food_app_compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.food_app_compose.R
import com.example.food_app_compose.ui.theme.CCComposeTheme
import com.example.food_app_compose.ui.theme.CCTheme

@Composable
fun CCHomeHeader(
	modifier: Modifier = Modifier,
	streetName: String = stringResource(id = R.string.street)
) {
	Box(
		modifier = modifier
	) {
		Column(
			modifier = Modifier.fillMaxWidth(),
			verticalArrangement = Arrangement.spacedBy(5.dp)
		) {
			Text(
				modifier = Modifier.fillMaxWidth(),
				text = stringResource(id = R.string.delivery),
				textAlign = TextAlign.Center,
				style = CCTheme.typography.caption.copy(color = CCTheme.colors.active)
			)
			Text(
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center,
				text = streetName,
				style = CCTheme.typography.subhead
			)
		}
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.BottomEnd),
			textAlign = TextAlign.End,
			text = stringResource(id = R.string.filter)
		)
	}
}

@Preview
@Composable
private fun PreviewCCHomeHeader() {
	CCComposeTheme {
		CCHomeHeader()
	}
}