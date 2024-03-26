package com.example.androiddevcert.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevcert.Screens

data class BottomNavigationItem(
    val label: String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Article",
                icon = Icons.Filled.Edit,
                route = Screens.Article.route
            ),
            BottomNavigationItem(
                label = "Task",
                icon = Icons.Filled.Check,
                route = Screens.Task.route
            ),
            BottomNavigationItem(
                label = "Quadrant",
                icon = Icons.Filled.Email,
                route = Screens.Quadrant.route
            )
        )
    }
}
