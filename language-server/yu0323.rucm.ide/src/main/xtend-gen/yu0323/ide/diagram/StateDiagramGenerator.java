package yu0323.ide.diagram;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.LayoutOptions;
import org.eclipse.sprotty.SEdge;
import org.eclipse.sprotty.SGraph;
import org.eclipse.sprotty.SLabel;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.SNode;
import org.eclipse.sprotty.SPort;
import org.eclipse.sprotty.xtext.IDiagramGenerator;
import org.eclipse.sprotty.xtext.SIssueMarkerDecorator;
import org.eclipse.sprotty.xtext.tracing.ITraceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import yu0323.rucm.Actor;
import yu0323.rucm.Relationship;
import yu0323.rucm.UCModel;
import yu0323.rucm.UseCase;

@SuppressWarnings("all")
public class StateDiagramGenerator implements IDiagramGenerator {
  @Inject
  @Extension
  private ITraceProvider _iTraceProvider;
  
  @Inject
  @Extension
  private SIssueMarkerDecorator _sIssueMarkerDecorator;
  
  @Override
  public SModelRoot generate(final IDiagramGenerator.Context context) {
    EObject _head = IterableExtensions.<EObject>head(context.getResource().getContents());
    return this.toSGraph(((UCModel) _head), context);
  }
  
  public SGraph toSGraph(final UCModel sm, @Extension final IDiagramGenerator.Context context) {
    final Consumer<SGraph> _function = (SGraph it) -> {
      it.setId(context.getIdCache().uniqueId(sm, sm.getName()));
      final ArrayList<SNode> children = CollectionLiterals.<SNode>newArrayList();
      if ((sm instanceof UseCase)) {
        SNode _sNode = this.toSNode(((UseCase)sm), context);
        children.add(_sNode);
      }
      if ((sm instanceof Actor)) {
        SNode _sNode_1 = this.toSNode(((Actor)sm), context);
        children.add(_sNode_1);
      }
      final Function1<Actor, SNode> _function_1 = (Actor it_1) -> {
        return this.toSNode(it_1, context);
      };
      List<SNode> _map = ListExtensions.<Actor, SNode>map(sm.getActor(), _function_1);
      final Function1<Actor, EList<Relationship>> _function_2 = (Actor it_1) -> {
        return it_1.getRelationship();
      };
      final Function1<Relationship, SEdge> _function_3 = (Relationship it_1) -> {
        return this.toSEdge(it_1, context);
      };
      Iterable<SEdge> _map_1 = IterableExtensions.<Relationship, SEdge>map(Iterables.<Relationship>concat(ListExtensions.<Actor, EList<Relationship>>map(sm.getActor(), _function_2)), _function_3);
      it.setChildren(IterableExtensions.<SModelElement>toList(Iterables.<SModelElement>concat(_map, _map_1)));
    };
    return this.<SGraph>traceAndMark(new SGraph(_function), sm, context);
  }
  
  public SNode toSNode(final UseCase state, @Extension final IDiagramGenerator.Context context) {
    SNode _xblockexpression = null;
    {
      final String theId = context.getIdCache().uniqueId(state, state.getName());
      final Consumer<SNode> _function = (SNode it) -> {
        it.setId(theId);
        final Consumer<SLabel> _function_1 = (SLabel it_1) -> {
          it_1.setId(context.getIdCache().uniqueId((theId + ".label")));
          it_1.setText(state.getName());
        };
        SLabel _trace = this._iTraceProvider.<SLabel>trace(new SLabel(_function_1), state);
        final Consumer<SPort> _function_2 = (SPort it_1) -> {
          it_1.setId(context.getIdCache().uniqueId((theId + ".newRelation")));
        };
        SPort _sPort = new SPort(_function_2);
        it.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_trace, _sPort)));
        it.setLayout("stack");
        final Consumer<LayoutOptions> _function_3 = (LayoutOptions it_1) -> {
          it_1.setPaddingTop(Double.valueOf(10.0));
          it_1.setPaddingBottom(Double.valueOf(10.0));
          it_1.setPaddingLeft(Double.valueOf(10.0));
          it_1.setPaddingRight(Double.valueOf(10.0));
        };
        LayoutOptions _layoutOptions = new LayoutOptions(_function_3);
        it.setLayoutOptions(_layoutOptions);
      };
      _xblockexpression = this.<SNode>traceAndMark(new SNode(_function), state, context);
    }
    return _xblockexpression;
  }
  
  public SNode toSNode(final Actor actor, @Extension final IDiagramGenerator.Context context) {
    SNode _xblockexpression = null;
    {
      final String theId = context.getIdCache().uniqueId(actor, actor.getName());
      final Consumer<SNode> _function = (SNode it) -> {
        it.setId(theId);
        final Consumer<SLabel> _function_1 = (SLabel it_1) -> {
          it_1.setId(context.getIdCache().uniqueId((theId + ".label")));
          it_1.setText(actor.getName());
        };
        SLabel _trace = this._iTraceProvider.<SLabel>trace(new SLabel(_function_1), actor);
        final Consumer<SPort> _function_2 = (SPort it_1) -> {
          it_1.setId(context.getIdCache().uniqueId((theId + ".newRelation")));
        };
        SPort _sPort = new SPort(_function_2);
        it.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_trace, _sPort)));
        it.setLayout("stack");
        final Consumer<LayoutOptions> _function_3 = (LayoutOptions it_1) -> {
          it_1.setPaddingTop(Double.valueOf(10.0));
          it_1.setPaddingBottom(Double.valueOf(10.0));
          it_1.setPaddingLeft(Double.valueOf(10.0));
          it_1.setPaddingRight(Double.valueOf(10.0));
        };
        LayoutOptions _layoutOptions = new LayoutOptions(_function_3);
        it.setLayoutOptions(_layoutOptions);
      };
      _xblockexpression = this.<SNode>traceAndMark(new SNode(_function), actor, context);
    }
    return _xblockexpression;
  }
  
  public SEdge toSEdge(final Relationship transition, @Extension final IDiagramGenerator.Context context) {
    final Consumer<SEdge> _function = (SEdge it) -> {
      it.setSourceId(context.getIdCache().getId(transition.eContainer()));
      it.setTargetId(context.getIdCache().getId(transition.getUsecase()));
      String _sourceId = it.getSourceId();
      String _plus = (_sourceId + ":");
      String _name = transition.getActor().getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ":");
      String _targetId = it.getTargetId();
      String _plus_3 = (_plus_2 + _targetId);
      final String theId = context.getIdCache().uniqueId(transition, _plus_3);
      it.setId(theId);
      final Consumer<SLabel> _function_1 = (SLabel it_1) -> {
        it_1.setId(context.getIdCache().uniqueId((theId + ".label")));
        it_1.setType("label:xref");
        it_1.setText(transition.getActor().getName());
      };
      SLabel _sLabel = new SLabel(_function_1);
      it.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_sLabel)));
    };
    return this.<SEdge>traceAndMark(new SEdge(_function), transition, context);
  }
  
  public <T extends SModelElement> T traceAndMark(final T sElement, final EObject element, final IDiagramGenerator.Context context) {
    return this._sIssueMarkerDecorator.<T>addIssueMarkers(this._iTraceProvider.<T>trace(sElement, element), element, context);
  }
}
