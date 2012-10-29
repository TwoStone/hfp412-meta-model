package de.hfp412.piAutomatonCreator;

import java.nio.file.Path;

import parser.ProcessParser;
import parser.exception.SyntaxErrorException;
import processes.ProcessTermWithRestrictedNames;
import scanner.Scanner;
import scanner.ScannerResult;
import scanner.exception.ScannerException;
import textualInput.ProcessExpression;

import com.thoughtworks.xstream.XStream;

/**
 * Bietet Schnittstellen zum Picard Werkzeug an.
 */
public class PicardInterface {

	/**
	 * L�dt den {@link ProcessExpression Prozessausdruck} aus der �bergeben {@link Path Konfigurationsdatei}.
	 */
	public static ProcessExpression loadExpressionFromFile(Path path) {
		XStream xStream = new XStream();
		ProcessExpression expression = (ProcessExpression) xStream.fromXML(path.toFile());
		
		return expression;
	}

	/**
	 * Parst den �bergeben {@link ProcessExpression Prozessausdruck} in einen {@link ProcessTermWithRestrictedNames ProzessTerm}.
	 */
	public static ProcessTermWithRestrictedNames parseProcess(ProcessExpression expression) throws ScannerException, SyntaxErrorException {
		
		Scanner scanner = new Scanner();
		ScannerResult scannerResult = scanner.scanProcessExpression(expression);
		
		ProcessParser parser = new ProcessParser();
		ProcessTermWithRestrictedNames parseProcess = parser.parseProcess(scannerResult);
		
		return parseProcess;
	}
}
