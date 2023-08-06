

package com.tezov.rouedelice.client.ui.activity

import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.navigation.NavigationRoutes
import com.tezov.lib_adr_sdk_core.ui.composition.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_adr_sdk_core.ui.compositionTree.activity.ActivityAction

class MainActivityAction private constructor(
    val navigationRoutes: NavigationRoutes,
) : ActivityAction<MainActivityState> {

    companion object {
        @Composable
        fun create(
            navigationController: com.tezov.lib_adr_sdk_core.navigation.NavigationController,
            snackbarAction: SnackbarAction,
        ): MainActivityAction {
            return MainActivityAction(
                navigationRoutes = NavigationRoutes(
                    controller = navigationController,
                    snackbarAction = snackbarAction,
                ),
            )
        }
    }

}