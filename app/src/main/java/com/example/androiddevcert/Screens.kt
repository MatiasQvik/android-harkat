package com.example.androiddevcert

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Article : Screens("article_screen")
    object Task : Screens("task_screen")
    object Quadrant : Screens("quadrant_screen")
}