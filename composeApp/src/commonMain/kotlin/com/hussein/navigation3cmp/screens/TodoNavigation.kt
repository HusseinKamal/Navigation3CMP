package com.hussein.navigation3cmp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.hussein.navigation3cmp.auth.LoginScreen
import com.hussein.navigation3cmp.auth.LoginViewModel
import com.hussein.navigation3cmp.auth.RegisterScreen
import com.hussein.navigation3cmp.auth.RegisterViewModel
import com.hussein.navigation3cmp.auth.SharedAuthViewModel
import com.hussein.navigation3cmp.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun TodoNavigation(
    modifier: Modifier = Modifier,
){
    val todoBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Todo.TodoList::class, Route.Todo.TodoList.serializer())
                    subclass(Route.Todo.TodoDetail::class, Route.Todo.TodoDetail.serializer())
                }
            }
        },
        Route.Todo.TodoList
    )
    val sharedViewModel = viewModel<SharedAuthViewModel>()
    NavDisplay(
        backStack = todoBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Route.Todo.TodoList> {
                //Add koin or hilt view models if founded
                TodoListScreen(
                    onTodoClick = {
                        todoBackStack.add(Route.Todo.TodoDetail(it))
                    }
                )
            }
            entry<Route.Todo.TodoDetail> { key ->
                TodoDetailScreen(
                    todo = key.todo,
                )
            }
        }
    )
}