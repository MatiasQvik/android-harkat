package com.example.androiddevcert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.Modifier
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
        setContent {
            Column(modifier = Modifier.padding(2.dp)) {

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentHeight(Alignment.CenterVertically),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    DegreesAmountTextField()
                    TempUnits()
                    CalcButton()
                }
            }
        }
    }
}

@Composable
private fun CalcButton () {
    Box(modifier = Modifier
        .fillMaxWidth(0.33F)){
        OutlinedButton(onClick = {
            if (::tempUnit.isInitialized && ::degreeAmount.isInitialized) {
                Functions().tempCalculator(degreeAmount.toDouble(), tempUnit)
            } else println("MATU: Error Calc")
        }) {
            Text(text = "Calc")
        }
    }
}

@Composable
private fun DegreesAmountTextField() {
    var degreesAmountAsTextField by remember {mutableStateOf(TextFieldValue(""))}
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(0.33F),
        value = degreesAmountAsTextField,
        onValueChange = { it -> degreesAmountAsTextField = it
                        degreeAmount = it.text},
        label = { Text(text = "Degrees")},
        placeholder = {Text(text = ("40"))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}

@Composable
private fun TempUnits(
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.33F)
    ) {
        var buttonText by remember {
            mutableStateOf("Temp Unit")
        }
        OutlinedButton(onClick = {expanded = !expanded},
            modifier = Modifier
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