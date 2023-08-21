import lib_ios_app_core

let BottomNavigationItems = BottomNavigationItemsImpl()

struct BottomNavigationItemsImpl {
    internal init() { }

    let items = [
        BottomNavigationItem(
            titleResource: "Shop", // todo come from resource ?
            iconActive: "handbag.fill",
            iconInactive: "handbag",
            route: NavigationRouteManager.Super.Route.Shop
        ),
        BottomNavigationItem(
            titleResource: "Cart",
            iconActive: "list.bullet",
            iconInactive: "list.bullet",
            route: NavigationRouteManager.Super.Route.Cart
        ),
        BottomNavigationItem(
            titleResource: "Check",
            iconActive: "map.fill",
            iconInactive: "map",
            route: NavigationRouteManager.Super.Route.Check
        ),
        BottomNavigationItem(
            titleResource: "Menu",
            iconActive: "rectangle.grid.2x2.fill",
            iconInactive: "rectangle.grid.2x2",
            route: NavigationRouteManager.Super.Route.Menu
        ),
    ]
}
