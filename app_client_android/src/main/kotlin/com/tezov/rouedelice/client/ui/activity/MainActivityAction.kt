

package com.tezov.rouedelice.client.ui.activity

import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.navigation.NavigationRouteManager
import com.tezov.lib_adr_app_core.ui.composition.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_adr_app_core.ui.compositionTree.activity.ActivityAction

class MainActivityAction private constructor(
    val navigationController: NavigationRouteManager,
) : ActivityAction<MainActivityState>() {

    companion object {
        @Composable
        fun create(
            navigationController: com.tezov.lib_adr_app_core.navigation.NavigationController,
            snackbarAction: SnackbarAction,
        ): MainActivityAction {
            return MainActivityAction(
                navigationController = NavigationRouteManager(
                    controller = navigationController,
                    snackbarAction = snackbarAction,
                ),
            )
        }
    }

}