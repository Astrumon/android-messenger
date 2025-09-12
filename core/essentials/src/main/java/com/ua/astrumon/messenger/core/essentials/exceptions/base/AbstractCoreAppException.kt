package com.ua.astrumon.messenger.core.essentials.exceptions.base

import com.ua.astrumon.messenger.core.essentials.resources.CoreStringProvider
import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore

abstract class AbstractCoreAppException(
    message: String, cause: Throwable? = null
) : AbstractAppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<CoreStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: CoreStringProvider) : String
}