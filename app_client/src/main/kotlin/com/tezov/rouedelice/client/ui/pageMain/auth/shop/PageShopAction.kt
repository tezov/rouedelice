

package com.tezov.rouedelice.client.ui.pageMain.auth.shop

import com.tezov.lib_adr_sdk_core.navigation.NavigationController
import com.tezov.lib_adr_sdk_core.ui.composition.activity.sub.bottomsheet.BottomSheetAction
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.PageAction

class PageShopAction private constructor(
    private val navigationController: NavigationController,
    private val bottomsheetAction: BottomSheetAction,
) :
    PageAction<PageShopState> {

    companion object {

        fun create(
            navigationController: NavigationController,
            bottomsheetAction: BottomSheetAction
        ) = PageShopAction(
            navigationController = navigationController,
            bottomsheetAction = bottomsheetAction,
        )
    }



}