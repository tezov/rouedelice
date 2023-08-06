

package com.tezov.rouedelice.client.ui.di.component

import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiModal
import com.tezov.rouedelice.client.ui.di.module.ModuleAppUiPage
import com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountAction
import com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountState
import com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverAction
import com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverState
import com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpAction
import com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpState
import com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentAction
import com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentState
import com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthAction
import com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthState
import com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeAction
import com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeState
import com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashAction
import com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashState
import com.tezov.lib_adr_sdk_core.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_sdk_core.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_adr_sdk_core.ui.di.component.ComponentCoreUiPage
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
        fun contextLoginAuth(): ComposableContext<PageLoginAuthState, PageLoginAuthAction>
        //............ *******

        //--AUTH-- *******
        fun contextAccount(): ComposableContext<PageAccountState, PageAccountAction>
        fun contextDiscover(): ComposableContext<PageDiscoverState, PageDiscoverAction>
        fun contextPayment(): ComposableContext<PagePaymentState, PagePaymentAction>
        fun contextHelp(): ComposableContext<PageHelpState, PageHelpAction>
        //............ *******



    }


}

