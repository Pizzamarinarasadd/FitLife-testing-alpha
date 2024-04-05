@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fitlife_testing_alpha

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitlife_testing_alpha.GymPage.Gym
import com.example.fitlife_testing_alpha.HomePage.Home

@Composable
fun Scaffold() {
    var pressed by remember {mutableStateOf(false)}
    val navController= rememberNavController()
    Scaffold(

        bottomBar = {
            BottomAppBar(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {


                        Row( horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                            modifier=Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Button(onClick = {
                                    pressed=true
                                    navController.navigate("Home")},
                                    ) {

                                    Text("Home")
                                }
                            }
                            Column {
                                Button(onClick = { navController.navigate("Gym") },

                                    ) {
                                    Text("Gym")
                                }
                            }
                            Column {
                                Button(onClick = { navController.navigate("Gpt") },

                                    ) {
                                    Text("Settings")
                                }
                            }


            }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        NavHost(
            navController =navController ,
            startDestination = "Home",
            Modifier.padding(innerPadding))
        {
            composable("Home"){
                Home(navController=navController)
            }
            composable("Gym"){
                Gym(navController = navController)
            }
            composable("Gpt"){
                settings(navController=navController)
            }
        }
    }
}