package de.hfp412.piAutomatonCreator;

import java.io.File;
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
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.xml.sax.SAXException;

import parser.exception.SyntaxErrorException;
import processes.ProcessTermWithRestrictedNames;
import scanner.exception.ScannerException;
import stateSpace.exception.InfiniteStateSpaceException;
import textualInput.ProcessExpression;
import basis.InternalException;

import com.google.common.base.Charsets;

public class Main {
	
	@Argument(required = true, usage ="Ein .prm Datei aus der der Prozessausdruck verwendet wird.")
	private File inputFile;
	
	@Option(name="-o", usage="Pfad der Ausgabedatei")
	private File outputFile;

	/**
s	 */
	public static void main(String[] args) throws ScannerException, SyntaxErrorException, InfiniteStateSpaceException, InternalException, IOException, URISyntaxException, TransformerConfigurationException, SAXException, CmdLineException {
		new Main().doMain(args);
	}

	private void doMain(String[] args) throws ScannerException,
			SyntaxErrorException, IOException, CmdLineException {
		
		CmdLineParser cmdLineParser = new CmdLineParser(this);
		cmdLineParser.parseArgument(args);
		
		final ProcessExpression expression; 
		
		if (inputFile != null) {
			System.out.println("Loading file "+ inputFile.getName());
			expression = PicardInterface.loadExpressionFromFile(inputFile.toPath());
		} else {
			cmdLineParser.printUsage(System.out);
			return;
		}
		ProcessTermWithRestrictedNames p1 = PicardInterface.parseProcess(expression);
		
		ProcessTerm2JGraphConverter converter = new ProcessTerm2JGraphConverter();
		Graph<ProcessTermWithRestrictedNames, LabeledEdge> graph = converter.convert(p1);
		
		JGraphOutput<ProcessTermWithRestrictedNames, LabeledEdge> output = 
				new JGraphOutput<>(graph, new StringNameProvider<ProcessTermWithRestrictedNames>(), new LabeledEdge.LabeledEdgeNameProvider());
		
		System.out.println(output.asDOT());
				
		if (outputFile != null) {
			Path outputFile = Paths.get(args[1]);		
			Files.write(outputFile, Collections.singletonList(output.asDOT()), Charsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}
	}
}
