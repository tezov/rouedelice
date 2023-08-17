

package com.tezov.rouedelice.client.ui.di.component

import com.tezov.rouedelice.client.ui.di.module.ModuleAppUiModal
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationAction
import com.tezov.rouedelice.client.ui.dialog.auth.closeAppConfirmation.DialogCloseAppConfirmationState
import com.tezov.rouedelice.client.ui.di.annotation.scope.ScopeAppUiModal
import com.tezov.lib_adr_app_core.ui.di.common.ComposableContext
import com.tezov.lib_adr_app_core.ui.di.component.ComponentCoreUiModal
import dagger.Component

object ComponentAppUiModal {

    @ScopeAppUiModal
    @Component(
        dependencies = [ComponentCoreUiModal.EntryPoint::class, ComponentAppUiPage.EntryPoint::class],
        modules = [ModuleAppUiModal.MapperContext::class]
    )
    interface EntryPoint {

        @Component.Factory
        interface Factory {
            fun create(
                componentCore: ComponentCoreUiModal.EntryPoint,
                componentAppPage: ComponentAppUiPage.EntryPoint
            ): EntryPoint
        }

        fun contextCloseAppConfirmation(): ComposableContext<DialogCloseAppConfirmationState, DialogCloseAppConfirmationAction>

    }

}

