package com.ua.astrumon.messenger.core.essentials.exceptions.base

import com.ua.astrumon.messenger.core.essentials.resources.StringProviderStore

interface WithLocalizedMessage {
    fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String
}