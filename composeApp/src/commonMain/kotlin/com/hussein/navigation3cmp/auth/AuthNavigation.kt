package com.hussein.navigation3cmp.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.hussein.navigation3cmp.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun AuthNavigation(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
){
    val rootBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Auth.Login::class, Route.Auth.Login.serializer())
                    subclass(Route.Auth.Register::class, Route.Auth.Register.serializer())
                }
            }
        },
        Route.Auth.Login
    )
    val sharedViewModel = viewModel<SharedAuthViewModel>()
    NavDisplay(
        backStack = rootBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Route.Auth.Login> {
                //Add koin or hilt view models if founded
                LoginScreen(
                    viewModel = viewModel { LoginViewModel() },
                    sharedViewModel = sharedViewModel,
                    onLoginClick = onLoginClick,
                    onRegisterClick = {
                        rootBackStack.add(Route.Auth.Register)
                    }
                )
            }
            entry<Route.Auth.Register> {
                RegisterScreen(
                    viewModel = viewModel { RegisterViewModel() },
                    sharedViewModel = sharedViewModel
                )
            }
        }
    )
}