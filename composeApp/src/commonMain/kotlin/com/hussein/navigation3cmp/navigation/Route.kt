package com.hussein.navigation3cmp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey{

    //Nested Routes
    @Serializable
    data object Auth: Route, NavKey {
        @Serializable
        data object Login :  Route, NavKey

        @Serializable
        data object Register :  Route, NavKey
    }
    @Serializable
    data object Todo:Route,NavKey{
        @Serializable
        data object TodoList : Route, NavKey

        @Serializable
        data class TodoDetail(val todo: String) : Route, NavKey
    }

}