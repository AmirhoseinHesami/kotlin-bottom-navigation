package com.example.mybottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybottomnavigation.ui.theme.MyBottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavController) {
    val destinationList = listOf(Login, Settings)
    val selectedIndex = rememberSaveable { mutableStateOf(0) }
    NavigationBar {
        destinationList.forEachIndexed { index, destination ->
            NavigationBarItem(
                label = { Text(text = destination.title) },
                icon = { Icon(imageVector = destination.icon, contentDescription = destination.title) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destination.route){
                        popUpTo(Login.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController)}) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = Login.route ){
                composable(Login.route){
                    Login(navController)
                }
                composable(Second.route){
                    Second(navController)
                }
                composable(Settings.route){
                    Settings()
                }
            }
        }
    }
}