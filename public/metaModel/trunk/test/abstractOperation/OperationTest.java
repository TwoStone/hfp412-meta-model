package abstractOperation;

import static org.junit.Assert.assertEquals;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.Operation;
import model.abstractOperation.OperationManager;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentOperationManager;
import test.util.AbstractTest;

public class OperationTest extends AbstractTest {
	private PersistentOperationManager manager;

	public OperationTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Before
	public void cleanUp() throws PersistenceException {
		this.manager = OperationManager.getTheOperationManager();
	}

	@Test
	public void isStatic() throws PersistenceException, DoubleDefinitionException {
		assertEquals(mFalse, Operation.createOperation("", mat4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mptMultiple2And4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mptSingle1, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mstMultiple2And4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mstSingle1, mat1).isStatic());
		assertEquals(mTrue, Operation.createOperation("", mptEmpty, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mstEmpty, mat1).isStatic());
		// TODO CompTypes testen
	}
}
