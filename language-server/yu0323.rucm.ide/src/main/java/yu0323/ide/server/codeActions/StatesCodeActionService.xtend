package yu0323.ide.server.codeActions

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import yu0323.rucm.UCModel

class StatesCodeActionService implements ICodeActionService {
	
	static val CREATE_ACTOR_KIND = 'sprotty.create.actor'
	static val CREATE_USECASE_KIND = 'sprotty.create.usecase'
	
	override getCodeActions(Document document, XtextResource resource, CodeActionParams params, CancelIndicator indicator) {
		var root = resource.contents.head
		if (root instanceof UCModel)
			createCodeActions(root, params, document)
		 else
		 	emptyList
	}
	
	private def dispatch List<Either<Command, CodeAction>> createCodeActions(UCModel ucmodel, CodeActionParams params, Document document) {
		val result = <Either<Command, CodeAction>>newArrayList
		if (CREATE_ACTOR_KIND.matchesContext(params)) {
			result.add(Either.forRight(new CodeAction => [
				kind = CREATE_ACTOR_KIND
				title = 'new Actor' 
				edit = createInsertWorkspaceEdit(
					ucmodel.eResource.URI, 
					document.getPosition(document.contents.length), 
					'''«'\n'»state «getNewName('actor', ucmodel.actor.map[name])»'''
				)
			]));
		}
		if (CREATE_USECASE_KIND.matchesContext(params)) {
			result.add(Either.forRight(new CodeAction => [
				kind = CREATE_USECASE_KIND
				title = 'new UseCase' 
				edit = createInsertWorkspaceEdit(
					ucmodel.eResource.URI, 
					document.getPosition(document.contents.length), 
					'''«'\n'»event «getNewName('usecase', ucmodel.usecase.map[name])»'''
				)
			]));
		}
		return result			
	}
	
	private def matchesContext(String kind, CodeActionParams params) {
		if (params.context?.only === null)
			return true
		else 
			return params.context.only.exists[kind.startsWith(it)]
	}
	
	private def String getNewName(String prefix, List<? extends String> siblings) {
		for(var i = 0;; i++) {
			val currentName = prefix + i
			if (!siblings.exists[it == currentName])
				return currentName
		}
	}
		
	private def dispatch List<Either<Command, CodeAction>> createCodeActions(EObject element, CodeActionParams params, Document document) {
		return emptyList 
	}
	
	private def createInsertWorkspaceEdit(URI uri, Position position, String text) {
		new WorkspaceEdit => [
			changes = #{uri.toString -> #[ new TextEdit(new Range(position, position), text) ]}
		]
	}	
}