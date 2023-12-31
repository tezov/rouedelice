

package com.tezov.rouedelice.client.ui.pageMain.auth.check

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_adr_ui_core.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_ui_core.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.style.OutfitTextStateColor
import com.tezov.lib_adr_ui_core.theme.theme.*
import com.tezov.lib_adr_ui_cpt.component.core.layout.ColumnCollapsibleHeader

val PageCheckTheme.colors: PageCheckTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageCheckTheme.provides(value: PageCheckTheme.Colors) = localColors provides value

val PageCheckTheme.dimensions: PageCheckTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageCheckTheme.provides(value: PageCheckTheme.Dimensions) =
    localDimensions provides value

val PageCheckTheme.typographies: PageCheckTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageCheckTheme.provides(value: PageCheckTheme.Typographies) =
    localTypographies provides value

val PageCheckTheme.styles: PageCheckTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageCheckTheme.provides(value: PageCheckTheme.Style) = localStyles provides value

object PageCheckTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val backgroundElevatedOverlay: Color,
        val accent: Color,
        val primary: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        backgroundElevatedOverlay = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val headLineMin: TextUnit,
        val headlineMax: TextUnit,
        val headerProperties: ColumnCollapsibleHeader.Properties,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        headLineMin = 24.sp,
        headlineMax = 54.sp,
        headerProperties = ColumnCollapsibleHeader.Properties(min = 50.dp, max = 136.dp)
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
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

    data class Style(
        val dummy: Int = 0,

        )

    @Composable
    fun provideStyles() = Style(

    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }
}