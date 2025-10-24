package com.example.fieldresearchchecklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList // <-- ADD THIS IMPORT
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fieldresearchchecklist.ui.theme.FieldResearchChecklistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FieldResearchChecklistTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    // Explicitly define the type for remember
                    val tasks = remember<SnapshotStateList<String>> {
                        mutableStateListOf()
                    }

                    AppNavHost(navController = navController, tasks = tasks)
                }
            }
        }
    }
}
