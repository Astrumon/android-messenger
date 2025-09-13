package com.ua.astrumon.messenger.feature.init.domain

import com.elveum.container.Container
import com.elveum.container.successContainer
import com.ua.astrumon.messenger.feature.init.domain.entities.KeyFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*interface GetKeyFeatureUseCase {
    operator fun invoke(): Flow<Container<KeyFeature>>
}*/ // todo

class GetKeyFeatureUseCase @Inject constructor() {
    fun invoke(): Flow<Container<KeyFeature>> {
        // todo: load real data
        return flow {
            delay(2000)
            emit(successContainer(KeyFeature(1L, "Title", "Description")))
        }
    }
}

