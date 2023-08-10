

package com.tezov.rouedelice.client.ui.pageMain.lobby.splash

import com.tezov.rouedelice.client.navigation.NavigationRoutes.Route
import com.tezov.lib_adr_app_core.navigation.NavigationController
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class PageSplashAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageSplashState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageSplashAction(
            navigationController = navigationController,
        )
    }

    fun onStart() {
        navigationController.requestNavigate(Route.Lounge, this)
    }

}