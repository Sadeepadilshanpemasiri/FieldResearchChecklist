package com.example.fieldresearchchecklist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    // _tasks is private to prevent accidental modification from the UI
    private val _tasks = mutableStateListOf<String>()

    // Expose a stable, read-only list to the UI
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
