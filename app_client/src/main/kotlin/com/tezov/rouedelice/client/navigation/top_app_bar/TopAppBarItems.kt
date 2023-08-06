

package com.tezov.rouedelice.client.navigation.top_app_bar

import com.tezov.rouedelice.app_client.R
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager
import com.tezov.lib_adr_sdk_core.navigation.NavigationRouteManager.Route
import com.tezov.lib_adr_sdk_core.navigation.top_app_bar.TopAppBarItemData

sealed class TopAppBarItems(icon: Int, route: Route) : TopAppBarItemData(icon, route) {
    companion object {
        val items: Set<TopAppBarItemData> by lazy {
            setOf(
                Back,
            )
        }
    }

    object Back : TopAppBarItemData(R.drawable.ic_arrow_left_24dp, NavigationRouteManager.Back)


}