package com.ua.astrumon.messenger.feature.init.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.elveum.container.Container

@Composable
fun InitScreen() {
    val viewModel: InitViewModel = hiltViewModel()
    val container: Container<InitViewModel.State> by viewModel.stateFlow.collectAsState()
    // todo: handle success/error/loading states
}

@Composable
fun InitContent(state: InitViewModel.State) {
    // todo: render screen content
}

