package com.hussein.navigation3cmp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold { paddingValues ->
            NavigationRoot(
                modifier = Modifier
                    .padding(paddingValues)
            )
        }
    }
}