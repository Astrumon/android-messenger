package com.ua.astrumon.messenger.feature.init.presentation.resources

import android.content.Context
import com.ua.astrumon.messenger.feature.init.domain.InitStringProvider
import com.ua.astrumon.messenger.feature.init.presentation.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class InitStringProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : InitStringProvider {
    override val deviceIsRootedErrorMessage: String =
        context.getString(R.string.rooted_device_error)
}