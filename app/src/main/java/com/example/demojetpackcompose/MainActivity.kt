package com.example.demojetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.demojetpackcompose.sampleui.*
import com.example.demojetpackcompose.state_manage_demo.StateManageDemo

class MainActivity : ComponentActivity() {
	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			Column(
				modifier = Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				StateManageDemo()
				/*			SampleText()
							SampleSpacer()
							SampleTextField()
							SampleSpacer()
							SampleButton(context = LocalContext.current)
							SampleSpacer()
							SampleBox()
							SampleSpacer()
							SampleRadioGroup()
							SampleSpacer()
							SampleToggles()
							SampleSpacer()
							SampleSlider()*/
			}
		}

	}
}
