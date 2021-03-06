/**
 * generated by Xtext 2.19.0
 */
package yu0323.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import yu0323.RucmRuntimeModule;
import yu0323.RucmStandaloneSetup;
import yu0323.ide.RucmIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class RucmIdeSetup extends RucmStandaloneSetup {
  @Override
  public Injector createInjector() {
    RucmRuntimeModule _rucmRuntimeModule = new RucmRuntimeModule();
    RucmIdeModule _rucmIdeModule = new RucmIdeModule();
    return Guice.createInjector(Modules2.mixin(_rucmRuntimeModule, _rucmIdeModule));
  }
}
