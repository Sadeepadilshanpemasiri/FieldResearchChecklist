package com.example.fieldresearchchecklist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<String>()


    val tasks: List<String> = _tasks

    fun addTask(taskDescription: String) {
        if (taskDescription.isNotBlank()) {
            _tasks.add(taskDescription)
        }
    }

    fun removeTask(index: Int) {
        if (index >= 0 && index < _tasks.size) {
            _tasks.removeAt(index)
        }
    }
}
