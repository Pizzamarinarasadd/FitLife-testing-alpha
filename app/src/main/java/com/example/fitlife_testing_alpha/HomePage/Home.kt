package com.example.fitlife_testing_alpha.HomePage

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavController){
   homeLogic(viewModel = homeViewModel(),
       FoosStatistics = FoodStatistics(DataClassSpecific(false, "Breakfast", 0, 0, 0, 0),
           DataClassSpecific(false, "Lunch", 0, 0, 0, 0),
           DataClassSpecific(false, "Dinner", 0, 0, 0, 0),
           DataClassSpecific(false, "Snacks", 0, 0, 0, 0),
           ObjectId(1)),
       FoodViewModel = FoodViewModel() )

}