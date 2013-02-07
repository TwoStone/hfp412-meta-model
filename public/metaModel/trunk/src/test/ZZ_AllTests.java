package test;

import model.abstractOperation.AssociationManagerTest;
import model.abstractOperation.AssociationTest;
import model.messageOrLink.MessageManagerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import abstractOperation.OperationManagerTest;
import abstractOperation.OperationTest;

@RunWith(Suite.class)
@SuiteClasses({ AssociationManagerTest.class, AssociationTest.class, ConversionTest.class, FractionTests.class,
		FunctionTests.class, MessageManagerTest.class, OperationManagerTest.class, OperationTest.class,
		UnitTypeManagerTest.class })
public class ZZ_AllTests {

}
