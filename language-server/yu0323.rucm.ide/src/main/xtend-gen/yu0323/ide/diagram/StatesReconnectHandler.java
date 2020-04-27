package yu0323.ide.diagram;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.sprotty.SEdge;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.SModelIndex;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.xtext.ILanguageAwareDiagramServer;
import org.eclipse.sprotty.xtext.ReconnectAction;
import org.eclipse.sprotty.xtext.WorkspaceEditAction;
import org.eclipse.sprotty.xtext.tracing.PositionConverter;
import org.eclipse.sprotty.xtext.tracing.XtextTrace;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import yu0323.rucm.Actor;
import yu0323.rucm.UCModel;
import yu0323.rucm.UseCase;

@SuppressWarnings("all")
public class StatesReconnectHandler {
  @Inject
  private UriExtensions uriExtensions;
  
  @Inject
  @Extension
  private PositionConverter _positionConverter;
  
  public CompletableFuture<Object> handle(final ReconnectAction action, final ILanguageAwareDiagramServer server) {
    CompletableFuture<Object> _xblockexpression = null;
    {
      final SModelRoot root = server.getDiagramState().getCurrentModel();
      @Extension
      final SModelIndex index = new SModelIndex(root);
      String _routableId = action.getRoutableId();
      SModelElement _get = null;
      if (_routableId!=null) {
        _get=index.get(_routableId);
      }
      final SModelElement routable = _get;
      String _newSourceId = action.getNewSourceId();
      SModelElement _get_1 = null;
      if (_newSourceId!=null) {
        _get_1=index.get(_newSourceId);
      }
      final SModelElement source = _get_1;
      String _newTargetId = action.getNewTargetId();
      SModelElement _get_2 = null;
      if (_newTargetId!=null) {
        _get_2=index.get(_newTargetId);
      }
      final SModelElement target = _get_2;
      final Function<ILanguageServerAccess.Context, Object> _function = (ILanguageServerAccess.Context context) -> {
        EObject _resolveElement = null;
        if (source!=null) {
          _resolveElement=this.resolveElement(source, context);
        }
        final EObject sourceElement = _resolveElement;
        EObject _resolveElement_1 = null;
        if (target!=null) {
          _resolveElement_1=this.resolveElement(target, context);
        }
        final EObject targetElement = _resolveElement_1;
        if (((sourceElement instanceof UseCase) && (targetElement instanceof Actor))) {
          final ArrayList<TextEdit> textEdits = CollectionLiterals.<TextEdit>newArrayList();
          String _elvis = null;
          UCModel _containerOfType = EcoreUtil2.<UCModel>getContainerOfType(sourceElement, UCModel.class);
          EList<Actor> _actor = null;
          if (_containerOfType!=null) {
            _actor=_containerOfType.getActor();
          }
          Actor _head = null;
          if (_actor!=null) {
            _head=IterableExtensions.<Actor>head(_actor);
          }
          String _name = null;
          if (_head!=null) {
            _name=_head.getName();
          }
          if (_name != null) {
            _elvis = _name;
          } else {
            _elvis = "undefined";
          }
          final String usecasetName = _elvis;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("«\'\\n\\t\'»«usecaseName» => «(targetElement as UseCase).name»");
          final String transitionText = _builder.toString();
          final Range oldRange = this.getOldRange(routable);
          final Range newRange = this.getNewRange(((UseCase) sourceElement));
          if ((oldRange != null)) {
            String _sourceId = ((SEdge) routable).getSourceId();
            String _newSourceId_1 = action.getNewSourceId();
            boolean _tripleNotEquals = (_sourceId != _newSourceId_1);
            if (_tripleNotEquals) {
              TextEdit _textEdit = new TextEdit(oldRange, "");
              textEdits.add(_textEdit);
              TextEdit _textEdit_1 = new TextEdit(newRange, transitionText);
              textEdits.add(_textEdit_1);
            } else {
              TextEdit _textEdit_2 = new TextEdit(oldRange, transitionText);
              textEdits.add(_textEdit_2);
            }
          } else {
            TextEdit _textEdit_3 = new TextEdit(newRange, transitionText);
            textEdits.add(_textEdit_3);
          }
          WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
          final Procedure1<WorkspaceEdit> _function_1 = (WorkspaceEdit it) -> {
            String _sourceUri = server.getSourceUri();
            Pair<String, ArrayList<TextEdit>> _mappedTo = Pair.<String, ArrayList<TextEdit>>of(_sourceUri, textEdits);
            it.setChanges(Collections.<String, List<TextEdit>>unmodifiableMap(CollectionLiterals.<String, List<TextEdit>>newHashMap(_mappedTo)));
          };
          final WorkspaceEdit workspaceEdit = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_1);
          WorkspaceEditAction _workspaceEditAction = new WorkspaceEditAction();
          final Procedure1<WorkspaceEditAction> _function_2 = (WorkspaceEditAction it) -> {
            it.setWorkspaceEdit(workspaceEdit);
          };
          WorkspaceEditAction _doubleArrow = ObjectExtensions.<WorkspaceEditAction>operator_doubleArrow(_workspaceEditAction, _function_2);
          server.dispatch(_doubleArrow);
        }
        return null;
      };
      _xblockexpression = server.getDiagramLanguageServer().getLanguageServerAccess().<Object>doRead(server.getSourceUri(), _function);
    }
    return _xblockexpression;
  }
  
  private Range getOldRange(final SModelElement routable) {
    Range _xifexpression = null;
    String _trace = null;
    if (routable!=null) {
      _trace=routable.getTrace();
    }
    boolean _tripleNotEquals = (_trace != null);
    if (_tripleNotEquals) {
      String _trace_1 = routable.getTrace();
      _xifexpression = new XtextTrace(_trace_1).getRange();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  private Range getNewRange(final UseCase sourceElement) {
    final Position position = this._positionConverter.toPosition(NodeModelUtils.findActualNodeFor(sourceElement).getEndOffset(), sourceElement);
    return new Range(position, position);
  }
  
  private EObject resolveElement(final SModelElement sElement, final ILanguageServerAccess.Context context) {
    String _trace = sElement.getTrace();
    boolean _tripleNotEquals = (_trace != null);
    if (_tripleNotEquals) {
      final URI connectableURI = this.toURI(sElement.getTrace());
      return context.getResource().getResourceSet().getEObject(connectableURI, true);
    } else {
      return null;
    }
  }
  
  private URI toURI(final String path) {
    final String[] parts = path.split("#");
    int _size = ((List<String>)Conversions.doWrapArray(parts)).size();
    boolean _tripleNotEquals = (_size != 2);
    if (_tripleNotEquals) {
      throw new IllegalArgumentException(("Invalid trace URI " + path));
    }
    return this.uriExtensions.toUri(IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(parts)))).appendFragment(IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(parts))));
  }
}
