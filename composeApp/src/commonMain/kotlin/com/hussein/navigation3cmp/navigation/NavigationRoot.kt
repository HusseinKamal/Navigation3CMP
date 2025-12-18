package com.hussein.navigation3cmp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hussein.navigation3cmp.screens.TodoDetailScreen
import com.hussein.navigation3cmp.screens.TodoListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val navigationState = rememberNavigationState(
        startRoute = Route.TodoList,
        topLevelRoutes = TOP_LEVEL_DESTINATION.keys
    )
    val navigator = remember {
        Navigator(navigationState)
    }
    Scaffold(
        bottomBar = {
            TodoNavigationBar(
                selectKey = navigationState.topLevelRoute,
                onSelected = {
                    navigator.navigate(it)

                }
            )
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            onBack = navigator::goBack,
            entries = navigationState.toEntries(
                entryProvider {
                    entry<Route.TodoList> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoFavorites> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoDetail> {
                        TodoDetailScreen(
                            todo = it.todo
                        )
                    }
                    entry<Route.Settings> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Settings")
                        }
                    }
                }
            )
        )
    }
}