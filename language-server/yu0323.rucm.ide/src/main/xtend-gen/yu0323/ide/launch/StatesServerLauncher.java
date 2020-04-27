package yu0323.ide.launch;

import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.launch.DiagramServerLauncher;
import yu0323.ide.launch.StatesLanguageServerSetup;

@SuppressWarnings("all")
public class StatesServerLauncher extends DiagramServerLauncher {
  @Override
  public DiagramLanguageServerSetup createSetup() {
    return new StatesLanguageServerSetup();
  }
  
  public static void main(final String[] args) {
    new StatesServerLauncher().run(args);
  }
}
