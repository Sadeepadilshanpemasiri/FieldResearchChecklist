package com.example.fieldresearchchecklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode // <-- ADD THIS IMPORT
import androidx.compose.ui.graphics.ColorFilter // <-- ADD THIS IMPORT
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.fieldresearchchecklist.ui.theme.FieldResearchChecklistTheme

class MainActivity : ComponentActivity() {
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FieldResearchChecklistTheme {
                AppBackground {
                    val navController = rememberNavController()
                    AppNavHost(
                        navController = navController,
                        viewModel = taskViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun AppBackground(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Layer 1 (Bottom): The Background Image
        Image(
            painter = painterResource(id = R.drawable.background_main),
            contentDescription = "App background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            // --- THIS IS THE NEW CODE TO ADD FOR THE TINT ---
            colorFilter = ColorFilter.tint(
                // Use a color from your theme for a perfect match.
                // 'primary' is the Teal color in your theme.
                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.09f),
                // --- END OF CORRECTION ---
                // This blend mode applies the color over the image.
                blendMode = BlendMode.SrcOver
            )
            // --- END OF NEW CODE ---
        )

        // Layer 2 (Top): The App's Content with its own semi-transparent background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.05f))
        ) {
            content()
        }
    }
}
