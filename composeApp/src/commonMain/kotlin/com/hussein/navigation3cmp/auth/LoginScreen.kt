package com.hussein.navigation3cmp.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    sharedViewModel: SharedAuthViewModel,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
){

    val localCounter by viewModel.counter.collectAsStateWithLifecycle()
    val sharedCounter by sharedViewModel.counter.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = sharedViewModel::bump
        ){
            Text(text = "Shared Counter: $sharedCounter")
        }
        Button(
            onClick = viewModel::bump
        ){
            Text(text = "Local Counter: $localCounter")
        }
        Button(
            onClick = onLoginClick
        ){
            Text(text = "Login")
        }
        Button(
            onClick = onRegisterClick
        ){
            Text(text = "Register")
        }
    }
}