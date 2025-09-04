package com.ua.astrumon.messenger.core.common.android.di

import com.ua.astrumon.messenger.core.common.android.AndroidLogger
import com.ua.astrumon.messenger.core.essentials.logger.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(logger: AndroidLogger): Logger
}