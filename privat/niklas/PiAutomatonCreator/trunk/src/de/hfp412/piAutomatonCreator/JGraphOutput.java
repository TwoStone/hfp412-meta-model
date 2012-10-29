package de.hfp412.piAutomatonCreator;

import java.io.StringWriter;

import javax.xml.transform.TransformerConfigurationException;

import org.jgrapht.Graph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.EdgeNameProvider;
import org.jgrapht.ext.GraphMLExporter;
import org.jgrapht.ext.IntegerEdgeNameProvider;
import org.jgrapht.ext.IntegerNameProvider;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultEdge;
import org.xml.sax.SAXException;

public class JGraphOutput<V, E extends DefaultEdge> {
	
	private final Graph<V, E> graph;
	private VertexNameProvider<V> vertexLabelProvider;
	private EdgeNameProvider<E> edgeLabelProvider;

	public JGraphOutput(final Graph<V, E> graph, final VertexNameProvider<V> vertexLabelProvider, final EdgeNameProvider<E> edgeLabelProvider) {
		super();
		this.graph = graph;
		this.vertexLabelProvider = vertexLabelProvider;
		this.edgeLabelProvider = edgeLabelProvider;
	}
	
	/**
	 * Liefert die GraphML Repräsentiation des Graphen zurück.
	 */
	public String asGraphML() {		
		try {
			
			GraphMLExporter<V, E> exporter = new GraphMLExporter<>(
					new IntegerNameProvider<V>(), 
					vertexLabelProvider, 
					new IntegerEdgeNameProvider<E>(), 
					edgeLabelProvider);
			
			StringWriter stringWriter = new StringWriter();
			exporter.export(stringWriter, this.graph);

			stringWriter.flush();
			return stringWriter.toString();
		} catch (TransformerConfigurationException | SAXException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Liefert den Graphen als DOT Repräsentation.
	 */
	public String asDOT() {
		
		DOTExporter<V, E> exporter = new DOTExporter<>(
				new IntegerNameProvider<V>(), 
				vertexLabelProvider, 
				edgeLabelProvider);
		
		StringWriter stringWriter = new StringWriter();
		exporter.export(stringWriter, this.graph);

		stringWriter.flush();
		
		return stringWriter.toString();
	}
	
}
