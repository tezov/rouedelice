

package com.tezov.rouedelice.client.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.rouedelice.client.ui.theme.font.fontIbm
import com.tezov.rouedelice.client.ui.theme.font.fontIndie
import com.tezov.rouedelice.client.ui.theme.font.fontRoboto
import com.tezov.lib_adr_app_core.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_adr_app_core.navigation.top_app_bar.TopAppBar
import com.tezov.lib_adr_app_core.ui.composition.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_adr_app_core.ui.composition.activity.sub.dialog.Dialog
import com.tezov.lib_adr_app_core.ui.composition.activity.sub.snackbar.Snackbar
import com.tezov.lib_adr_app_core.ui.theme.theme.ThemeComponentExtended
import com.tezov.lib_adr_ui_core.theme.style.*
import com.tezov.lib_adr_ui_core.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.style.OutfitState.Input.Style.Companion.asStateInput
import com.tezov.lib_adr_ui_core.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_adr_ui_core.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_adr_ui_core.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_adr_ui_core.theme.theme.*
import com.tezov.lib_adr_ui_cpt.component.core.block.HorizontalPager
import com.tezov.lib_adr_ui_cpt.component.core.block.HorizontalRoller
import com.tezov.lib_adr_ui_cpt.component.core.chunk.Button
import com.tezov.lib_adr_ui_cpt.component.core.chunk.DropDownMenu
import com.tezov.lib_adr_ui_cpt.component.core.chunk.Icon
import com.tezov.lib_adr_ui_cpt.component.core.chunk.TextField

object ThemeComponentProviders {

    @Composable
    fun common() = ThemeComponentExtended.Common(
        topAppBar = TopAppBar.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.normal,
            outfitText = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIndie,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.5.sp,
                ),
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            ),
            colorBackground = MaterialTheme.colorsExtended.backgroundElevated.shady,
            colorIconStart = MaterialTheme.colorsExtended.primary.accent,
        ),
        bottomNavigation = BottomNavigation.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.micro,
            outfitText = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.5.sp
            ).asTextStateColor,
            colorBackground = MaterialTheme.colorsExtended.backgroundElevated.shady,
            outfitColor = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.dark,
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.normal,
            outfitFrame = OutfitFrameStateColor(
                outfitBorder = MaterialTheme.bordersExtended.block.big.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.decor.asStateSimple
                },
                outfitShape = MaterialTheme.shapesExtended.block.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple
                }
            )
        ),
        bottomSheet = BottomSheet.Sheet.Style(
            outfitShape = MaterialTheme.shapesExtended.block.big.copy{
                size = size?.firstNotNull?.let {
                    OutfitShape.Size(
                        topStart = it,
                        topEnd = it
                    )
                }
                outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple
            }
        ),
        snackBar = Snackbar.Style(
            outfitTextMessage = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.onBackgroundModal.default,
                ),
            ),
            outfitTextAction = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.onBackgroundModal.default,
                ),
            ),
            outfitShape = MaterialTheme.shapesExtended.block.normal.copy {
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.backgroundModal.fade,
                )
            },
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.big,
        ),
    )

    @Composable
    fun buttons() = ThemeComponentExtended.Buttons(
        primary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        secondary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.shiny,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                },
                outfitBorder = MaterialTheme.bordersExtended.button.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        tertiary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal,
                outfitBorder = MaterialTheme.bordersExtended.button.big.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsPalette.grayLight,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.big.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsPalette.grayBlack,
                )
            }
        )
    )

    @Composable
    fun link() = ThemeComponentExtended.Links(
        primary = MaterialTheme.typographiesExtended.link.normal.copy {
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.default,
                inactive = MaterialTheme.colorsPalette.grayLight,
            )
        },
        secondary = MaterialTheme.typographiesExtended.link.big.copy {
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.default,
                inactive = MaterialTheme.colorsPalette.grayLight,
            )
        },
        tertiary = MaterialTheme.typographiesExtended.link.small.copy {
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.default,
                inactive = MaterialTheme.colorsPalette.grayLight,
            )
        }
    )

    @Composable
    fun dropDownMenu() = DropDownMenu.StateColor.Style(
        outfitText = MaterialTheme.typographiesExtended.menu.normal.copy {
            outfitState = MaterialTheme.colorsExtended.onBackgroundModal.default.asStateSimple
        },
        colorBackgroundMenu = MaterialTheme.colorsExtended.backgroundModal.default
    )

    @Composable
    fun pagerWidthTabRowStyle() = HorizontalPager.WithTabRow.Style(
        outfitText = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.fade,
            )
        },
        colorIndicator = OutfitStateBiStable(
            active = MaterialTheme.colorsExtended.primary.accent,
            inactive = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        ),
    )

        @Composable
    fun pagerWidthIndicatorStyle() = HorizontalPager.WithIndicator.Style(
        outfitShapeIndicator = OutfitShapeStateColor(
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.default.copy(alpha = 0.6f),
            )
        ),
        paddingTopIndicator = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical,
        sizeIndicator = 12.dp,
        spacingIndicator = MaterialTheme.dimensionsPaddingExtended.element.big.horizontal,
    )

}