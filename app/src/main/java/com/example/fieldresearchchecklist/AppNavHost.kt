package com.example.fieldresearchchecklist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    viewModel: TaskViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "task_list"
    ) {
        composable(route = "task_list") {
            TaskListScreen(
                tasks = viewModel.tasks,
                onAddTask = { navController.navigate("create_task") },
                onDeleteTask = { index -> viewModel.removeTask(index) }
            )
        }
        composable(route = "create_task") {
            CreateTaskScreen(
                onSaveTask = { newTask ->
                    viewModel.addTask(newTask)
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}
