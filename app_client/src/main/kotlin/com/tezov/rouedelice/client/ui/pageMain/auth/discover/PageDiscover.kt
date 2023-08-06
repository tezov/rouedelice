

package com.tezov.rouedelice.client.ui.pageMain.auth.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_sdk_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Text
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsPaddingExtended

object PageDiscover : Page<PageDiscoverState, PageDiscoverAction> {

    @Composable
    override fun Page<PageDiscoverState, PageDiscoverAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
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