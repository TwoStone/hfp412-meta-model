package de.hfp412.piAutomatonCreator;

import java.util.Map;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

import processes.ProcessTermWithRestrictedNames;
import stateSpace.StateTransitionSystem;
import stateSpace.TransitionRelationInstance;
import stateSpace.exception.InfiniteStateSpaceException;
import basis.InternalException;

/**
 * Repräsentier einen Konvertierer, der aus einem {@link ProcessTermWithRestrictedNames} einen {@link DirectedGraph} erstellt.
 */
public class ProcessTerm2JGraphConverter {

	/**
	 * Erstellt aus dem übergebenen {@link ProcessTermWithRestrictedNames ProzessTerm} einen {@link DirectedGraph gerichteten Graphen}.
	 */
	public DirectedGraph<ProcessTermWithRestrictedNames, LabeledEdge> convert(ProcessTermWithRestrictedNames processTerm) {		
		try {
			DirectedGraph<ProcessTermWithRestrictedNames, LabeledEdge> graph = new DefaultDirectedGraph<>(LabeledEdge.class);
			StateTransitionSystem stateSpace = processTerm.getStateSpace();
			Map<Integer, ProcessTermWithRestrictedNames> states = stateSpace.getStates();

			for (ProcessTermWithRestrictedNames entry : states.values()) {
				graph.addVertex(entry);
			}
			
			for (TransitionRelationInstance transition : stateSpace.getTransitionRelation()) {
				LabeledEdge edge = new LabeledEdge(transition.getLabel().toString());
				graph.addEdge(states.get(transition.getSource()), states.get(transition.getTarget()), edge);
			}
			
			return graph;
			
		} catch (InfiniteStateSpaceException | InternalException e) {
			throw new RuntimeException(e);
		}
	}
}
