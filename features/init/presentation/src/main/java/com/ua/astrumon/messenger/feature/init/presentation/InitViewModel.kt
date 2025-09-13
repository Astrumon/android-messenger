package com.ua.astrumon.messenger.feature.init.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elveum.container.Container
import com.elveum.container.containerMap
import com.ua.astrumon.messenger.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.ua.astrumon.messenger.feature.init.domain.GetKeyFeatureUseCase
import com.ua.astrumon.messenger.feature.init.domain.entities.KeyFeature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    private val getKeyFeatureUseCase: GetKeyFeatureUseCase,
    private val exceptionToMessageMapper: ExceptionToMessageMapper
): ViewModel() {

   val stateFlow: StateFlow<Container<State>> = getKeyFeatureUseCase
       .invoke()
       .containerMap { keyFeature -> State(keyFeature) }
       .stateIn(viewModelScope,
       SharingStarted.WhileSubscribed(1000), Container.Pending)
    data class State(
        val keyFeature: KeyFeature
    )
}