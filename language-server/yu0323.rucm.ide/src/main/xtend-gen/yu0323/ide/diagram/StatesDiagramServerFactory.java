package yu0323.ide.diagram;

import java.util.Collections;
import java.util.List;
import org.eclipse.sprotty.IDiagramServer;
import org.eclipse.sprotty.xtext.DiagramServerFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class StatesDiagramServerFactory extends DiagramServerFactory {
  @Override
  public List<String> getDiagramTypes() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("states-diagram"));
  }
  
  @Override
  public IDiagramServer createDiagramServer(final String diagramType, final String clientId) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method serverLayoutKind(Object) is undefined for the type LanguageAwareDiagramServer"
      + "\nThe method or field ServerLayoutKind is undefined"
      + "\nAUTOMATIC cannot be resolved");
  }
}
