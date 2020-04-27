package yu0323.ide.server.codeActions;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionContext;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import yu0323.rucm.UCModel;

@SuppressWarnings("all")
public class StatesCodeActionService implements ICodeActionService {
  private static final String CREATE_ACTOR_KIND = "sprotty.create.actor";
  
  private static final String CREATE_USECASE_KIND = "sprotty.create.usecase";
  
  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final Document document, final XtextResource resource, final CodeActionParams params, final CancelIndicator indicator) {
    List<Either<Command, CodeAction>> _xblockexpression = null;
    {
      EObject root = IterableExtensions.<EObject>head(resource.getContents());
      List<Either<Command, CodeAction>> _xifexpression = null;
      if ((root instanceof UCModel)) {
        _xifexpression = this.createCodeActions(root, params, document);
      } else {
        _xifexpression = CollectionLiterals.<Either<Command, CodeAction>>emptyList();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private List<Either<Command, CodeAction>> _createCodeActions(final UCModel ucmodel, final CodeActionParams params, final Document document) {
    final ArrayList<Either<Command, CodeAction>> result = CollectionLiterals.<Either<Command, CodeAction>>newArrayList();
    boolean _matchesContext = this.matchesContext(StatesCodeActionService.CREATE_ACTOR_KIND, params);
    if (_matchesContext) {
      CodeAction _codeAction = new CodeAction();
      final Procedure1<CodeAction> _function = (CodeAction it) -> {
        it.setKind(StatesCodeActionService.CREATE_ACTOR_KIND);
        it.setTitle("new Actor");
        URI _uRI = ucmodel.eResource().getURI();
        Position _position = document.getPosition(document.getContents().length());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("«\'\\n\'»state «getNewName(\'actor\', ucmodel.actor.map[name])»");
        it.setEdit(this.createInsertWorkspaceEdit(_uRI, _position, _builder.toString()));
      };
      CodeAction _doubleArrow = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction, _function);
      result.add(Either.<Command, CodeAction>forRight(_doubleArrow));
    }
    boolean _matchesContext_1 = this.matchesContext(StatesCodeActionService.CREATE_USECASE_KIND, params);
    if (_matchesContext_1) {
      CodeAction _codeAction_1 = new CodeAction();
      final Procedure1<CodeAction> _function_1 = (CodeAction it) -> {
        it.setKind(StatesCodeActionService.CREATE_USECASE_KIND);
        it.setTitle("new UseCase");
        URI _uRI = ucmodel.eResource().getURI();
        Position _position = document.getPosition(document.getContents().length());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("«\'\\n\'»event «getNewName(\'usecase\', ucmodel.usecase.map[name])»");
        it.setEdit(this.createInsertWorkspaceEdit(_uRI, _position, _builder.toString()));
      };
      CodeAction _doubleArrow_1 = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction_1, _function_1);
      result.add(Either.<Command, CodeAction>forRight(_doubleArrow_1));
    }
    return result;
  }
  
  private boolean matchesContext(final String kind, final CodeActionParams params) {
    CodeActionContext _context = params.getContext();
    List<String> _only = null;
    if (_context!=null) {
      _only=_context.getOnly();
    }
    boolean _tripleEquals = (_only == null);
    if (_tripleEquals) {
      return true;
    } else {
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf(kind.startsWith(it));
      };
      return IterableExtensions.<String>exists(params.getContext().getOnly(), _function);
    }
  }
  
  private String getNewName(final String prefix, final List<? extends String> siblings) {
    for (int i = 0;; i++) {
      {
        final String currentName = (prefix + Integer.valueOf(i));
        final Function1<String, Boolean> _function = (String it) -> {
          return Boolean.valueOf(Objects.equal(it, currentName));
        };
        boolean _exists = IterableExtensions.exists(siblings, _function);
        boolean _not = (!_exists);
        if (_not) {
          return currentName;
        }
      }
    }
  }
  
  private List<Either<Command, CodeAction>> _createCodeActions(final EObject element, final CodeActionParams params, final Document document) {
    return CollectionLiterals.<Either<Command, CodeAction>>emptyList();
  }
  
  private WorkspaceEdit createInsertWorkspaceEdit(final URI uri, final Position position, final String text) {
    WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
    final Procedure1<WorkspaceEdit> _function = (WorkspaceEdit it) -> {
      String _string = uri.toString();
      Range _range = new Range(position, position);
      TextEdit _textEdit = new TextEdit(_range, text);
      Pair<String, List<TextEdit>> _mappedTo = Pair.<String, List<TextEdit>>of(_string, Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_textEdit)));
      it.setChanges(Collections.<String, List<TextEdit>>unmodifiableMap(CollectionLiterals.<String, List<TextEdit>>newHashMap(_mappedTo)));
    };
    return ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function);
  }
  
  private List<Either<Command, CodeAction>> createCodeActions(final EObject ucmodel, final CodeActionParams params, final Document document) {
    if (ucmodel instanceof UCModel) {
      return _createCodeActions((UCModel)ucmodel, params, document);
    } else if (ucmodel != null) {
      return _createCodeActions(ucmodel, params, document);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ucmodel, params, document).toString());
    }
  }
}
