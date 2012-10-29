package de.hfp412.piAutomatonCreator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

import javax.xml.transform.TransformerConfigurationException;

import org.jgrapht.Graph;
import org.jgrapht.ext.StringNameProvider;
import org.xml.sax.SAXException;

import parser.exception.SyntaxErrorException;
import processes.ProcessTermWithRestrictedNames;
import scanner.exception.ScannerException;
import stateSpace.exception.InfiniteStateSpaceException;
import textualInput.ProcessExpression;
import basis.InternalException;

import com.google.common.base.Charsets;

public class Main {

	/**
	 */
	public static void main(String[] args) throws ScannerException, SyntaxErrorException, InfiniteStateSpaceException, InternalException, IOException, URISyntaxException, TransformerConfigurationException, SAXException {
		final ProcessExpression expression; 
		
		String inputFileName;
		if (args.length >= 1) {
			inputFileName = args[0];
			System.out.println("Loading file "+ inputFileName);
			expression = PicardInterface.loadExpressionFromFile(Paths.get(inputFileName));
		} else {
			System.err.println("No file argument passed");
			return;
		}
		ProcessTermWithRestrictedNames p1 = PicardInterface.parseProcess(expression);
		
		ProcessTerm2JGraphConverter converter = new ProcessTerm2JGraphConverter();
		Graph<ProcessTermWithRestrictedNames, LabeledEdge> graph = converter.convert(p1);
		
		JGraphOutput<ProcessTermWithRestrictedNames, LabeledEdge> output = 
				new JGraphOutput<>(graph, new StringNameProvider<ProcessTermWithRestrictedNames>(), new LabeledEdge.LabeledEdgeNameProvider());
		
		System.out.println(output.asDOT());
				
		if (args.length >= 2) {
			Path outputFile = Paths.get(args[1]);		
			Files.write(outputFile, Collections.singletonList(output.asDOT()), Charsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}
				
	}
}
