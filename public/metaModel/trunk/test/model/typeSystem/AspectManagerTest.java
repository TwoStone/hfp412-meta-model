package model.typeSystem;

import model.ConsistencyException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import util.TestingBase;

public class AspectManagerTest extends TestingBase {

	private PersistentAspectManager aspectMan;

	@Before
	public void inits() throws PersistenceException {
		aspectMan = getManager(AspectManager.class);
	}

	@Test
	public void createAspect_test01() throws ConsistencyException, PersistenceException {
		aspectMan.createAspect("AspektABC");
	}

	@Test(expected = ConsistencyException.class)
	public void createAspect_test02() throws ConsistencyException, PersistenceException {
		aspectMan.createAspect("AspektABC");
		aspectMan.createAspect("AspektABC");
	}

}
