package yu0323.ide.diagram

import org.eclipse.sprotty.xtext.IDiagramGenerator

class StatesDiagramModule {
	def Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
		StateDiagramGenerator
	} 
	
	def bindIDiagramServerFactory() {
		StatesDiagramServerFactory
	}
	
	def bindILayoutEngine() {
		StatesLayoutEngine
	}
	
	def bindIDiagramServer() {
		StatesDiagramServer
	}	
}