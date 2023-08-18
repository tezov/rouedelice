

package com.tezov.rouedelice.client.ui.pageMain.auth.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_app_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_app_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_ui_core.extension.ExtensionCompositionLocal

object PageMenu : Page<PageMenuState, PageMenuAction> {

    @Composable
    override fun Page<PageMenuState, PageMenuAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextMenu().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageMenuTheme provides PageMenuTheme.provideColors(),
            ),
            parent = {
                arrayOf(
                    PageMenuTheme provides PageMenuTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageMenuTheme provides PageMenuTheme.provideStyles(),
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(PageMenuTheme.colors.background)
            ) {

            }
        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()

}