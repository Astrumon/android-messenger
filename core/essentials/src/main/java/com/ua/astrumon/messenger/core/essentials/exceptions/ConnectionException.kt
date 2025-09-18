package com.ua.astrumon.messenger.core.essentials.exceptions

import com.ua.astrumon.messenger.core.essentials.exceptions.base.AbstractCoreAppException
import com.ua.astrumon.messenger.core.essentials.resources.CoreStringProvider

class ConnectionException(
    cause: Throwable? = null
) : AbstractCoreAppException("Network error", cause) {

    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}