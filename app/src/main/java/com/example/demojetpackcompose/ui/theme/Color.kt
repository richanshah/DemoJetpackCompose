package com.example.demojetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.txtColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFD4C2FA) else Color(0xFF0F0F0F)

val Colors.white: Color
    @Composable
    get() = Color(0xFFFFFFFF)

val Colors.black: Color
    @Composable
    get() = Color(0xFF000000)

val Colors.darkOrange: Color
	@Composable
	get() = Color(0xFFFF5722)

val Colors.darkYellow: Color
	@Composable
	get() = Color(0xFFFFC107)


val Colors.hintColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF7E7D7D) else Color(0xFF7E7D7D)