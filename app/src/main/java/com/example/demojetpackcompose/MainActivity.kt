package com.example.demojetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.demojetpackcompose.databinding.ActivityMainBinding
import com.vv.jetpackcomposedemo.sampleui.*

class MainActivity : ComponentActivity() {
	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			Column(
				modifier = Modifier.wrapContentSize(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				SampleText()
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
				SampleSlider()
			}
		}

	}
}
