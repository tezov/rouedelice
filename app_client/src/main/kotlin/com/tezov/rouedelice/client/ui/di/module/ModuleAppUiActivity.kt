

package com.tezov.rouedelice.client.ui.di.module

import com.tezov.rouedelice.client.ui.activity.MainActivityAction
import com.tezov.rouedelice.client.ui.activity.MainActivityState
import com.tezov.lib_adr_sdk_core.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_sdk_core.ui.di.common.ComposableWrapper
import com.tezov.lib_adr_sdk_core.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiActivity {

    @Module
    class MapperContext {

        @ScopeAppUiActivity
        @Provides
        fun provideContextMain(
            state: State.ActivityMainState,
            action: Action.ActivityMainAction
        ) = ComposableContext(state, action)

    }

    object State {
        @ScopeAppUiActivity
        class ActivityMainState @Inject constructor(
            private val scaffoldState: ModuleCoreUiActivity.State.ScaffoldState
        ) : ComposableWrapper<MainActivityState>() {
            @androidx.compose.runtime.Composable
            override fun create() = MainActivityState.create(scaffoldState.get())
        }
    }

    object Action {
        @ScopeAppUiActivity
        class ActivityMainAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val snackbarAction: ModuleCoreUiActivity.Action.SnackbarAction,
        ) : ComposableWrapper<MainActivityAction>() {
            @androidx.compose.runtime.Composable
            override fun create() = MainActivityAction.create(
                navigationController.get(),
                snackbarAction.get()
            )
        }
    }

}