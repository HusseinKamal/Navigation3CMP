package com.hussein.navigation3cmp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoDetailViewModel(
    private val todo: String
) : ViewModel() {
    private val _state = MutableStateFlow(TodoDetailState(todo))
    val state = _state.asStateFlow()
    init {
        println("TodoDetailViewModel initialized for $todo")
    }

    override fun onCleared() {
        super.onCleared()
        println("TodoDetailViewModel cleared for $todo")
    }
}
data class TodoDetailState(
    val todo: String
)