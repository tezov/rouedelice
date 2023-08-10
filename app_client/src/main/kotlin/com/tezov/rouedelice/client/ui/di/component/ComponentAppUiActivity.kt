

package com.tezov.rouedelice.client.ui.di.component

import com.tezov.rouedelice.client.ui.activity.MainActivityAction
import com.tezov.rouedelice.client.ui.activity.MainActivityState
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.rouedelice.client.ui.di.module.ModuleAppUiActivity
import com.tezov.rouedelice.client.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_adr_app_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_app_core.ui.di.component.ComponentCoreUiActivity
import dagger.Component

object ComponentAppUiActivity {

    @ScopeAppUiActivity
    @Component(
        dependencies = [ComponentCoreUiActivity.EntryPoint::class],
        modules = [ModuleAppUiActivity.MapperContext::class]
    )
    interface EntryPoint : ComponentCoreUiActivity.Exposer, Exposer {

        @Component.Factory
        interface Factory {
            fun create(
                componentCoreActivity: ComponentCoreUiActivity.EntryPoint,
            ): EntryPoint
        }

        fun accessorPage(): DiAccessorAppUiPage

        fun contextMain(): ComposableContext<MainActivityState, MainActivityAction>

    }

    interface Exposer {

        fun exposeAppActivityMainState(): ModuleAppUiActivity.State.ActivityMainState
        fun exposeAppActivityMainAction(): ModuleAppUiActivity.Action.ActivityMainAction
    }

}

