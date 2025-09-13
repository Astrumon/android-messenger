package com.ua.astrumon.messenger.feature.init.presentation.di

import com.ua.astrumon.messenger.core.essentials.resources.StringProvider
import com.ua.astrumon.messenger.feature.init.domain.InitStringProvider
import com.ua.astrumon.messenger.feature.init.presentation.resources.InitStringProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface InitStringProviderModule {

    @Binds
    @IntoMap
    @ClassKey(InitStringProvider::class)
    fun bindInitStringProvider(initStringProviderImpl: InitStringProviderImpl): StringProvider
}