

package com.tezov.rouedelice.client.ui.pageMain.auth.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_app_core.navigation.navigator.ComposableNavigator.GraphEntry
import com.tezov.lib_adr_app_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_ui_core.extension.ExtensionCompositionLocal

object PageShop : Page<PageShopState, PageShopAction> {

    @Composable
    override fun Page<PageShopState, PageShopAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextShop().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageShopTheme provides PageShopTheme.provideColors(),
                PageShopTheme provides PageShopTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageShopTheme provides PageShopTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageShopTheme provides PageShopTheme.provideStyles(),
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(PageShopTheme.colors.background)
            ) {

            }
        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()

}