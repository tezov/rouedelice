

package com.tezov.rouedelice.client.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.tezov.lib_adr_sdk_core.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_adr_sdk_core.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_adr_sdk_core.ui.theme.theme.provides
import com.tezov.rouedelice.client.ui.theme.ThemeTypographyProviders

object ThemeApplication {
    @Composable
    fun Default(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                MaterialTheme provides ThemeColorProviders.common(),
                MaterialTheme provides ThemeDimensionProviders.common(),
                MaterialTheme provides ThemeDimensionProviders.paddings(),
                MaterialTheme provides ThemeDimensionProviders.icons(),
                MaterialTheme provides ThemeTypographyProviders.common(),
                MaterialTheme provides ThemeShapeProviders.common(),
                MaterialTheme provides ThemeBorderProviders.common(),
            ),
            parent = {
                arrayOf(
                    MaterialTheme provides ThemeComponentProviders.common(),
                    MaterialTheme provides ThemeComponentProviders.buttons(),
                    MaterialTheme provides ThemeComponentProviders.link(),
                )
            },
            child = {
                arrayOf()
            },
        ) {
            MaterialTheme(
                colors = ThemeColorsExtended.materialLight(),
                typography = androidx.compose.material.Typography(),
                content = content
            )
        }

    }
}








