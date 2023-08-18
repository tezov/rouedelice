

package com.tezov.rouedelice.client.ui.pageMain.auth.cart

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_adr_ui_core.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_ui_core.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.style.OutfitTextStateColor
import com.tezov.lib_adr_ui_core.theme.theme.*
import com.tezov.lib_adr_ui_core.type.primaire.DpSize
import com.tezov.lib_adr_ui_core.type.primaire.dpSize

val PageCartTheme.colors: PageCartTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageCartTheme.provides(value: PageCartTheme.Colors) = localColors provides value

val PageCartTheme.typographies: PageCartTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageCartTheme.provides(value: PageCartTheme.Typographies) =
    localTypographies provides value

val PageCartTheme.dimensions: PageCartTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageCartTheme.provides(value: PageCartTheme.Dimensions) =
    localDimensions provides value

val PageCartTheme.styles: PageCartTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageCartTheme.provides(value: PageCartTheme.Style) = localStyles provides value

object PageCartTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val backgroundElevatedOverlay: Color,
        val accent: Color,
        val primary: Color,
        val neutral: Color,
        val decor: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        backgroundElevatedOverlay = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        neutral = MaterialTheme.colorsExtended.primary.shady,
        decor = MaterialTheme.colorsExtended.backgroundElevated.decor,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val headline: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        headline = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Dimensions(
        val header: Dp,
        val iconCard: DpSize,
        val imageCard: DpSize,
        val spacingTopSectionRowToBottomSectionCard: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        header = 192.dp,
        iconCard = 64.dpSize,
        imageCard = 88.dpSize,
        spacingTopSectionRowToBottomSectionCard = 64.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val dummy:Int = 0
    )

    @Composable
    fun provideStyles() = Style(

    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}