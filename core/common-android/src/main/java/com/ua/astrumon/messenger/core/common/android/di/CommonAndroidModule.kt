package com.ua.astrumon.messenger.core.common.android.di

import android.content.Context
import com.ua.astrumon.messenger.core.common.android.AndroidExceptionHandler
import com.ua.astrumon.messenger.core.common.android.AndroidLogger
import com.ua.astrumon.messenger.core.common.android.CoreStringProviderImpl
import com.ua.astrumon.messenger.core.essentials.exceptions.handler.ExceptionHandler
import com.ua.astrumon.messenger.core.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import com.ua.astrumon.messenger.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.ua.astrumon.messenger.core.essentials.logger.Logger
import com.ua.astrumon.messenger.core.essentials.resources.CoreStringProvider
import com.ua.astrumon.messenger.core.essentials.resources.StringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(logger: AndroidLogger): Logger


    @Binds
    @IntoMap
    @ClassKey(CoreStringProvider::class)
    fun bindCoreStringProvider(androidStringProvider: CoreStringProviderImpl): StringProvider

    @Binds
    fun bindExceptionToMessageMapper(
        defaultExceptionToMessageMapper: DefaultExceptionToMessageMapper
    ): ExceptionToMessageMapper

}