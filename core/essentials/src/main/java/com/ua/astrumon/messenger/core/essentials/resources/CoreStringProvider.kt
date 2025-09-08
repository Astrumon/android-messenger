package com.ua.astrumon.messenger.core.essentials.resources

interface CoreStringProvider: StringProvider {
    val connectionErrorMessage: String

    fun backendErrorMessage(code: Int, backendMessage: String): String

    fun unknownErrorMessage(): String
}