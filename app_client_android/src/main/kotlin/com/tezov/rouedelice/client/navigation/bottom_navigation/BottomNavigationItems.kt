package com.tezov.rouedelice.client.navigation.bottom_navigation

import com.tezov.rouedelice.app_client_android.R
import com.tezov.rouedelice.client.navigation.NavigationRouteManager.*
import com.tezov.lib_adr_app_core.navigation.bottom_navigation.BottomNavigationItem

object BottomNavigationItems {
    val items: List<BottomNavigationItem> by lazy {
        listOf(
            BottomNavigationItem(
                R.string.nav_btm_shop,
                R.drawable.ic_shopping_fill_24dp,
                R.drawable.ic_shopping_24dp,
                Route.Shop
            ),
            BottomNavigationItem(
                R.string.nav_btm_cart,
                R.drawable.ic_list_square_24dp,
                R.drawable.ic_list_24dp,
                Route.Cart
            ),
            BottomNavigationItem(
                R.string.nav_btm_check,
                R.drawable.ic_map_fill_24dp,
                R.drawable.ic_map_24dp,
                Route.Check
            ),
            BottomNavigationItem(
                R.string.nav_btm_menu,
                com.tezov.lib_adr_ui_cpt.R.drawable.ic_dashboard_fill_24dp,
                com.tezov.lib_adr_ui_cpt.R.drawable.ic_dashboard_24dp,
                Route.Menu
            ),
        )
    }
}
