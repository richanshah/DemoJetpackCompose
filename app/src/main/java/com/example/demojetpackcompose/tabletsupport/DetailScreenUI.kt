package com.example.demojetpackcompose.tabletsupport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.demojetpackcompose.tabletsupport.CustomData
import com.example.demojetpackcompose.tabletsupport.dummyDataList

@Composable
fun DetailScreenUI() {
    val windowSize = rememberWindowSize()
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(dummyDataList()){
            AdaptableItem(data = it, windowSize = windowSize)
        }
    }
}

@Composable
fun AdaptableItem(data: CustomData, windowSize: WindowSize) {
    val maxLines by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 4 else 10) }

    when (windowSize.height) {
        WindowType.Expanded -> {
            Column {
                ColumnContent(data = data, windowSize = windowSize, maxLines = maxLines)
            }
        }
        else -> {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RowContent(data = data, windowSize = windowSize, maxLines = maxLines
                )
            }
        }
    }
}

@Composable
fun RowContent(
	data: CustomData,
	windowSize: WindowSize,
	maxLines: Int
) {
    Image(
        painter = painterResource(id = data.image),
        contentDescription = "img",
        modifier = Modifier.width(200.dp).height(150.dp).padding(bottom = 10.dp),
        contentScale = ContentScale.Crop
    )

    Column(verticalArrangement = Arrangement.Center , modifier = Modifier.fillMaxWidth()) {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.h4.fontSize
                    WindowType.Medium -> MaterialTheme.typography.h5.fontSize
                    else -> MaterialTheme.typography.h6.fontSize
                },
                fontWeight = FontWeight.Bold,
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.alpha(ContentAlpha.disabled),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.h5.fontSize
                    WindowType.Medium -> MaterialTheme.typography.h6.fontSize
                    else -> MaterialTheme.typography.body1.fontSize
                }
            )
        )
    }
}

@Composable
fun ColumnContent(
	data: CustomData,
	windowSize: WindowSize,
	maxLines: Int
) {
    Image(
        painter = painterResource(id = data.image),
        contentDescription = "img",
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        contentScale = ContentScale.Crop
    )

    Column {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.h4.fontSize
                    else -> MaterialTheme.typography.h6.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(ContentAlpha.disabled),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.h5.fontSize
                    else -> MaterialTheme.typography.body1.fontSize
                }
            )
        )

    }
}