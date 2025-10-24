package com.example.fieldresearchchecklist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    tasks: MutableList<String>
) {
    NavHost(
        navController = navController,
        startDestination = "task_list"
    ) {
        composable(route = "task_list") {
            TaskListScreen(
                tasks = tasks,
                onAddTask = {
                    navController.navigate("create_task")
                },
                onDeleteTask = { index ->
                    // Remove the task from the list by its index
                    tasks.removeAt(index)
                }
            )
        }

        composable(route = "create_task") {
            CreateTaskScreen(
                onSaveTask = { newTask ->
                    if (newTask.isNotBlank()) {
                        tasks.add(newTask)
                    }
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
