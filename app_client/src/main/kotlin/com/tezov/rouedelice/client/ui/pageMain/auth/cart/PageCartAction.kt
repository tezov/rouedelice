

package com.tezov.rouedelice.client.ui.pageMain.auth.cart

import com.tezov.lib_adr_app_core.navigation.NavigationController
import com.tezov.lib_adr_app_core.ui.compositionTree.page.PageAction

class PageCartAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageCartState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PageCartAction(
            navigationController = navigationController,
        )
    }



}