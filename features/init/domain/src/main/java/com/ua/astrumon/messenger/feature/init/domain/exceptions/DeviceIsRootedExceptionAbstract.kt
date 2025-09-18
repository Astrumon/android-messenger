package com.ua.astrumon.messenger.feature.init.domain.exceptions

import com.ua.astrumon.messenger.core.essentials.exceptions.base.AbstractAppException
import com.ua.astrumon.messenger.core.essentials.exceptions.base.WithLocalizedMessage
import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore
import com.ua.astrumon.messenger.feature.init.domain.resources.InitStringProvider


abstract class InitAbstractAppException(
    message: String, cause: Throwable? = null
) : AbstractAppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<InitStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: InitStringProvider) : String
}

class DeviceIsRootedExceptionAbstract: InitAbstractAppException("Device is rooted") {
    override fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}