package com.soberg.openbp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.soberg.openbp.ui.navigation.OpenBpNavHost
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
    OpenBpNavHost(
        navController = rememberNavController()
    )
}
