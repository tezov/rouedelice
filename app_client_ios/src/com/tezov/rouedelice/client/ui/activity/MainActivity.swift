import SwiftUI
import lib_ios_app_core

struct MainActivity: View {
    var body: some View {
        NavigationGraph()
    }
}


struct withBottomNavigationBar<Content: View>: View {
    let items:[BottomNavigationItem]
    @Binding var selected:Int
    let onClick: (NavigationRouteManager.Super.Route) -> Void
    var content: ()-> Content

    var body: some View {
        GeometryReader { geometry in
            VStack(spacing: 0) {
                content()
                    .frame(maxWidth: .infinity,maxHeight:.infinity)
                BottomNavigation(
                    items : items,
                    selected: _selected,
                    onClick: onClick
                )
            }
            .frame(width: geometry.size.width, height: geometry.size.height)
        }
    }
}


struct empty<Content: View>: View {
    var content: ()-> Content

    var body: some View {
        GeometryReader { geometry in
            content()
            .frame(width: geometry.size.width, height: geometry.size.height)
        }
    }
}

