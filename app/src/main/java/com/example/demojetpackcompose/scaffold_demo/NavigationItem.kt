package com.example.demojetpackcompose.scaffold_demo

import com.example.demojetpackcompose.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Profile : NavigationItem("profile", R.drawable.ic_person_24, "Profile")
    object Setting : NavigationItem("setting", R.drawable.ic_settings_24, "Setting")
    object Share : NavigationItem("share", R.drawable.ic_share_24, "Share")
    object Logout : NavigationItem("logout", R.drawable.ic_logout_24, "Logout")
}
