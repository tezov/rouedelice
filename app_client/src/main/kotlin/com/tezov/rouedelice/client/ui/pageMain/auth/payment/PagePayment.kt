

package com.tezov.rouedelice.client.ui.pageMain.auth.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController
import com.tezov.lib_adr_sdk_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Shadow
import com.tezov.lib_adr_sdk_core.ui.component.chunk.Text
import com.tezov.lib_adr_sdk_core.ui.component.layout.ColumnCollapsibleHeader
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_sdk_core.ui.modifier.then
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsPaddingExtended

object PagePayment : Page<PagePaymentState, PagePaymentAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PagePaymentState, PagePaymentAction>.content(graphEntry: GraphEntry, innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextPayment().apply {
            remember()
        }
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PagePaymentTheme provides PagePaymentTheme.provideColors(),
                PagePaymentTheme provides PagePaymentTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideStyles(),
                )
            }
        ) {

        }
    }

    @Composable
    override fun onBackButtonPressed() = DialogCloseAppController.handleOnBackPressed()
}