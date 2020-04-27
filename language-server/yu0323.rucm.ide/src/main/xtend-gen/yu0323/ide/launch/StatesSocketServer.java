package yu0323.ide.launch;

import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.launch.DiagramServerSocketLauncher;
import yu0323.ide.launch.StatesLanguageServerSetup;

@SuppressWarnings("all")
public class StatesSocketServer extends DiagramServerSocketLauncher {
  @Override
  public DiagramLanguageServerSetup createSetup() {
    return new StatesLanguageServerSetup();
  }
  
  public static void main(final String... args) {
    new StatesSocketServer().run(args);
  }
}
