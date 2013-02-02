package model.typeSystem;

import model.ConsistencyException;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import util.TestingBase;

public class AspectManagerTest extends TestingBase {

	private static PersistentAspectManager aspectMan;

	@BeforeClass
	public static void inits() throws PersistenceException {
		aspectMan = AspectManager.getTheAspectManager();
	}

	@Test
	public void createAspect_test01() throws ConsistencyException, PersistenceException {
		aspectMan.createAspect("AspektABC");
	}

	@Test(expected = ConsistencyException.class)
	public void createAspect_test02() throws ConsistencyException, PersistenceException {
		aspectMan.createAspect("AspektABC");
	}

	@After
	public void tearDown() {
		AspectManager.reset$For$Test = true;
	}
}
