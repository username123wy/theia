package yu0323.ide.diagram;

import com.google.inject.Inject;
import org.eclipse.sprotty.Action;
import org.eclipse.sprotty.xtext.LanguageAwareDiagramServer;
import org.eclipse.sprotty.xtext.ReconnectAction;
import yu0323.ide.diagram.StatesReconnectHandler;

@SuppressWarnings("all")
public class StatesDiagramServer extends LanguageAwareDiagramServer {
  @Inject
  private StatesReconnectHandler reconnectHandler;
  
  @Override
  protected void handleAction(final Action action) {
    String _kind = action.getKind();
    boolean _tripleEquals = (_kind == ReconnectAction.KIND);
    if (_tripleEquals) {
      this.reconnectHandler.handle(((ReconnectAction) action), this);
    } else {
      super.handleAction(action);
    }
  }
}
