package com.ua.astrumon.messenger.core.essentials.exceptions.mapper

import com.ua.astrumon.messenger.core.essentials.exceptions.base.WithLocalizedMessage
import com.ua.astrumon.messenger.core.essentials.resources.CoreStringProvider
import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
): ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return if (exception is WithLocalizedMessage) {
            exception.getLocalizedErrorMessage(stringProviderStore)
        } else {
            stringProviderStore<CoreStringProvider>().unknownErrorMessage()
        }
    }
}