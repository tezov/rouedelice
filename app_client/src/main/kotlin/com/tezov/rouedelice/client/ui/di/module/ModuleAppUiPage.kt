

package com.tezov.rouedelice.client.ui.di.module

import com.tezov.lib_adr_sdk_core.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableWrapper
import com.tezov.lib_adr_sdk_core.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiPage {

    @Module
    class MapperContext {

        //--LOBBY-- *******
        @ScopeAppUiPage
        @Provides
        fun provideContextSplash(
            state: State.PageSplashState,
            action: Action.PageSplashAction
        ) = ComposableContext(state, action)


        @ScopeAppUiPage
        @Provides
        fun provideContextLounge(
            state: State.PageLoungeState,
            action: Action.PageLoungeAction
        ) = ComposableContext(state, action)

        //............ *******

        //--AUTH-- *******
        @ScopeAppUiPage
        @Provides
        fun provideContextAccount(
            state: State.PageAccountState,
            action: Action.PageAccountAction
        ) = ComposableContext(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextDiscover(
            state: State.PageDiscoverState,
            action: Action.PageDiscoverAction
        ) = ComposableContext(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextHelp(
            state: State.PageHelpState,
            action: Action.PageHelpAction
        ) = ComposableContext(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextPayment(
            state: State.PagePaymentState,
            action: Action.PagePaymentAction
        ) = ComposableContext(state, action)

        //............ *******
    }

    object Provided {

        @ScopeAppUiPage
        class DialogAuthCloseAppController @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppController.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

    }

    object State {

        //--LOBBY-- *******
        @ScopeAppUiPage
        class PageSplashState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashState.create()
        }

        @ScopeAppUiPage
        class PageLoungeState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeState.create()
        }

        //............ *******

        //--AUTH-- *******
        @ScopeAppUiPage
        class PageAccountState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopState.create()
        }

        @ScopeAppUiPage
        class PageDiscoverState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartState.create()
        }

        @ScopeAppUiPage
        class PageHelpState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuState.create()
        }

        @ScopeAppUiPage
        class PagePaymentState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckState.create()
        }

        //............ *******

    }

    object Action {
        //--LOBBY-- *******
        @ScopeAppUiPage
        class PageSplashAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplashAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageLoungeAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLoungeAction.create(
                    navigationController.get(),
                )
        }

        //............ *******

        //--AUTH-- *******
        @ScopeAppUiPage
        class PageAccountAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val bottomSheetAction: ModuleCoreUiActivity.Action.BottomSheetAction,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShopAction.create(
                    navigationController.get(),
                    bottomSheetAction.get()
                )
        }

        @ScopeAppUiPage
        class PageDiscoverAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCartAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenuAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PagePaymentAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheckAction.create(
                    navigationController.get()
                )
        }

        //............ *******
    }



}