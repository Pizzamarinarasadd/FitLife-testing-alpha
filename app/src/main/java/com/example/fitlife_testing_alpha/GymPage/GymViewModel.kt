package com.example.fitlife_testing_alpha.GymPage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GymViewModel : ViewModel() {
    private var _upisEditing :MutableStateFlow<Boolean> = MutableStateFlow(false)
   var isEditing: MutableStateFlow<Boolean> =_upisEditing
    private var id: Int = 0

    fun startEditing(id: Int) {
        this.id = id
        _upisEditing.value = true
    }

    fun endEditing() {
        _upisEditing.value = false
    }

    fun getId(): Int {
        return id
    }
}
