

package com.tezov.rouedelice.client.ui.pageMain.lobby.lounge

import com.tezov.rouedelice.client.navigation.NavigationRoutes.Route
import com.tezov.lib_adr_app_core.navigation.NavigationController
import com.tezov.lib_adr_app_core.navigation.NavigationRouteManager.NotImplemented
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class PageLoungeAction private constructor(
    private val navigationController: NavigationController,
) : PageAction<PageLoungeState> {

    companion object {

        fun create(
            navigationController: NavigationController,
        ) = PageLoungeAction(
            navigationController = navigationController,
        )
    }


}