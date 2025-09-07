package com.ua.astrumon.messenger.core.essentials.exceptions

abstract class AppExceptions(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)

class UnknownException: AppExceptions("Unknown exception")