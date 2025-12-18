package com.hussein.navigation3cmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.hussein.navigation3cmp.auth.AuthNavigation
import com.hussein.navigation3cmp.navigation.Route
import com.hussein.navigation3cmp.screens.TodoDetailScreen
import com.hussein.navigation3cmp.screens.TodoListScreen
import com.hussein.navigation3cmp.screens.TodoNavigation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val rootBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Auth::class, Route.Auth.serializer())
                    subclass(Route.Todo::class, Route.Todo.serializer())
                }
            }
        },
        Route.Auth
    )

    /*NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when(key){
                is Route.TodoList ->{
                    NavEntry(key){
                        TodoListScreen(onTodoClick = {
                            backStack.add(Route.TodoDetail(it))
                        })
                    }
                }
                is Route.TodoDetail -> {
                    NavEntry(key){
                        TodoDetailScreen(
                            todo = key.todo,
                        )
                    }
                }
                else -> {
                    error("Unknown NakKey: $key")
                }
            }
        }
    )*/
    //Better Solution
    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Auth>{
                AuthNavigation(onLoginClick = {
                    rootBackStack.remove(Route.Auth)
                    rootBackStack.add(Route.Todo)
                })
            }
            entry<Route.Todo>{
                TodoNavigation()
            }
        }
    )
}