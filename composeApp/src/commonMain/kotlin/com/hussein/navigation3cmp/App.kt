package com.hussein.navigation3cmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.hussein.navigation3cmp.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationRoot()
    }
}