package com.example.androiddevcert.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevcert.Functions
import com.example.androiddevcert.R
import com.example.androiddevcert.Song
import com.example.androiddevcert.printSongDescription
import com.example.androiddevcert.ui.theme.AndroidDevCertTheme

lateinit var tempUnit: String
lateinit var degreeAmount: String


@Composable
fun ReturnScreen(screen: String) {
    return when (screen) {
        "Home" -> HomeScreen()
        "Article" -> ArticleScreen()
        "Task" -> TaskCompletedScreen()
        "Quadrant" -> ComposeQuadrantScreen()
        else -> HomeScreen()
    }
}

@Composable
fun HomeScreen() {


    Column(modifier = Modifier
        .padding(2.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .padding(8.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .height(60.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
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

@Composable
fun ArticleScreen() {
    Column(modifier = Modifier.fillMaxSize(1f)) {
        Row(modifier = Modifier.wrapContentWidth()) {
            Image(painter = painterResource(id = R.drawable.bg_compose_background), contentDescription = stringResource(
                id = R.string.compose_header_image_desc)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.jpc_tutorial_title), modifier = Modifier.padding(16.dp), fontSize = 24.sp)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.jpc_tutorial_first_paragraph), modifier = Modifier.padding(horizontal = 16.dp), textAlign = TextAlign.Justify)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.jpc_tutorial_second_paragraph), modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
        }
    }
}

@Composable
fun TaskCompletedScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier) {
            Image(painter = painterResource(id = R.drawable.ic_task_completed), contentDescription = stringResource(
                id = R.string.compose_header_image_desc))
        }
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.task_completed_first_sentence), fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.task_completed_second_sentence))
        }
    }
}

@Composable
fun ComposeQuadrantScreen() {

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
    var degreesAmountAsTextField by remember { mutableStateOf(TextFieldValue("")) }
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
        label = { Text(text = "Degrees") },
        placeholder = { Text(text = ("40")) },
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
        DropdownMenuItem(text = { Text("F" ) }, onClick = {
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
    songList.forEach{ printSongDescription(it) }
}
