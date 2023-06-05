@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mybottomnavigation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Login(count: NavHostController) {
    var username: String by remember { mutableStateOf("") }
    var password : String by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = {username=it},
            label = { Text(text = "Username") },
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Password") },
        )
        val warning= LocalContext.current
        Button(onClick = {
            if (username=="admin" && password=="1234"){
                count.navigate(Second.route)
            }else{
                Toast.makeText(warning,"Wrong user or password!", Toast.LENGTH_LONG).show()
            }
        },
            modifier = Modifier.padding(all = Dp(10F)),
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color(0xFF999999))),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(Color(0xFF6650a4))) {

            Text(text = "    Login    ", fontSize = 25.sp, color = (Color(0xFFDDDDDD)))
        }
    }
}