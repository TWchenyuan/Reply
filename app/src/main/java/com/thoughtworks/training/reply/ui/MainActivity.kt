package com.thoughtworks.training.reply.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.adaptive.calculateDisplayFeatures
import com.thoughtworks.training.reply.ui.theme.ContrastAwareReplyTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            ContrastAwareReplyTheme {
                val replyHomeUIState by viewModel.replyHomeUIState.collectAsStateWithLifecycle()
                ReplyApp(
                    windowSize = calculateWindowSizeClass(activity = this),
                    displayFeatures = calculateDisplayFeatures(activity = this),
                    replyHomeUIState = replyHomeUIState
                )
            }
        }
    }
}