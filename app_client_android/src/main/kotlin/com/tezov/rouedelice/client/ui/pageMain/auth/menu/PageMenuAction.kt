

package com.tezov.rouedelice.client.ui.pageMain.auth.menu

import com.tezov.lib_adr_app_core.navigation.NavigationController
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class PageMenuAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageMenuState>() {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageMenuAction(
            navigationController = navigationController,
        )
    }




}