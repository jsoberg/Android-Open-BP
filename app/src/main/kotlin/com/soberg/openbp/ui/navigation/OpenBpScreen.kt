package com.soberg.openbp.ui.navigation

sealed interface OpenBpScreen {
    val route: String

    object List : OpenBpScreen {
        override val route: String = "list"
    }
}