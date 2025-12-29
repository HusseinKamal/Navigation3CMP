package com.hussein.navigation3cmp.navigation

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hussein.navigation3cmp.scenes.ListDetailScene
import com.hussein.navigation3cmp.scenes.rememberListDetailSceneStrategy
import com.hussein.navigation3cmp.screens.ChangeSettingScreen
import com.hussein.navigation3cmp.screens.SettingScreen
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
    val resultStore = rememberResultStore()

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
            sceneStrategy = rememberListDetailSceneStrategy(),//support Large screens
            transitionSpec = {
                slideInHorizontally {it} + fadeIn() togetherWith
                        slideOutHorizontally{-it} + fadeOut()
            },//Transition during navigation
            popTransitionSpec = {
                slideInHorizontally {-it} + fadeIn() togetherWith
                        slideOutHorizontally{it} + fadeOut()
            },
            predictivePopTransitionSpec = {
                slideInHorizontally {-it} + fadeIn() togetherWith
                        slideOutHorizontally{it} + fadeOut()
            },
            entries = navigationState.toEntries(
                entryProvider {
                    entry<Route.TodoList>(
                        metadata = ListDetailScene.listPane()
                    ) {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoFavorites>(
                        metadata = ListDetailScene.listPane()
                    ) {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoDetail>(
                        metadata = ListDetailScene.detailPane()
                    ){
                        TodoDetailScreen(
                            todo = it.todo
                        )
                    }
                    entry<Route.Settings> {
                        SettingScreen(
                            resultStore = resultStore,
                            onChangeSettingClick = {
                                navigator.navigate(Route.ChangeSettings)
                            }
                        )
                    }
                    entry<Route.ChangeSettings> {
                        ChangeSettingScreen(
                            onSave = {
                                navigator.goBack()
                            },
                            resultStore = resultStore
                        )
                    }
                }
            )
        )
    }
}