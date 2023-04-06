package com.example.demojetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.demojetpackcompose.R

// Set of Material typography styles to start with
val Typography = Typography(
	body1 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	)
	/* Other default text styles to override
	button = TextStyle(
			fontFamily = FontFamily.Default,
			fontWeight = FontWeight.W500,
			fontSize = 14.sp
	),
	caption = TextStyle(
			fontFamily = FontFamily.Default,
			fontWeight = FontWeight.Normal,
			fontSize = 12.sp
	)
	*/
)
val sf_bold = FontFamily(
	Font(
		R.font.sf_bold
	)
)

val sf_regular = FontFamily(
	Font(
		R.font.sf_regular
	)
)

val raleway_regular = FontFamily(
	Font(
		R.font.raleway_regular
	)
)
val raleway_heavy = FontFamily(
	Font(
		R.font.raleway_heavy
	)
)
val raleway_light = FontFamily(
	Font(
		R.font.raleway_light
	)
)
val raleway_medium = FontFamily(
	Font(
		R.font.raleway_medium
	)
)
val raleway_semibold = FontFamily(
	Font(
		R.font.raleway_semibold
	)
)

val raleway_bold = FontFamily(
	Font(
		R.font.raleway_bold
	)
)

val raleway_extrabold = FontFamily(
	Font(
		R.font.raleway_extrabold
	)
)
