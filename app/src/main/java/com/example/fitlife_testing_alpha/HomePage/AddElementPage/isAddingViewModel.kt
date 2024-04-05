package com.example.fitlife_testing_alpha.HomePage.AddElementPage

import com.example.fitlife_testing_alpha.HomePage.FoodStatistics
import kotlinx.coroutines.flow.MutableStateFlow

class IsAddingViewModel(food: FoodStatistics) {
    private var _isAddingName: MutableStateFlow<String> = MutableStateFlow("")
    var isAddingName: MutableStateFlow<String> = _isAddingName

    fun checkWhat(food: FoodStatistics) {
        _isAddingName.value = when {
            food.listBreakfast.isChosen -> "Breakfast"
            food.listDinner.isChosen -> "Dinner"
            food.listLunch.isChosen -> "Lunch"
            food.listSnacks.isChosen -> "Snacks"
            else -> ""
        }
    }
}