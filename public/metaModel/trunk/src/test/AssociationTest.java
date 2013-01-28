package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.Association;
import model.abstractOperation.AssociationManager;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.Predcate;
import test.util.AbstractTest;

public class AssociationTest extends AbstractTest {
	private final PersistentAssociationManager manager;

	public AssociationTest() throws CycleException, PersistenceException {
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
	}
}
