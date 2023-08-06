

package com.tezov.rouedelice.client.ui.pageMain.auth.discover

import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager.NotImplemented
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PageDiscoverAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageDiscoverState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageDiscoverAction(
            navigationController = navigationController,
        )
    }



}