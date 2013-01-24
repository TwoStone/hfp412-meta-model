package test;

import java.util.Iterator;

import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.AssociationManager;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.Predcate;
import test.util.AbstractTest;

public class AssociationManagerTest extends AbstractTest {

	private final PersistentAssociationManager manager;

	public AssociationManagerTest() throws CycleException, PersistenceException {
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
	public void createAssociationSuccessful() throws PersistenceException, DoubleDefinitionException {
		manager.createAssociation(mat4, mat5, "a");
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat2, mat1, "b");
		manager.createAssociation(mat2, mat3, "c");

	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE01() throws PersistenceException, DoubleDefinitionException {
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat2, mat1, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE02() throws PersistenceException, DoubleDefinitionException {
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat3, mat2, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE03() throws PersistenceException, DoubleDefinitionException {
		manager.createAssociation(mat1, mat3, "a");
		manager.createAssociation(mat3, mat1, "a");
	}

}
