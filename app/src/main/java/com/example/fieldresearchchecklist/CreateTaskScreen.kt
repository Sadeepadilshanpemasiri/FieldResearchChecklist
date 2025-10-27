package com.example.fieldresearchchecklist

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskScreen(
    onSaveTask: (String) -> Unit,
    onBack: () -> Unit
) {
    var taskText by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color.Transparent, // Make background visible
        topBar = {
            TopAppBar(
                title = { Text("Create New Task") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                // --- THIS IS THE MODIFIED CODE BLOCK ---
                colors = TopAppBarDefaults.topAppBarColors(
                    // Set the background color to match the TaskListScreen app bar
                    containerColor = MaterialTheme.colorScheme.primary,
                    // Set the title and icon colors to be readable on the new background
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
                // --- END OF MODIFICATION ---
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            OutlinedTextField(
                value = taskText,
                onValueChange = { taskText = it },
                label = { Text("Task description") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    // Color of the text itself
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,

                    // Color of the floating label when focused
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White.copy(alpha = 0.7f),

                    // Color of the border when focused
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White.copy(alpha = 0.5f),

                    // Color of the cursor
                    cursorColor = Color.White
                )
            )

            Button(
                onClick = { onSaveTask(taskText) },
                enabled = taskText.isNotBlank(),
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Save Task", style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}
