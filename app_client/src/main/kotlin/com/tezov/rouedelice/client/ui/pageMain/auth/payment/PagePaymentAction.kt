

package com.tezov.rouedelice.client.ui.pageMain.auth.payment

import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager.NotImplemented
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PagePaymentAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PagePaymentState> {


    companion object {

        fun create(
            navigationController: NavigationController
        ) = PagePaymentAction(
            navigationController = navigationController,
        )
    }

}