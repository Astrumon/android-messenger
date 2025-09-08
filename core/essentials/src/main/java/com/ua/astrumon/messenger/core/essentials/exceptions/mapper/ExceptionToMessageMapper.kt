package com.ua.astrumon.messenger.core.essentials.exceptions.mapper

interface ExceptionToMessageMapper {

    fun getLocalizedMessage(exception: Exception): String

    companion object : ExceptionToMessageMapper {

        private var instance: ExceptionToMessageMapper = EmptyExceptionToMessageMapper()

        override fun getLocalizedMessage(exception: Exception): String {
            return instance.getLocalizedMessage(exception)
        }

        fun set(exceptionToMessageMapper: ExceptionToMessageMapper) {
            instance = exceptionToMessageMapper
        }

        fun reset() {
            instance = EmptyExceptionToMessageMapper()
        }

    }

}