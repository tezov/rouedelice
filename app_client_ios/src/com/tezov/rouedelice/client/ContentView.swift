import SwiftUI
import app_client_shared
import lib_ios_app_core

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
		Text(hello())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
