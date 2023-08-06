

package com.tezov.rouedelice.client.ui.pageMain.lobby.lounge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_adr_sdk_core.animation.AnimationCompound.Companion.animate
import com.tezov.lib_adr_sdk_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_sdk_core.paintArt.Shape
import com.tezov.lib_adr_sdk_core.ui.component.block.HorizontalPager
import com.tezov.lib_adr_sdk_core.ui.component.chunk.*
import com.tezov.lib_adr_sdk_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_sdk_core.ui.di.common.ExtensionCoreUi.state
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_sdk_core.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_sdk_core.ui.theme.style.padding
import com.tezov.lib_adr_sdk_core.ui.theme.theme.dimensionsPaddingExtended

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

        }
    }

}