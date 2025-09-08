package com.ua.astrumon.messenger.feature.init.domain

import com.ua.astrumon.messenger.core.essentials.exceptions.AppException
import com.ua.astrumon.messenger.core.essentials.exceptions.WithLocalizedMessage
import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore



abstract class InitAppException(
    message: String, cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<InitStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: InitStringProvider) : String
}

class DeviceIsRootedException: InitAppException("Device is rooted") {
    override fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}