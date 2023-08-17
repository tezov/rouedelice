

package com.tezov.rouedelice.client.navigation

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.tezov.rouedelice.client.navigation.NavigationRoutes.Route
import com.tezov.rouedelice.client.ui.activity.MainActivity
import com.tezov.rouedelice.client.ui.di.accessor.DiAccessorAppUiActivity
import com.tezov.rouedelice.client.ui.pageMain.auth.shop.PageShop
import com.tezov.rouedelice.client.ui.pageMain.auth.cart.PageCart
import com.tezov.rouedelice.client.ui.pageMain.auth.info.PageMenu
import com.tezov.rouedelice.client.ui.pageMain.auth.check.PageCheck
import com.tezov.rouedelice.client.ui.pageMain.lobby.lounge.PageLounge
import com.tezov.rouedelice.client.ui.pageMain.lobby.splash.PageSplash
import com.tezov.lib_adr_app_core.navigation.NavHost
import com.tezov.lib_adr_app_core.navigation.NavigationAnimation
import com.tezov.lib_adr_app_core.navigation.NavigationRouteManager
import com.tezov.lib_adr_app_core.navigation.navigator.GraphEntry
import com.tezov.lib_adr_app_core.navigation.navigator.composable.composableTransient
import com.tezov.lib_adr_app_core.navigation.navigator.composableOverlay.composableOverlay
import com.tezov.lib_adr_app_core.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_adr_app_core.ui.di.common.ExtensionCoreUi.action

object NavigationGraph {

    @Composable
    operator fun invoke() {
        val accessor = DiAccessorAppUiActivity().with(LocalActivity.current)
        val mainAction = accessor.contextMain().action()

        NavHost(
            navController = mainAction.navigationRoutes.controller,
            startRoute = NavigationRoutes.startNavRoute,
        ) {
            navigation(
                route = Route.NavLobby,
                startRoute = NavigationRoutes.startLobbyRoute
            ) {
                composableTransient(
                    route = Route.Splash
                ) { graphEntry ->
                    PageSplash(graphEntry = graphEntry, innerPadding = PaddingValues())
                }
                composableTransient(
                    route = Route.Lounge,
                ) { graphEntry ->
                    (LocalActivity.current as MainActivity).empty { innerPadding ->
                        PageLounge(graphEntry = graphEntry, innerPadding = innerPadding)
                    }
                }
            }
            navigation(
                route = Route.NavAuth,
                startRoute = NavigationRoutes.startAuthRoute
            ) {
                composableTransient(
                    route = Route.Shop
                ) { graphEntry ->
                    (LocalActivity.current as MainActivity).withBottomNavigationBar { innerPadding ->
                        PageShop(graphEntry = graphEntry, innerPadding = innerPadding)
                    }
                }
                composableTransient(
                    route = Route.Cart
                ) { graphEntry ->
                    (LocalActivity.current as MainActivity).withBottomNavigationBar { innerPadding ->
                        PageCart(graphEntry = graphEntry, innerPadding = innerPadding)
                    }
                }
                composableTransient(
                    route = Route.Check
                ) { graphEntry ->
                    (LocalActivity.current as MainActivity).withBottomNavigationBar { innerPadding ->
                        PageCheck(graphEntry = graphEntry, innerPadding = innerPadding)
                    }
                }
                composableTransient(
                    route = Route.Menu
                ) { graphEntry ->
                    (LocalActivity.current as MainActivity).withBottomNavigationBar { innerPadding ->
                        PageMenu(graphEntry = graphEntry, innerPadding = innerPadding)
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.navigation(
        startRoute: NavigationRouteManager.Route,
        route: NavigationRouteManager.Route,
        builder: NavGraphBuilder.() -> Unit
    ) = navigation(
        startDestination = startRoute.path,
        route = route.path,
        builder = builder,
    )

    private fun NavGraphBuilder.composableTransient(
        route: NavigationRouteManager.Route,
        arguments: List<NamedNavArgument> = emptyList(),
        animationConfig: NavigationAnimation.Config? = null,
        content: @Composable BoxScope.(GraphEntry) -> Unit
    ) = composableTransient(
        route = route.path,
        arguments = arguments,
        animationConfig = animationConfig,
        content = content
    )

    private fun NavGraphBuilder.composableOverlay(
        route: NavigationRouteManager.Route,
        arguments: List<NamedNavArgument> = emptyList(),
        animationConfig: NavigationAnimation.Config? = null,
        content: @Composable BoxScope.(GraphEntry) -> Unit,
    ) = composableOverlay(
        route = route.path,
        arguments = arguments,
        animationConfig = animationConfig,
        content = content
    )

}