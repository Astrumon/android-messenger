package com.ua.astrumon.messenger.feature.init.domain.resources

import com.ua.astrumon.messenger.core.essentials.resources.StringProvider

interface InitStringProvider: StringProvider {
    val deviceIsRootedErrorMessage: String
}