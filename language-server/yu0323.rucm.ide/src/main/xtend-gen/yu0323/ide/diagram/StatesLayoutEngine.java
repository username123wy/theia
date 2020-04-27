package yu0323.ide.diagram;

import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.PortAlignment;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.graph.properties.IPropertyHolder;
import org.eclipse.sprotty.SGraph;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.layout.SprottyLayoutConfigurator;

@SuppressWarnings("all")
public class StatesLayoutEngine {
  public IPropertyHolder layout(final SModelRoot root) {
    IPropertyHolder _xifexpression = null;
    if ((root instanceof SGraph)) {
      IPropertyHolder _xblockexpression = null;
      {
        final SprottyLayoutConfigurator configurator = new SprottyLayoutConfigurator();
        configurator.configureByType("graph").<Direction>setProperty(CoreOptions.DIRECTION, Direction.DOWN).<Double>setProperty(CoreOptions.SPACING_NODE_NODE, Double.valueOf(30.0)).<Double>setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, Double.valueOf(30.0));
        configurator.configureByType("node").<PortAlignment>setProperty(CoreOptions.PORT_ALIGNMENT_DEFAULT, PortAlignment.CENTER).<PortConstraints>setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE);
        _xblockexpression = configurator.configureByType("port").<PortSide>setProperty(CoreOptions.PORT_SIDE, PortSide.EAST).<Double>setProperty(CoreOptions.PORT_BORDER_OFFSET, Double.valueOf(3.0));
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
