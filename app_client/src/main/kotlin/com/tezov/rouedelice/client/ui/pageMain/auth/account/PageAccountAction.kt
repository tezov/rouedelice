

package com.tezov.rouedelice.client.ui.pageMain.auth.account

import com.tezov.rouedelice.client.navigation.NavigationRoutes.Route
import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager.NotImplemented
import com.tezov.lib_adr_sdk_core.ui.composition.activity.sub.bottomsheet.BottomSheetAction
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PageAccountAction private constructor(
    private val navigationController: NavigationController,
    private val bottomsheetAction: BottomSheetAction,
) :
    PageAction<PageAccountState> {

    companion object {

        fun create(
            navigationController: NavigationController,
            bottomsheetAction: BottomSheetAction
        ) = PageAccountAction(
            navigationController = navigationController,
            bottomsheetAction = bottomsheetAction,
        )
    }



}