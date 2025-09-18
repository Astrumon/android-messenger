package com.ua.astrumon.messenger.core.common.android.di

import com.ua.astrumon.messenger.core.common.android.AndroidExceptionHandler
import com.ua.astrumon.messenger.core.essentials.exceptions.handler.ExceptionHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
interface ExceptionHandlerModule {

    @Binds
    fun bindAndroidExceptionHandler(
        impl: AndroidExceptionHandler
    ): ExceptionHandler
}