package com.example.fitlife_testing_alpha.HomePage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class FoodViewModel : ViewModel() {
    private val _foodStatisticsLiveData = MutableStateFlow(
        FoodStatistics(
            DataClassSpecific(false, "Breakfast", 0, 0, 0, 0),
            DataClassSpecific(false, "Lunch", 0, 0, 0, 0),
            DataClassSpecific(false, "Dinner", 0, 0, 0, 0),
            DataClassSpecific(false, "Snacks", 0, 0, 0, 0),
            ObjectId(1)
        )
    )

    val foodStatisticsLiveData: StateFlow<FoodStatistics> = _foodStatisticsLiveData

    fun addFood(name: String, amount: Int, carbs: Int, prot: Int, fat: Int) {
        val currentFoodStatistics = _foodStatisticsLiveData.value

        val updatedFoodStatistics = when (name) {
            "Breakfast" -> currentFoodStatistics.copy(listBreakfast = DataClassSpecific(false, name, amount, carbs, prot, fat))
            "Lunch" -> currentFoodStatistics.copy(listLunch = DataClassSpecific(false, name, amount, carbs, prot, fat))
            "Dinner" -> currentFoodStatistics.copy(listDinner = DataClassSpecific(false, name, amount, carbs, prot, fat))
            "Snacks" -> currentFoodStatistics.copy(listSnacks = DataClassSpecific(false, name, amount, carbs, prot, fat))
            else -> currentFoodStatistics
        }

        _foodStatisticsLiveData.value = updatedFoodStatistics.copy(ObjectId = ObjectId(currentFoodStatistics.ObjectId.id + 1))
    }

    fun removeFood(name: String) {
        val currentFoodStatistics = _foodStatisticsLiveData.value

        val updatedFoodStatistics = when (name) {
            "Breakfast" -> currentFoodStatistics.copy(listBreakfast = DataClassSpecific(false, "", 0, 0, 0, 0))
            "Lunch" -> currentFoodStatistics.copy(listLunch = DataClassSpecific(false, "", 0, 0, 0, 0))
            "Dinner" -> currentFoodStatistics.copy(listDinner = DataClassSpecific(false, "", 0, 0, 0, 0))
            "Snacks" -> currentFoodStatistics.copy(listSnacks = DataClassSpecific(false, "", 0, 0, 0, 0))
            else -> currentFoodStatistics
        }

        _foodStatisticsLiveData.value = updatedFoodStatistics
    }
}

