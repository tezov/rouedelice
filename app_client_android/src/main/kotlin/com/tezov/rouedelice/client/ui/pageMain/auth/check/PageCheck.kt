

package com.tezov.rouedelice.client.ui.pageMain.auth.check

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

object PageCheck : Page<PageCheckState, PageCheckAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PageCheckState, PageCheckAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextCheck().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageCheckTheme provides PageCheckTheme.provideColors(),
                PageCheckTheme provides PageCheckTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageCheckTheme provides PageCheckTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageCheckTheme provides PageCheckTheme.provideStyles(),
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(PageCheckTheme.colors.background)
            ) {

            }
        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()
}