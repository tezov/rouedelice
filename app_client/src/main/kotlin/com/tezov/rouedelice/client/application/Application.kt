

package com.tezov.rouedelice.client.application

import androidx.compose.runtime.Composable
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiActivity
import com.tezov.lib_adr_sdk_core.ui.compositionTree.activity.Activity.Companion.LocalCoreApplication
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

val LocalApplication @Composable get() = LocalCoreApplication.current as Application

class Application : com.tezov.lib_adr_sdk_core.application.Application() {
    lateinit var accessorAppUi: DiAccessorAppUiActivity

    override fun onCreate() {
        super.onCreate()
        accessorAppUi = DiAccessorAppUiActivity::class.primaryConstructor?.apply {
            isAccessible = true
        }?.call() ?: throw Exception("failed to create instance of AccessorAppUiApplication")
    }

}