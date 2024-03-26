package com.example.androiddevcert.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevcert.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val screens = listOf("Home", "Article", "Task", "Quadrant")
    var selectedScreen by remember { mutableStateOf(screens.first()) }
    Scaffold(
        bottomBar = {
                BottomNavigation() {
                        screens.forEach {screen ->
                            BottomNavigationItem(
                                    icon = { Icon(getIconForScreen(screen), contentDescription = screen) },
                                    label = { Text(screen)},
                                    selected = screen == selectedScreen,
                                    onClick = { selectedScreen = screen},
                                    modifier = Modifier.padding(8.dp)
                                )
                        }
                }
        }

    ) {innerPadding -> innerPadding.calculateBottomPadding()
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            ReturnScreen(screen = selectedScreen)

        }
    }
}

@Composable
fun BottomNavigationBar() {
    var navigationSelectedItem by remember { mutableStateOf(0) }

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = { Text(navigationItem.label )},
                        icon = { Icon(navigationItem.icon,
                            contentDescription = navigationItem.label)},
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(navController)
            }
            composable(Screens.Article.route) {
                ArticleScreen(navController)
            }
            composable(Screens.Task.route) {
                TaskCompletedScreen(navController)
            }
            composable(Screens.Quadrant.route) {
                ComposeQuadrantScreen(navController)
            }
        }
    }

}

@Composable
fun

fun getIconForScreen(screen: String) : ImageVector {
    return when (screen) {
        "Home" -> Icons.Default.Home
        "Article" -> Icons.Default.Edit
        "Task" -> Icons.Default.Check
        "Quadrant" -> Icons.Default.Email
        else -> Icons.Default.Home
    }
}

