

package com.tezov.rouedelice.client.ui.pageMain.lobby.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.tezov.lib_adr_app_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_app_core.ui.compositionTree.page.Page
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.action
import com.tezov.lib_adr_ui_core.theme.theme.colorsExtended
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import kotlinx.coroutines.delay

object PageSplash : Page<PageSplashState, PageSplashAction> {

    @Composable
    override fun Page<PageSplashState, PageSplashAction>.content(
        graphEntry: GraphEntry,
        innerPadding: PaddingValues
    ) {
        val accessor = DiAccessorAppUiPage(requester = this).contextSplash().apply {
            remember()
        }
        val action = accessor.action()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorsExtended.background.default
        ) {
            LaunchedEffect(Unit){
                delay(500)
                action.onStart()
            }
        }
    }

}