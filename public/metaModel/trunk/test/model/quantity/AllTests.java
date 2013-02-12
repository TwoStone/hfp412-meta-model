package model.quantity;

import model.quantity.conversion.SetConversionTest;
import model.quantity.conversion.SetDefaultUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SetConversionTest.class, SetDefaultUnitTest.class })
public class AllTests {

}
