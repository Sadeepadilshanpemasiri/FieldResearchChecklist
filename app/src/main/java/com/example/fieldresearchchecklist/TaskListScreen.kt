package com.example.fieldresearchchecklist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Make sure Color is imported
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TaskListScreen(
    tasks: List<String>,
    onAddTask: () -> Unit,
    onDeleteTask: (Int) -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("Field Research Tasks") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTask,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add new task")
            }
        }
    ) { innerPadding ->
        if (tasks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Your task list is empty.\nTap the '+' button to add a new task.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    // --- THIS IS THE MODIFIED LINE ---
                    color = Color.White // Changed from MaterialTheme.colorScheme.onBackground
                    // --- END OF MODIFICATION ---
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(items = tasks, key = { _, task -> task.hashCode() }) { index, task ->
                    TaskItem(
                        taskDescription = task,
                        onDelete = { onDeleteTask(index) },
                        modifier = Modifier.animateItemPlacement()
                    )
                }
            }
        }
    }
}

@Composable
fun TaskItem(taskDescription: String, onDelete: () -> Unit, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = taskDescription,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = onDelete) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete task",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
