package com.example.demojetpackcompose.constraint_demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.demojetpackcompose.R
import com.example.demojetpackcompose.ui.theme.*


@Composable
fun ConstraintLayoutSample() {

    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colors.darkOrange,
                            MaterialTheme.colors.darkYellow,
                        )
                    )
                ).padding(8.dp)

        ) {

            // Creating references
            val (logo, title, subtitle, favorite) = createRefs()

            createVerticalChain(title,subtitle, chainStyle = ChainStyle.Packed)

            val startGuideLine = createGuidelineFromStart(12.dp)

            val endBarrier = createEndBarrier(title,subtitle)

            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "logo",
                modifier = Modifier
                    .constrainAs(logo) {
                        start.linkTo(startGuideLine)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Text(text = "Sample Title",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color= MaterialTheme.colors.black,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(logo.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(subtitle.top)
                    }
            )

            Text(text = "Sub Title big sample text",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color= MaterialTheme.colors.black,
                modifier = Modifier
                    .constrainAs(subtitle) {
                        start.linkTo(logo.end)
                        top.linkTo(title.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "favorite",
                modifier = Modifier
                    .size(36.dp)
                    .constrainAs(favorite) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(endBarrier)
                    }

            )
        }

    }

}

@Preview
@Composable
fun PreviewConstraint() {
    ConstraintLayoutSample()
}