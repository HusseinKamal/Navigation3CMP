package com.hussein.navigation3cmp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hussein.navigation3cmp.navigation.Route
import com.hussein.navigation3cmp.viewmodel.TodoDetailViewModel
import com.hussein.navigation3cmp.viewmodel.TodoListViewModel

@Composable
fun TodoDetailScreen(
                   modifier: Modifier = Modifier,
                   todo: String,
                   viewModel: TodoDetailViewModel = viewModel {
                       TodoDetailViewModel(todo)
                   }
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center)
    {
        Text(text = todo)
    }

}