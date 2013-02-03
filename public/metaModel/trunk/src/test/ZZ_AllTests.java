package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssociationManagerTest.class, AssociationTest.class, ConversionTest.class, FractionTests.class,
		FunctionTests.class, MBooleanTest.class, MessageManagerTest.class, OperationManagerTest.class,
		OperationTest.class, UnitTypeManagerTest.class })
public class ZZ_AllTests {

}
