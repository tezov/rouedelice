import lib_ios_app_core
import lib_ios_core
import lib_ios_ui_core
import SwiftUI

let navControler = NavigationController.Core(
    navHostController: NavHostCore.Controller(),
    navigationNotifier: NavigationNotifier()
)

let navRouteManager = NavigationRouteManager(
    controller: navControler,
    snackbarAction: SnackbarAction()
)

struct NavigationGraph: View {
    
    let a = navRouteManager
    
    var body: some View {
        NavHost(
            navController: navControler,
            startRoute: NavigationRouteManager.startNavRoute
        ) { builder in

            builder.navigation(
                route: NavigationRouteManager.Super.Route.NavLobby,
                startRoute: NavigationRouteManager.startLobbyRoute
            ) { builder in

                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Splash
                ) { graphEntry in
                    PageSplash(graphEntry: graphEntry)
                }

                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Lounge
                ) { graphEntry in
//                    (LocalActivity.current as MainActivity).empty {
                    PageLounge(graphEntry: graphEntry)
//                    }
                }
            }

            builder.navigation(
                route: NavigationRouteManager.Super.Route.NavAuth,
                startRoute: NavigationRouteManager.startAuthRoute
            ) { builder in

                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Shop
                ) { graphEntry in
//                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageShop(graphEntry: graphEntry)
//                    }
                }
                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Cart
                ) { graphEntry in
//                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageCart(graphEntry: graphEntry)
//                    }
                }
                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Check
                ) { graphEntry in
//                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageCheck(graphEntry: graphEntry)
//                    }
                }
                builder.composableTransient(
                    route: NavigationRouteManager.Super.Route.Menu
                ) { graphEntry in
//                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageMenu(graphEntry: graphEntry)
//                    }
                }
            }
        }
    }
}
