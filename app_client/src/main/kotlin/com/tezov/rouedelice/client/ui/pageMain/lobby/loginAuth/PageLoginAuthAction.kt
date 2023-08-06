

package com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth

import com.tezov.rouedelice.client.navigation.NavigationRoutes.Route
import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.ui.composition.activity.sub.dialog.DialogAction
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction
import com.tezov.lib_adr_core.async.notifier.Event
import com.tezov.lib_adr_core.async.notifier.observer.event.ObserverEventE

class PageLoginAuthAction private constructor(
    private val navigationController: NavigationController,
    private val dialogAction: DialogAction,
) : PageAction<PageLoginAuthState> {


    companion object {

        fun create(
            navigationController: NavigationController,
            dialogAction: DialogAction
        ) = PageLoginAuthAction(
            navigationController = navigationController,
            dialogAction = dialogAction,
        )
    }

    fun onClickClose() {
        navigationController.requestNavigateBack(this)
    }

    fun onClickConnect() {
        navigationController.requestNavigate(Route.NavAuth, this)
    }

}