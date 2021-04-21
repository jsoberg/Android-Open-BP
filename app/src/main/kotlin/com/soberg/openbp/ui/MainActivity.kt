package com.soberg.openbp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.soberg.openbp.ui.theme.OpenBpTheme
import com.soberg.openbp.viewmodel.BpReadingsListViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: BpReadingsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenBpTheme {
                BpReadingsListScreen(viewModel)
            }
        }
    }
}
