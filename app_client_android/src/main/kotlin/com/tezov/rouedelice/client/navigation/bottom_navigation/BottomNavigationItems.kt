

package com.tezov.rouedelice.client.navigation.bottom_navigation

import com.tezov.rouedelice.app_client_android.R
import com.tezov.rouedelice.client.navigation.NavigationRoutes.*
import com.tezov.lib_adr_app_core.navigation.NavigationRouteManager
import com.tezov.lib_adr_app_core.navigation.bottom_navigation.BottomNavigationItemData

sealed class BottomNavigationItems(
    titleResourceId: Int,
    iconActive: Int,
    iconInactive: Int,
    route: NavigationRouteManager.Route
) :
    BottomNavigationItemData(titleResourceId, iconActive, iconInactive, route) {
    companion object {
        val items: Set<BottomNavigationItemData> by lazy {
            setOf(
                BottomNavigationItemData(
                    R.string.nav_btm_shop,
                    R.drawable.ic_shopping_fill_24dp,
                    R.drawable.ic_shopping_24dp,
                    Route.Shop
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_cart,
                    R.drawable.ic_list_square_24dp,
                    R.drawable.ic_list_24dp,
                    Route.Cart
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_check,
                    R.drawable.ic_map_fill_24dp,
                    R.drawable.ic_map_24dp,
                    Route.Check
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_menu,
                    com.tezov.lib_adr_ui_cpt.R.drawable.ic_dashboard_fill_24dp,
                    com.tezov.lib_adr_ui_cpt.R.drawable.ic_dashboard_24dp,
                    Route.Menu
                ),
            )
        }
    }

}