package com.ua.astrumon.messenger.core.essentials.exceptions

import com.ua.astrumon.messenger.core.essentials.resources.CoreStringProvider
import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore

abstract class AppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause) {

}

abstract class CoreAppException(
    message: String, cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<CoreStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: CoreStringProvider) : String
}

class UnknownException : AppException("Unknown exception")

class ConnectionException(
    cause: Throwable? = null
) : CoreAppException("Network error", cause) {

    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}

class BackendException(
    val httpCode: Int = 400,
    val backendMessage: String = "",
    cause: Throwable? = null
) : CoreAppException("Server error", cause) {

    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.backendErrorMessage(httpCode, backendMessage)
    }
}