package com.ua.astrumon.messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ua.astrumon.messenger.core.common.android.AndroidExceptionHandler
import com.ua.astrumon.messenger.core.essentials.exceptions.ConnectionException
import com.ua.astrumon.messenger.core.essentials.exceptions.handler.ExceptionHandler
import com.ua.astrumon.messenger.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.ua.astrumon.messenger.core.essentials.logger.Logger
import com.ua.astrumon.messenger.feature.init.presentation.InitScreen
import com.ua.astrumon.messenger.ui.theme.MessengerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    @Inject
    lateinit var exceptionHandler: AndroidExceptionHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val message1 = exceptionToMessageMapper.getLocalizedMessage(ConnectionException())
        val message2 = ExceptionToMessageMapper.getLocalizedMessage(ConnectionException())

        Logger.d(message1)
        Logger.d(message2)

        enableEdgeToEdge()
        setContent {
            MessengerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(Modifier.fillMaxSize().padding(innerPadding))
                    exceptionHandler.ErrorDialog()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier) {
    InitScreen()
}