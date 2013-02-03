package model.abstractOperation;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.Predcate;
import test.util.AbstractTest;

public class AssociationTest extends AbstractTest {
	private final PersistentAssociationManager manager;

	public AssociationTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
		this.manager = AssociationManager.getTheAssociationManager();
	}

	@Before
	public void cleanUp() throws PersistenceException {
		Iterator<PersistentAssociation> iterator = this.manager.getAssociations().iterator();
		// TODO: Wie zur Hoelle leert man hier die Liste!?
		while (iterator.hasNext()) {
			manager.getAssociations().removeFirstSuccess(new Predcate<PersistentAssociation>() {

				@Override
				public boolean test(PersistentAssociation argument) throws PersistenceException {
					return true;
				}
			});
		}
	}

	@Test
	public void isObservation() throws PersistenceException, DoubleDefinitionException {
		assertEquals(mFalse, Association.createAssociation("", mat1, mat4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mptMultiple2And4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mptSingle1).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mstMultiple2And4).isObservation());
		assertEquals(mFalse, Association.createAssociation("", mat1, mstSingle1).isObservation());
		assertEquals(mTrue, Association.createAssociation("", mat1, mptEmpty).isObservation());
		assertEquals(mTrue, Association.createAssociation("", mat1, mstEmpty).isObservation());
		// TODO CompTypes testen
	}
}
