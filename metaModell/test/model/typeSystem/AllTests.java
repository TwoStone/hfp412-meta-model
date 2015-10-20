package model.typeSystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AspectManagerTest.class, DisjunctiveNormalFormTest.class, IsAbstractTest.class, IsSingeltonTest.class,
		LessOrEqualsTest.class, TypeManagerTest.class })
public class AllTests {

}
