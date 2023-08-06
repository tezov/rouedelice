

package com.tezov.rouedelice.client.ui.pageMain.auth.info

import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PageMenuAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageMenuState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageMenuAction(
            navigationController = navigationController,
        )
    }




}