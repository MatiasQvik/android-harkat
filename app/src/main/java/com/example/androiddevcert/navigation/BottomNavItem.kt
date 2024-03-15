package com.example.androiddevcert.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val screenRoute: String) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "home")
    object Article : BottomNavItem("Article", Icons.Default.Edit, "article")
}