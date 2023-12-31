

package com.tezov.rouedelice.client.ui.pageMain.auth.info

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_adr_ui_core.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_ui_core.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.style.OutfitTextStateColor
import com.tezov.lib_adr_ui_core.theme.theme.*

val PageMenuTheme.colors: PageMenuTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageMenuTheme.provides(value: PageMenuTheme.Colors) = localColors provides value

val PageMenuTheme.typographies: PageMenuTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageMenuTheme.provides(value: PageMenuTheme.Typographies) =
    localTypographies provides value

val PageMenuTheme.styles: PageMenuTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageMenuTheme.provides(value: PageMenuTheme.Style) = localStyles provides value

object PageMenuTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val accent: Color,
        val primary: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val headline: OutfitTextStateColor,
        val subHeadline: OutfitTextStateColor,
        val title: OutfitTextStateColor,
        val body: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        headline = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.primary.asStateSimple
        },
        subHeadline = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = colors.primary.asStateSimple
        },
        title = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = colors.primary.asStateSimple
        },
        body = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val dummuy: Int = 0,
    )

    @Composable
    fun provideStyles() = Style(

    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}