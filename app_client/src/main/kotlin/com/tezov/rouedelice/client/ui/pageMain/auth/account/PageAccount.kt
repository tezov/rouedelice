

package com.tezov.rouedelice.client.ui.pageMain.auth.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_sdk_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Icon
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Shadow
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Text
import com.tezov.lib_adr_sdk_core.ui.component.layout.ColumnCollapsibleHeader
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_sdk_core.ui.modifier.then
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsPaddingExtended

object PageAccount : Page<PageAccountState, PageAccountAction> {

    @Composable
    override fun Page<PageAccountState, PageAccountAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextAccount().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageAccountTheme provides PageAccountTheme.provideColors(),
                PageAccountTheme provides PageAccountTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideStyles(),
                )
            }
        ) {

        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()

}