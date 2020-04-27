package yu0323.ide.diagram

import com.google.inject.Inject
import yu0323.rucm.Actor
import yu0323.rucm.UCModel
import yu0323.rucm.UseCase

import yu0323.rucm.Relationship
import org.eclipse.emf.ecore.EObject
import org.eclipse.sprotty.LayoutOptions
import org.eclipse.sprotty.SEdge
import org.eclipse.sprotty.SGraph
import org.eclipse.sprotty.SLabel
import org.eclipse.sprotty.SModelElement
import org.eclipse.sprotty.SNode
import org.eclipse.sprotty.SPort
import org.eclipse.sprotty.xtext.IDiagramGenerator
import org.eclipse.sprotty.xtext.SIssueMarkerDecorator
import org.eclipse.sprotty.xtext.tracing.ITraceProvider

class StateDiagramGenerator implements IDiagramGenerator{
	@Inject extension ITraceProvider
	@Inject extension SIssueMarkerDecorator
	override generate(Context context) {
		(context.resource.contents.head as UCModel).toSGraph(context)
	}
	
	def toSGraph(UCModel sm, extension Context context) {
		(new SGraph [
			id = idCache.uniqueId(sm, sm.name)
			val children = newArrayList
				 if (sm instanceof UseCase)
				    children += sm.toSNode(context)
				 if (sm instanceof Actor)
				    children += sm.toSNode(context)
				 //if (sm instanceof Relationship)	  
				  //  children += sm.toSEdge(context)
			children = (sm.actor.map[toSNode(context)] 
					  + sm.actor.map[relationship].flatten.map[toSEdge(context)]
			).toList 
		]).traceAndMark(sm, context)
	}
	
	def SNode toSNode(UseCase state, extension Context context) {
		val theId = idCache.uniqueId(state, state.name) 
		(new SNode [
			id = theId
			children =  #[
				(new SLabel [
					id = idCache.uniqueId(theId + '.label')
					text = state.name 
				]).trace(state),
				new SPort [
					id = idCache.uniqueId(theId + '.newRelation')
				]				
			]
			layout = 'stack'
			layoutOptions = new LayoutOptions [
				paddingTop = 10.0
				paddingBottom = 10.0
				paddingLeft = 10.0
				paddingRight = 10.0
				
			]
		]).traceAndMark(state, context)
	}
	
	def SNode toSNode(Actor actor, extension Context context) {
		val theId = idCache.uniqueId(actor, actor.name) 
		(new SNode [
			id = theId
			children =  #[
				(new SLabel [
					id = idCache.uniqueId(theId + '.label')
					text = actor.name 
				]).trace(actor),
				new SPort [
					id = idCache.uniqueId(theId + '.newRelation')
				]				
			]
			layout = 'stack'
			layoutOptions = new LayoutOptions [
				paddingTop = 10.0
				paddingBottom = 10.0
				paddingLeft = 10.0
				paddingRight = 10.0
				
			]
		]).traceAndMark(actor, context)
	}
	
	def SEdge toSEdge(Relationship transition, extension Context context) {
		(new SEdge [
			sourceId = idCache.getId(transition.eContainer) 
			targetId = idCache.getId(transition.usecase)
			val theId = idCache.uniqueId(transition, sourceId + ':' + transition.actor.name + ':' + targetId)
			id = theId 
			children = #[
				(new SLabel [
					id = idCache.uniqueId(theId + '.label')
					type = 'label:xref'
					text = transition.actor.name
				])                             //trace(transition, StatesPackage.Literals.TRANSITION__EVENT, -1)
			]
		]).traceAndMark(transition, context)
	}
	
	def <T extends SModelElement> T traceAndMark(T sElement, EObject element, Context context) {
		sElement.trace(element).addIssueMarkers(element, context) 
	}
	
}