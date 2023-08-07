

package com.tezov.rouedelice.client.ui.pageMain.auth.check

import com.tezov.lib_adr_app_core.navigation.NavigationController
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class PageCheckAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageCheckState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageCheckAction(
            navigationController = navigationController,
        )
    }

}