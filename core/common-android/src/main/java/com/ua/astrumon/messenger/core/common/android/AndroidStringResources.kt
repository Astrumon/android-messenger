package com.ua.astrumon.messenger.core.common.android

import android.content.Context
import com.ua.astrumon.messenger.core.essentials.resources.StringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class AndroidStringProvider @Inject constructor(
    @ApplicationContext private val context: Context
): StringProvider {

}