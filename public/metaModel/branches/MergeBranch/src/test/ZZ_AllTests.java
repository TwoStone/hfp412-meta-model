package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteClasses({ 
	ContainsTypeTest.class, 
	FractionTests.class, 
	FunctionTests.class, 
	LessOrEqualThanTest.class, 
	UnitTypeManagerTest.class })
public class ZZ_AllTests {

}
