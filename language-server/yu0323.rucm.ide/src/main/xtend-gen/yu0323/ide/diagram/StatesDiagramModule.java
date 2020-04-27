package yu0323.ide.diagram;

import org.eclipse.sprotty.xtext.IDiagramGenerator;
import yu0323.ide.diagram.StateDiagramGenerator;
import yu0323.ide.diagram.StatesDiagramServer;
import yu0323.ide.diagram.StatesDiagramServerFactory;
import yu0323.ide.diagram.StatesLayoutEngine;

@SuppressWarnings("all")
public class StatesDiagramModule {
  public Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
    return StateDiagramGenerator.class;
  }
  
  public Class<StatesDiagramServerFactory> bindIDiagramServerFactory() {
    return StatesDiagramServerFactory.class;
  }
  
  public Class<StatesLayoutEngine> bindILayoutEngine() {
    return StatesLayoutEngine.class;
  }
  
  public Class<StatesDiagramServer> bindIDiagramServer() {
    return StatesDiagramServer.class;
  }
}
