package model.abstractOperation;

import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.messageOrLink.LinkManager;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLinkManager;
import util.AbstractTest;
import util.InjectSingleton;

public class AssociationManagerTest extends AbstractTest {

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager manager;

	@InjectSingleton(LinkManager.class)
	private PersistentLinkManager linkManager;

	public AssociationManagerTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test
	public void createAssociationSuccessful() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		manager.createAssociation(mat4, mat5, "a");
		manager.createAssociation(mat4, mat5, "b");
		manager.createAssociation(mat2, mat3, "c");
		manager.createAssociation(mat2, mat1, "d");
		manager.createAssociation(mat2, mat3, "e");

		manager.createAssociation(mat2, mat4, "f");
		manager.createAssociation(mptSingle2, mat5, "g");
		manager.createAssociation(mptMultiple2And4, mat5, "h");
		manager.createAssociation(mstSingle2, mat5, "i");
		manager.createAssociation(mstMultiple2And4, mat5, "j");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat2, mat1, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE02() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat3, mat2, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE03() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat1, mat3, "a");
		manager.createAssociation(mat3, mat1, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE04() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat3, "a");
		manager.createAssociation(mat2, mat3, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE05() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat4, "a");
		manager.createAssociation(mptSingle2, mat4, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE06() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat5, "a");
		manager.createAssociation(mptMultiple2And4, mat5, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE07() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat4, "a");
		manager.createAssociation(mstSingle2, mat4, "a");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createAssoicationDDE08() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat2, mat5, "a");
		manager.createAssociation(mstMultiple2And4, mat5, "a");
	}

	@Test(expected = ConsistencyException.class)
	public void createAssoicationCE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mptEmpty, mat1, "a");
	}

	@Test(expected = ConsistencyException.class)
	public void createAssoicationCE02() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat1, mptEmpty, "a");
	}

	@Test(expected = ConsistencyException.class)
	public void createAssoicationCE03() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mstEmpty, mat1, "a");
	}

	@Test(expected = ConsistencyException.class)
	public void createAssoicationCE04() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		manager.createAssociation(mat1, mstEmpty, "a");
	}

	@Test
	public void addAssoicationWithoutCycleE01() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation firstAsso = Association.createAssociation("a", mat1, mat3);
		final PersistentAssociation secondAsso = Association.createAssociation("b", mat3, mat1);

		manager.getAssociations().add(firstAsso);
		manager.getAssociations().add(secondAsso);

		linkManager.createLink(firstAsso, mao1, mao3);
		linkManager.createLink(firstAsso, mao3, mao1);
	}

	@Test(expected = CycleException.class)
	public void addAssoicationCycleE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {

		final PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("firstHierarchy");
		manager.getHierarchies().add(createHierarchy);

		final PersistentAssociation firstAsso = Association.createAssociation("a", mat1, mat3);
		final PersistentAssociation secondAsso = Association.createAssociation("b", mat3, mat1);

		manager.getAssociations().add(firstAsso);
		manager.getAssociations().add(secondAsso);

		linkManager.createLink(firstAsso, mao1, mao3);
		linkManager.createLink(firstAsso, mao3, mao1);

		manager.addAssociation(createHierarchy, firstAsso);
		manager.addAssociation(createHierarchy, secondAsso);
		fail("Zyklus konnte erstellt werden");
	}
}
