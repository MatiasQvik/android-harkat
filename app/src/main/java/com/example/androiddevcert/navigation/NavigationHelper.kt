package com.example.androiddevcert.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val screens = listOf("Home", "Article", "Task")
    var selectedScreen by remember { mutableStateOf(screens.first()) }
    Scaffold(
        bottomBar = {
                BottomNavigation {
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

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            ReturnScreen(screen = selectedScreen)

        }
    }
}

fun getIconForScreen(screen: String) : ImageVector {
    return when (screen) {
        "Home" -> Icons.Default.Home
        "Article" -> Icons.Default.Edit
        "Task" -> Icons.Default.Check
        else -> Icons.Default.Home
    }
}

