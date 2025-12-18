package com.hussein.navigation3cmp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hussein.navigation3cmp.viewmodel.TodoListViewModel

@Composable
fun TodoListScreen(modifier: Modifier = Modifier,
                   viewModel: TodoListViewModel = viewModel {
                       TodoListViewModel() //This for handling crash in IOS device not used viewModel() like android
                   },
                   onTodoClick : (String) -> Unit
){
    val todos by viewModel.todos.collectAsStateWithLifecycle()
    LazyColumn(modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(todos){todo ->
            Text(text = todo,
                modifier = Modifier.fillMaxWidth()
                    .clickable{
                        onTodoClick(todo)
                    }
                    .padding(16.dp))
        }
    }

}