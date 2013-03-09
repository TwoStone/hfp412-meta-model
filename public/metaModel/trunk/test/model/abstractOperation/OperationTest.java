package model.abstractOperation;

import static org.junit.Assert.assertEquals;
import model.ConsistencyException;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.FormalParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentOperationManager;
import util.AbstractTest;
import util.InjectSingleton;

public class OperationTest extends AbstractTest {

	@InjectSingleton(OperationManager.class)
	private PersistentOperationManager manager;

	@Test
	public void isStatic() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		assertEquals(mFalse, manager.createOperation(mat4, mat1, "a", new FormalParameterSearchList()).isStatic());
		assertEquals(mFalse, manager.createOperation(mptMultiple2And4, mat1, "b", new FormalParameterSearchList())
				.isStatic());
		assertEquals(mFalse, manager.createOperation(mptSingle1, mat1, "c", new FormalParameterSearchList()).isStatic());
		assertEquals(mFalse, manager.createOperation(mstMultiple2And4, mat1, "d", new FormalParameterSearchList())
				.isStatic());
		assertEquals(mFalse, manager.createOperation(mstSingle1, mat1, "e", new FormalParameterSearchList()).isStatic());
		assertEquals(mFalse, manager.createOperation(mptEmpty, mat1, "f", new FormalParameterSearchList()).isStatic());
		assertEquals(mTrue, manager.createOperation(mstEmpty, mat1, "g", new FormalParameterSearchList()).isStatic());
	}

	@Test
	public void isConstant() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		assertEquals(mFalse, manager.createOperation(mat4, mat1, "a", new FormalParameterSearchList()).isConstant());
		assertEquals(mFalse, manager.createOperation(mptMultiple2And4, mat1, "b", new FormalParameterSearchList())
				.isConstant());
		assertEquals(mFalse, manager.createOperation(mptSingle1, mat1, "c", new FormalParameterSearchList())
				.isConstant());
		assertEquals(mFalse, manager.createOperation(mstMultiple2And4, mat1, "d", new FormalParameterSearchList())
				.isConstant());
		assertEquals(mFalse, manager.createOperation(mstSingle1, mat1, "e", new FormalParameterSearchList())
				.isConstant());
		assertEquals(mFalse, manager.createOperation(mptEmpty, mat1, "f", new FormalParameterSearchList()).isConstant());
		assertEquals(mTrue, manager.createOperation(mstEmpty, mat1, "g", new FormalParameterSearchList()).isConstant());
		final FormalParameterSearchList fpList = new FormalParameterSearchList();
		fpList.add(manager.createFp("a", mat2));
		assertEquals(mFalse, manager.createOperation(mstEmpty, mat1, "h", fpList).isConstant());
	}
}
