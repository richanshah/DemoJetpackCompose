package com.example.demojetpackcompose.scaffold_demo

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.demojetpackcompose.R
import com.example.demojetpackcompose.ui.theme.black
import com.example.demojetpackcompose.ui.theme.darkOrange
import com.example.demojetpackcompose.ui.theme.hintColor
import com.example.demojetpackcompose.ui.theme.white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationDrawerUI() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val context = LocalContext.current

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Setting,
        NavigationItem.Share,
        NavigationItem.Logout
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(scope = scope, scaffoldState = scaffoldState)
        },
        drawerContent = {
            DrawerContainer(
                scope = scope,
                scaffoldState = scaffoldState,
                navController = navController
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { Toast.makeText(context, "Click Me", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        },
        bottomBar = { BottomNavBar(navController = navController, item = items) },
    ) {
        Navigation(navController = navController, modifier = Modifier.padding(it))
    }
}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Navigation Drawer", fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },

        backgroundColor = MaterialTheme.colors.darkOrange,
        contentColor = Color.White,
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings_24),
                contentDescription = "menu",
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Setting icon click", Toast.LENGTH_SHORT)
                            .show()
                    },
                tint = MaterialTheme.colors.white
            )

        }
    )
}


@Composable
fun BottomNavBar(
    navController: NavController,
    item: List<NavigationItem>
) {
    BottomNavigation(
        elevation = 15.dp, modifier = Modifier.height(55.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        item.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = "")
                },
                label = { Text(text = it.title) },
                selected = currentRoute == it.route,
                selectedContentColor = MaterialTheme.colors.black,
                unselectedContentColor = MaterialTheme.colors.white,
                modifier = Modifier.background(MaterialTheme.colors.darkOrange),
                onClick = {
                    if (currentRoute != it.route) {
                        navController.navigate(it.route)
                    }
                },
                alwaysShowLabel = true,
            )
        }
    }
}

@Composable
fun DrawerContainer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Setting,
        NavigationItem.Share,
        NavigationItem.Logout
    )


    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)

        ) {
            Image(modifier = Modifier.fillMaxSize().alpha(.6f),
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "bg",
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.compose),
                    contentDescription = "",
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Text(
                    text = "Jetpack Compose",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp),
                    fontSize = 18.sp
                )
            }


        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))


    }
}

@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit) {
    val background = if (selected) MaterialTheme.colors.darkOrange else MaterialTheme.colors.white
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(background)
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}


@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreen()
        }

        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }

        composable(NavigationItem.Setting.route) {
            SettingsScreen()
        }

        composable(NavigationItem.Share.route) {

        }

        composable(NavigationItem.Logout.route) {

        }

    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Home Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Profile Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Setting Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}