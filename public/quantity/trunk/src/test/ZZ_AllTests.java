package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ZZ_AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Testsuite f�r das Quantity-Projekt");
		
		suite.addTestSuite(FractionTests.class);
		suite.addTestSuite(FunctionTests.class);
		suite.addTestSuite(UnitTypeManagerTest.class);
		
		return suite;
	}

}





