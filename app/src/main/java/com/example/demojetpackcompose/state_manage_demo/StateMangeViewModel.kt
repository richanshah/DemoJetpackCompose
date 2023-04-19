package com.example.demojetpackcompose.state_manage_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StateMangeViewModel : ViewModel() {


    private val _count: MutableStateFlow<Int> = MutableStateFlow(0)
    val count = _count as StateFlow<Int>

    fun updateCount() {
        _count.value++
    }
}