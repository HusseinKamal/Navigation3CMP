package com.hussein.navigation3cmp.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    init {
        println("RegisterViewModel init")
    }
    fun bump(){
        _counter.value++
    }

    override fun onCleared() {
        super.onCleared()
        println("RegisterViewModel onCleared")
    }
}