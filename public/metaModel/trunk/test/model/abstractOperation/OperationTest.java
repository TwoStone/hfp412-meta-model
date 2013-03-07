package model.abstractOperation;

import static org.junit.Assert.assertEquals;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentOperationManager;
import util.AbstractTest;
import util.InjectSingleton;

public class OperationTest extends AbstractTest {

	@InjectSingleton(OperationManager.class)
	private PersistentOperationManager manager;

	@Test
	public void isStatic() throws PersistenceException, DoubleDefinitionException {
		assertEquals(mFalse, Operation.createOperation("", mat4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mptMultiple2And4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mptSingle1, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mstMultiple2And4, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mstSingle1, mat1).isStatic());
		assertEquals(mFalse, Operation.createOperation("", mptEmpty, mat1).isStatic());
		assertEquals(mTrue, Operation.createOperation("", mstEmpty, mat1).isStatic());
		// TODO: Christin CompTypes testen
	}
}
