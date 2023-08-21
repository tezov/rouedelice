import Foundation
import lib_ios_app_core
import lib_ios_core

extension NavigationRouteManager.Super.Route {
    // Command        *********************************************
    class NotHandled: NavigationRouteManager.Super.Route {
        static let original = NavigationRouteManager.Super.Route.NotHandled(request: nil)
        
        let request: NavigationController.Request?
        
        private init(request: NavigationController.Request?) {
            self.request = request
            super.init("not_handled")
        }
        
        override public func createCopy() -> NavigationRouteManager.Super.Route {
            return NotHandled(request: request)
        }
        
        override public var isReadOnly: Bool {
            return self === NotHandled.original
        }
        
        static func wrap(request: NavigationController.Request) -> NavigationController.Request {
            return NavigationController.Request(
                to: NavigationRouteManager.Super.Route.NotHandled(request: request),
                askedBy: nil
            )
        }
    }
    
    // Graph        *********************************************
    // LOBBY
    static let Splash = NavigationRouteManager.Super.Route("splash")
    static let Lounge = NavigationRouteManager.Super.Route("lounge")
    static let NavLobby = NavigationRouteManager.Super.Routes(
        "navLobby",
        child: [Splash, Lounge]
    )
    
    // AUTH
    static let Shop = NavigationRouteManager.Super.Route("shop")
    static let Cart = NavigationRouteManager.Super.Route("cart")
    static let Check = NavigationRouteManager.Super.Route("check")
    static let Menu = NavigationRouteManager.Super.Route("menu")
    static let NavAuth = NavigationRouteManager.Super.Routes(
        "navAuth",
        child: [Shop, Cart, Check, Menu]
    )
}

class NavigationRouteManager: NavigationController.Friend {
    typealias Super = lib_ios_app_core.NavigationRouteManager
    
    static let startNavRoute = NavigationRouteManager.Super.Route.NavAuth
    static let startLobbyRoute = NavigationRouteManager.Super.Route.Splash
    static let startAuthRoute = NavigationRouteManager.Super.Route.Shop
    

    let controller: NavigationController.Core
    private let snackbarAction: SnackbarAction

    init(controller: NavigationController.Core, snackbarAction: SnackbarAction) {
        self.controller = controller
        self.snackbarAction = snackbarAction
        let route = controller.routes(friend: self)
        route.add(NavigationRouteManager.Super.Route.NavLobby)
        route.add(NavigationRouteManager.Super.Route.NavAuth)
        route.add(NavigationRouteManager.Super.Route.NotHandled.original)

        controller.addRequestHandler(
            friend: self,
            handlers: [
                (type: BottomNavigationAction.Core.self, handler: navigateFromBottomNavigation),
            ]
        )
        controller.setRequestExceptionHandler(
            friend: self,
            handler: navigateException
        )
        controller.setRequestFeedbackHandler(
            friend: self,
            handler: navigateFeedback
        )
    }

    private func navigateFeedback(request _: NavigationController.Request) {
        print("navigateFeedback")
    }

    private func navigateException(request _: NavigationController.Request?) {
        print("navigateException")
    }

    private func navigateFromBottomNavigation(_ request: NavigationController.Request) {
        print("navigateFromBottomNavigation \(request.to.path)")
        controller.navigate(
            friend: self,
            request: {
                if request.option == nil  {
                    request.option = NavigationController.Option.singleTop(route: request.to)
                }
                return request
            }()
        )
    }
}


