package com.ua.astrumon.messenger.feature.init.domain

import com.ua.astrumon.messenger.core.essentials.resources.StringProvider

interface InitStringProvider: StringProvider {
    val deviceIsRootedErrorMessage: String
}