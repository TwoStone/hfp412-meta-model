package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.Operation;
import model.abstractOperation.OperationManager;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.Predcate;
import test.util.AbstractTest;

public class OperationTest extends AbstractTest {
	private final PersistentOperationManager manager;

	public OperationTest() throws CycleException, PersistenceException {
		super();
		this.manager = OperationManager.getTheOperationManager();
	}

	@Before
	public void cleanUp() throws PersistenceException {
		Iterator<PersistentOperation> iterator = this.manager.getOperations().iterator();
		// TODO: Wie zur Hoelle leert man hier die Liste!?
		while (iterator.hasNext()) {
			manager.getOperations().removeFirstSuccess(new Predcate<PersistentOperation>() {

				@Override
				public boolean test(PersistentOperation argument) throws PersistenceException {
					return true;
				}
			});
		}
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
