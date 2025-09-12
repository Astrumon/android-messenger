package com.ua.astrumon.messenger.core.essentials.exceptions.base

abstract class AbstractAppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)