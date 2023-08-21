import SwiftUI
import lib_ios_app_core

struct PageLounge: View {
    let graphEntry:ComposableNavigator.GraphEntry
    
    init(graphEntry: ComposableNavigator.GraphEntry) {
        self.graphEntry = graphEntry
    }
    
    var body: some View {
        
        Text("PageLounge")
        
    }
    
}
