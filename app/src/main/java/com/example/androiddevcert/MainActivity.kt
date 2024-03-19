package com.example.androiddevcert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androiddevcert.navigation.MainScreenView
import com.example.androiddevcert.navigation.songHelper
import com.example.androiddevcert.ui.theme.AndroidDevCertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Functions().notifStarter()
        songHelper()
        Functions().starterFunction()
        setContent {
            AndroidDevCertTheme {

                MainScreenView()
            }
        }
    }
}
