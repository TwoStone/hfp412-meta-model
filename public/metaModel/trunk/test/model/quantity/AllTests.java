package model.quantity;

import model.quantity.conversion.SetConversionTest;
import model.quantity.conversion.SetDefaultUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ /* AddReferenceTest.class, */ConversionTest.class, FunctionTests.class, QuantityTest.class,
		UnitTypeManagerTest.class, SetConversionTest.class, SetDefaultUnitTest.class, CompUnitTypeTest.class })
public class AllTests {

}
