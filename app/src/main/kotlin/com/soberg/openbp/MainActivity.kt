package com.soberg.openbp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soberg.openbp.ui.reading.BpReadingListScreen
import com.soberg.openbp.ui.reading.BpReadingListViewModel
import com.soberg.openbp.ui.theme.OpenBpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenBpTheme {
                OpenBpApp()
            }
        }
    }
}

@Composable
private fun OpenBpApp() {
    val viewModel: BpReadingListViewModel = viewModel()
    BpReadingListScreen(viewModel)
}
