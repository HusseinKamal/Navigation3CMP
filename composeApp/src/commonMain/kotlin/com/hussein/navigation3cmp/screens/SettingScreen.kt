package com.hussein.navigation3cmp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hussein.navigation3cmp.navigation.ResultStore

@Composable
fun SettingScreen(
    resultStore: ResultStore,
    onChangeSettingClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    val setting = resultStore.getResult<String>("main_setting")

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onChangeSettingClick()
            }
        ) {

            Text("Current setting : ${setting ?: "Default"}")
        }
    }
}