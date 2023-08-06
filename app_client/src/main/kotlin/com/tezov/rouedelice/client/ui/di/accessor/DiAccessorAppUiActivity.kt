

package com.tezov.rouedelice.client.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.ui.di.component.ComponentAppUiActivity
import com.tezov.rouedelice.client.ui.di.component.DaggerComponentAppUiActivity_EntryPoint
import com.tezov.lib_adr_sdk_core.ui.compositionTree.activity.Activity
import com.tezov.lib_adr_sdk_core.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_adr_sdk_core.ui.compositionTree.activity.Activity.Companion.LocalCoreApplication
import com.tezov.lib_adr_sdk_core.ui.di.accessor.DiAccessor
import com.tezov.lib_adr_sdk_core.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.rouedelice.client.application.Application

class DiAccessorAppUiActivity protected constructor() :
    DiAccessor<ComponentAppUiActivity.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = (LocalCoreApplication.current as Application).accessorAppUi

        @Composable
        operator fun invoke(requester: Activity<*, *>) =
            (LocalCoreApplication.current as Application)
                .accessorAppUi
                .with(key = requester)
    }

    @Composable
    override fun create() = DaggerComponentAppUiActivity_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiActivity().with(
                key = LocalActivity.current
            )
        )

    @Composable
    override fun dispose(requester: Any, key: Key) =
        DiAccessorCoreUiActivity().dispose(requester, key) or super.dispose(requester, key)

    @Composable
    fun remember(requester: Activity<*, *>) {
        with(requester).contextMain().remember()
    }

}