package com.example.fitlife_testing_alpha.HomePage

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow



class homeViewModel:ViewModel() {
    private var _homeAdd : MutableStateFlow<Boolean> = MutableStateFlow(false)
    var homeAdd: MutableStateFlow<Boolean> =_homeAdd
    private var id: Int = 0

    fun startEditing(id: Int) {
        this.id = id
        _homeAdd.value = true
    }

    fun endEditing() {
        _homeAdd.value = false
    }

    fun getId(): Int {
        return id
    }
}