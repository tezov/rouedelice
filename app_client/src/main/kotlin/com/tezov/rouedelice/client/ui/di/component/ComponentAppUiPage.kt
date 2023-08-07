

package com.tezov.rouedelice.client.ui.di.component

import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiModal
import com.tezov.rouedelice.client.ui.di.module.ModuleAppUiPage
import com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopAction
import com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopState
import com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartAction
import com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartState
import com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuAction
import com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuState
import com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckAction
import com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckState
import com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeAction
import com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeState
import com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashAction
import com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashState
import com.tezov.rouedelice.client.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_adr_app_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_app_core.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_adr_app_core.ui.di.component.ComponentCoreUiPage
import dagger.Component

object ComponentAppUiPage {

    @ScopeAppUiPage
    @Component(
        dependencies = [ComponentCoreUiPage.EntryPoint::class, ComponentAppUiActivity.EntryPoint::class],
        modules = [ModuleAppUiPage.MapperContext::class]
    )
    interface EntryPoint : ComponentCoreUiActivity.Exposer {

        @Component.Factory
        interface Factory {
            fun create(
                componentCorePage: ComponentCoreUiPage.EntryPoint,
                componentAppActivity: ComponentAppUiActivity.EntryPoint
            ): EntryPoint
        }

        fun accessorDialog(): DiAccessorAppUiModal

        fun controllerDialogAuthCloseApp(): ModuleAppUiPage.Provided.DialogAuthCloseAppController

        //--LOBBY-- *******
        fun contextSplash(): ComposableContext<PageSplashState, PageSplashAction>
        fun contextLounge(): ComposableContext<PageLoungeState, PageLoungeAction>
        //............ *******

        //--AUTH-- *******
        fun contextAccount(): ComposableContext<PageShopState, PageShopAction>
        fun contextDiscover(): ComposableContext<PageCartState, PageCartAction>
        fun contextPayment(): ComposableContext<PageCheckState, PageCheckAction>
        fun contextHelp(): ComposableContext<PageMenuState, PageMenuAction>
        //............ *******



    }


}

