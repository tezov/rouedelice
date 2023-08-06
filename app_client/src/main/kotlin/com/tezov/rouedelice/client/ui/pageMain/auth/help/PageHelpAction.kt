

package com.tezov.rouedelice.client.ui.pageMain.auth.help

import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager.NotImplemented
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PageHelpAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageHelpState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageHelpAction(
            navigationController = navigationController,
        )
    }




}