package model.quantity;

import model.quantity.conversion.SetConversionTest;
import model.quantity.conversion.SetDefaultUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ /* AddReferenceTest.class, */ConversionTest.class, FunctionTests.class, UnitTypeManagerTest.class,
		FractionTest.class, SetConversionTest.class, SetDefaultUnitTest.class, CompUnitTypeTest.class,
		AddReferenceTest.class, CalculationTest.class, IsLessOrEqualTest.class })
public class AllTests {

}
