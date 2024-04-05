package com.example.fitlife_testing_alpha.HomePage.AddElementPage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.fitlife_testing_alpha.HomePage.FoodStatistics
import com.example.fitlife_testing_alpha.HomePage.FoodViewModel
import com.example.fitlife_testing_alpha.HomePage.homeViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun isAddingPage(homeViewModel: homeViewModel,
                 FoodViewModel: FoodViewModel,
                 IsAddingViewModel: IsAddingViewModel,
                 food: FoodStatistics,
){
    val isAdding by FoodViewModel.foodStatisticsLiveData.collectAsState()
    if(isAdding.listSnacks.isChosen) {
        Box() {
            Column {
                Column {
                    Row {
                        Text(text = "{${IsAddingViewModel.isAddingName.value}}")
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Search, contentDescription = "")

                        }
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Star, contentDescription = "P.H")

                        }
                    }
                }
                listFood()
            }
        }
    }
   else if(isAdding.listLunch.isChosen) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Column {
                    Row {
                        Text(text = "{${IsAddingViewModel.isAddingName.value}}")
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Search, contentDescription = "")

                        }
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Star, contentDescription = "P.H")

                        }
                    }
                }
                listFood()
            }
        }
    }
    else if(isAdding.listBreakfast.isChosen) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Column {
                    Row {
                        Text(text = "{${IsAddingViewModel.isAddingName.value}}")
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Search, contentDescription = "")

                        }
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Star, contentDescription = "P.H")

                        }
                    }
                }
                listFood()
            }
        }
    }
    else if(isAdding.listDinner.isChosen) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Column {
                    Row {
                        Text(text = "{${IsAddingViewModel.isAddingName.value}}")
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Search, contentDescription = "")

                        }
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(Icons.Default.Star, contentDescription = "P.H")

                        }
                    }
                }
                listFood()
            }
        }
    }
}
