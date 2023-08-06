

package com.tezov.rouedelice.client.ui.di.module


import com.tezov.lib_adr_sdk_core.ui.di.annotation.scope.ScopeAppUiModal
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableWrapper
import com.tezov.lib_adr_sdk_core.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiModal {

    @Module
    class MapperContext {

        @ScopeAppUiModal
        @Provides
        fun provideContextCloseAppConfirmation(
            state: State.DialogCloseAppConfirmationState,
            action: Action.DialogCloseAppConfirmationAction
        ) = ComposableContext(state, action)
    }

    object State {

        @ScopeAppUiModal
        class DialogCloseAppConfirmationState @Inject constructor() :
            ComposableWrapper<com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationState.create()
        }
    }

    object Action {

        @ScopeAppUiModal
        class DialogCloseAppConfirmationAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.DialogAction,
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableWrapper<com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationAction.create(
                    action.get(),
                    navigationController.get()
                )
        }

    }

}