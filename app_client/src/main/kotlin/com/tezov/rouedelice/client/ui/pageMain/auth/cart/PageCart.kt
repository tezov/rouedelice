

package com.tezov.rouedelice.client.ui.pageMain.auth.cart

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_sdk_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal

object PageCart : Page<PageCartState, PageCartAction> {

    @Composable
    override fun Page<PageCartState, PageCartAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextDiscover().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageDiscoverTheme provides PageDiscoverTheme.provideColors(),
                PageDiscoverTheme provides PageDiscoverTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageDiscoverTheme provides PageDiscoverTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageDiscoverTheme provides PageDiscoverTheme.provideStyles(),
                )
            }
        ) {

        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()

}