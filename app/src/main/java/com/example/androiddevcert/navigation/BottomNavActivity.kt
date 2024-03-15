package com.example.androiddevcert.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevcert.Functions

class BottomNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Functions().notifStarter()
        songHelper()
        Functions().starterFunction()
        setContent {
            MainScreenView()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    val screens = listOf("Home", "Article")
    val selectedScreen by remember { mutableStateOf(screens.first()) }
    Scaffold(
        bottomBar = {}
    ) {it
        BottomBarNavGraph(navController = navController)

    }
}

@Composable
fun BottomBarNavGraph(navController: NavController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(route = BottomNavItem.Home.screenRoute) {
            HomeScreen()
        }
        composable(route = BottomNavItem.Article.screenRoute) {
            ArticleScreen()
        }
    }
}

@Composable
fun BottomBar( navController: NavController) {}

