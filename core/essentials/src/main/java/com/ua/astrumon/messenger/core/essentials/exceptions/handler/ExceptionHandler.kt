package com.ua.astrumon.messenger.core.essentials.exceptions.handler

interface ExceptionHandler {

    suspend fun handleException(exception: Exception)

}
