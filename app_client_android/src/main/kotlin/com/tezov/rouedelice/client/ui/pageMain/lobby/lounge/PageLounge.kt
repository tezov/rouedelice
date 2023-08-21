package com.tezov.rouedelice.client.ui.pageMain.lobby.lounge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_adr_app_core.navigation.navigator.ComposableNavigator.GraphEntry
import com.tezov.lib_adr_app_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_ui_core.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_ui_core.theme.style.background

object PageLounge : Page<PageLoungeState, PageLoungeAction> {

    @Composable
    override fun Page<PageLoungeState, PageLoungeAction>.content(
        graphEntry: GraphEntry,
        innerPadding: PaddingValues
    ) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextLounge().apply {
            remember()
        }
        val state = accessor.state()
        val action = accessor.action()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageLoungeTheme provides PageLoungeTheme.provideColors(),
                PageLoungeTheme provides PageLoungeTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageLoungeTheme provides PageLoungeTheme.provideShapes(),
                    PageLoungeTheme provides PageLoungeTheme.provideBorders(),
                    PageLoungeTheme provides PageLoungeTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageLoungeTheme provides PageLoungeTheme.provideStyles()
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(PageLoungeTheme.colors.background)
            ) {

            }
        }
    }

}