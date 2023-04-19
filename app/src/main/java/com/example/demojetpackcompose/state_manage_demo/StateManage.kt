package com.example.demojetpackcompose.state_manage_demo

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demojetpackcompose.ui.theme.darkOrange
import com.example.demojetpackcompose.ui.theme.white

@SuppressLint("UnrememberedMutableState")
@Composable
fun StateManageDemo(viewModel: StateMangeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
	val count = viewModel.count.collectAsState().value

	CounterView(count = count, onClickCountBtn = {
		viewModel.updateCount()
	})
}

@Composable
fun CounterView(count: Int, onClickCountBtn: () -> Unit) {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Log.i("TagCount", "Count:${count}")

		Text(
			text = "${count}",
			fontSize = 40.sp,
			modifier = Modifier.padding(20.dp)
		)
		Button(
			colors = ButtonDefaults.buttonColors(
				contentColor = MaterialTheme.colors.white,
				containerColor = MaterialTheme.colors.darkOrange
			),
			onClick = {
				onClickCountBtn()
				Log.i("TagCount", "after clicked Count:${count}")
			}) {
			Text(
				text = "Update Count",
				fontSize = 16.sp
			)
		}
	}
}

