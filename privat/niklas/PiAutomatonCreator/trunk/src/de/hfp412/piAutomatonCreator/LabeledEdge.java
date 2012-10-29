package de.hfp412.piAutomatonCreator;

import org.jgrapht.ext.EdgeNameProvider;
import org.jgrapht.graph.DefaultEdge;

public class LabeledEdge extends DefaultEdge {

	private final String label;
	
	private static final long serialVersionUID = 9174824071172677683L;
	
	public LabeledEdge(String label) {
		super();
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static class LabeledEdgeNameProvider implements EdgeNameProvider<LabeledEdge> {

		@Override
		public String getEdgeName(LabeledEdge edge) {
			return edge.getLabel();
		}
		
	}
	
}
