package com.example.fitlife_testing_alpha.HomePage

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow



@Composable
fun homeLogic(
    viewModel: homeViewModel,
    FoosStatistics:FoodStatistics,
   FoodViewModel: FoodViewModel) {
    val isAdding by FoodViewModel.foodStatisticsLiveData.collectAsState()
Column(Modifier.fillMaxSize()) {
    Row() {
        Column {
            Button(onClick = { isAdding.listBreakfast.isChosen = true }) {
                Text(text = "Add Breakfast")
            }
        }
        Column {
            Button(onClick = { isAdding.listLunch.isChosen = true }) {
                Text(text = "Add Lunch")
            }

        }
    }
    Row {
        Column {
            Button(onClick = { isAdding.listDinner.isChosen = true }) {
                Text(text = "Add Dinner")

            }

        }
       Column {
            Button(onClick = { isAdding.listSnacks.isChosen = true }) {
                Text(text = "Add Snacks")

            }
        }

    }

}}

