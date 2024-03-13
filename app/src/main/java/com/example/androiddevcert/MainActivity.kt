package com.example.androiddevcert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevcert.ui.theme.AndroidDevCertTheme

lateinit var tempUnit: String
lateinit var degreeAmount: String
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Functions().notifStarter()
        songHelper()
        Functions().starterFunction()
        setContent {
            Column(modifier = Modifier.padding(2.dp)) {

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                        .height(60.dp)
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Column(modifier = Modifier.weight(2f)) {
                        DegreesAmountTextField()
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        TempUnits()
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        CalcButton()
                    }
                }
            }
        }
    }
}

@Composable
private fun CalcButton () {
    OutlinedButton(modifier = Modifier
        .fillMaxSize(),
        contentPadding = PaddingValues(1.dp),
            onClick = {
        if (::tempUnit.isInitialized && ::degreeAmount.isInitialized && degreeAmount.isNotBlank()) {
            Functions().tempCalculator(degreeAmount.toDouble(), tempUnit)
        } else println("MATU: Error Calc")
    }) {
        Text(text = "Calc")
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun DegreesAmountTextField() {
    var degreesAmountAsTextField by remember {mutableStateOf(TextFieldValue(""))}
    OutlinedTextField(
        modifier = Modifier
            .fillMaxSize()
            .onKeyEvent {
                if (it.nativeKeyEvent.keyCode == 66) {

                    if (::tempUnit.isInitialized && ::degreeAmount.isInitialized && degreeAmount.isNotBlank()) {
                        Functions().tempCalculator(degreeAmount.toDouble(), tempUnit)
                    } else println("MATU: Error Calc")
                }
                false
            },
        value = degreesAmountAsTextField,
        onValueChange = { it -> degreesAmountAsTextField = it
                        degreeAmount = it.text},
        label = { Text(text = "Degrees")},
        placeholder = {Text(text = ("40"))},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            if (::tempUnit.isInitialized && ::degreeAmount.isInitialized && degreeAmount.isNotEmpty()) {
                Functions().tempCalculator(degreeAmount.toDouble(), tempUnit)
            } else println("MATU: Error Calc")})
        )
}

@Composable
private fun TempUnits(
) {
    var expanded by remember { mutableStateOf(false) }

    var buttonText by remember {
        mutableStateOf("Temp Unit")
    }
    OutlinedButton(onClick = {expanded = !expanded},
        contentPadding = PaddingValues(1.dp),
        modifier = Modifier
            .fillMaxSize()
        ) {
        Text(text = buttonText)
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(text = { Text("F" )}, onClick = {
            tempUnit = "F"
            expanded =! expanded
            if (::tempUnit.isInitialized) {
                buttonText = tempUnit
            }
        })
        Divider()
        DropdownMenuItem(text = { Text("C") }, onClick = {
            tempUnit = "C"
            expanded =! expanded
            if (::tempUnit.isInitialized) {
                buttonText = tempUnit
            }
        })
        Divider()
        DropdownMenuItem(text = { Text("K") }, onClick = {
            tempUnit = "K"
            expanded =! expanded
            if (::tempUnit.isInitialized) {
                buttonText = tempUnit
            }
        })
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDevCertTheme {
        Greeting("Android")
    }
}

fun songHelper() {
    val song1 = Song("Viva La Vida", "Coldplay", "2008",1956476814)
    val song2 = Song("Song 2", "Blur", "1997", 837143021)
    val song3 = Song("Luomus", "Wiimeinen Mammutti", "2024", 997)
    val songList = mutableListOf(song1, song2, song3)
    songList.forEach{printSongDescription(it)}
}