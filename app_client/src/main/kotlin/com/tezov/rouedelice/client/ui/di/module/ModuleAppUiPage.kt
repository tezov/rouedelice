

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


        @ScopeAppUiPage
        @Provides
        fun provideContextDialogLoginAuth(
            state: State.DialogLoginAuthState,
            action: Action.DialogLoginAuthAction
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

        @ScopeAppUiPage
        class DialogLoginAuthState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthState.create()
        }

        //............ *******

        //--AUTH-- *******
        @ScopeAppUiPage
        class PageAccountState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountState.create()
        }

        @ScopeAppUiPage
        class PageDiscoverState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverState.create()
        }

        @ScopeAppUiPage
        class PageHelpState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpState.create()
        }

        @ScopeAppUiPage
        class PagePaymentState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentState.create()
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

        @ScopeAppUiPage
        class DialogLoginAuthAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.lobby.loginAuth.PageLoginAuthAction.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

        //............ *******

        //--AUTH-- *******
        @ScopeAppUiPage
        class PageAccountAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val bottomSheetAction: ModuleCoreUiActivity.Action.BottomSheetAction,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.account.PageAccountAction.create(
                    navigationController.get(),
                    bottomSheetAction.get()
                )
        }

        @ScopeAppUiPage
        class PageDiscoverAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.discover.PageDiscoverAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.help.PageHelpAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PagePaymentAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.pageMain.auth.payment.PagePaymentAction.create(
                    navigationController.get()
                )
        }

        //............ *******
    }



}