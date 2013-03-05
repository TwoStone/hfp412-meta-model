package model.abstractOperation;

import static org.junit.Assert.assertEquals;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociationManager;
import util.AbstractTest;
import util.InjectSingleton;

public class AssociationTest extends AbstractTest {

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager manager;

	@Test
	public void isObservation() throws PersistenceException, DoubleDefinitionException {
		assertEquals(mFalse, Association.createAssociation("", mat1, mat4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mptMultiple2And4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mptSingle1).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mstMultiple2And4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mstSingle1).isObservation());
		assertEquals(mTrue, Association.createAssociation("", mat1, mptEmpty).isObservation());
		assertEquals(mTrue, Association.createAssociation("", mat1, mstEmpty).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mstMixed2And4Or5And6).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mptMixed2Or4And5Or6).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mstMixed2And4Or5And6, mstEmpty).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mptMixed2Or4And5Or6, mstEmpty).isObservation());
	}
}
