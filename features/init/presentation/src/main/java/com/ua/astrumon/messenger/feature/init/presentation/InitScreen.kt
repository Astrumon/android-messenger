package com.ua.astrumon.messenger.feature.init.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.elveum.container.Container
import com.ua.astrumon.messenger.core.theme.Dimens
import com.ua.astrumon.messenger.core.theme.MediumVerticalSpace
import com.ua.astrumon.messenger.core.theme.components.ContainerView
import com.ua.astrumon.messenger.core.theme.components.ProgressButton
import com.ua.astrumon.messenger.feature.init.domain.entities.KeyFeature

@Composable
fun InitScreen() {
    val viewModel: InitViewModel = hiltViewModel()
    val container: Container<InitViewModel.State> by viewModel.stateFlow.collectAsState()
    ContainerView(
        container = container,
        modifier = Modifier.fillMaxSize()
    ) { state ->
        InitContent(
            state = state,
            onLetsGoAction = viewModel::letsGo
        )
    }
}

@Composable
fun InitContent(
    state: InitViewModel.State,
    onLetsGoAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val keyFeature = state.keyFeature
        Text(
            text = keyFeature.title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        MediumVerticalSpace()
        Text(
            text = keyFeature.description,
            textAlign = TextAlign.Center
        )
        MediumVerticalSpace()
        ProgressButton(
            isInProgress = state.isCheckAuthInProgress,
            text = stringResource(R.string.let_s_go),
            onClick = onLetsGoAction
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InitContentPreview() {
    InitContent(
        state = InitViewModel.State(
            keyFeature = KeyFeature(
                id = 0,
                title = "Est ut quam qui suscipit guod",
                description = "Description Istel"
            ),
            isCheckAuthInProgress = true
        ),
        onLetsGoAction = {}
    )
}

