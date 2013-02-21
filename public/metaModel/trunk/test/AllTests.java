

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ model.abstractOperation.AllTests.class, model.basic.AllTests.class, model.messageOrLink.AllTests.class,
		model.quantity.AllTests.class, model.typeSystem.AllTests.class, FractionTest.class })
public class AllTests {

}
