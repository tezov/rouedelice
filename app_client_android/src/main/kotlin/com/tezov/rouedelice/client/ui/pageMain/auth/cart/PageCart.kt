

package com.tezov.rouedelice.client.ui.pageMain.auth.cart

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

object PageCart : Page<PageCartState, PageCartAction> {

    @Composable
    override fun Page<PageCartState, PageCartAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextCart().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageCartTheme provides PageCartTheme.provideColors(),
                PageCartTheme provides PageCartTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageCartTheme provides PageCartTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageCartTheme provides PageCartTheme.provideStyles(),
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(PageCartTheme.colors.background)
            ) {

            }
        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()

}