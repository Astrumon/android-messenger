package com.ua.astrumon.messenger.core.essentials.logger

interface Logger {

    fun d(message: String)

    fun e(exception: Exception, message: String)


    companion object : Logger {

        private var instance: Logger = DefaultLogger

        fun set(logger: Logger) {
            instance = logger
        }

        override fun d(message: String) {
            instance.d(message)
        }

        override fun e(exception: Exception, message: String) {
            instance.e(exception, message)
        }

        fun reset() {
            instance = DefaultLogger
        }

    }
}