package io.typefox.examples.theia.states.ide.launch

import com.google.gson.GsonBuilder
import org.eclipse.sprotty.server.json.ActionTypeAdapter
import org.eclipse.sprotty.server.json.EnumTypeAdapter
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.util.Modules2

class StatesLanguageServerSetup extends DiagramLanguageServerSetup {
	
	override setupLanguages() {
	}
	
	override configureGson(GsonBuilder gsonBuilder) {
		gsonBuilder
			.registerTypeAdapterFactory(new ActionTypeAdapter.Factory)
			.registerTypeAdapterFactory(new EnumTypeAdapter.Factory)
	}

	override getLanguageServerModule() {
		Modules2.mixin(
			new ServerModule,
			new SyncDiagramServerModule
		) 
	}
	
}