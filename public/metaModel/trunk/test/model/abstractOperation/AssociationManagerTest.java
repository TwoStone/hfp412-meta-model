package model.abstractOperation;

import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.NotAvailableException;
import model.messageOrLink.LinkManager;
import model.typeSystem.ObjectManager;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLinkManager;
import persistence.PersistentObjectManager;
import util.AbstractTest;
import util.InjectSingleton;

public class AssociationManagerTest extends AbstractTest {

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager manager;

	@InjectSingleton(LinkManager.class)
	private PersistentLinkManager linkManager;

	@InjectSingleton(ObjectManager.class)
	private PersistentObjectManager objectMan;

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

		manager.createAssociation(mstMixed2And4Or5And6, mat5, "k");
		manager.createAssociation(mptMixed2Or4And5Or6, mat5, "l");
		manager.createAssociation(mat5, mstMixed2And4Or5And6, "m");
		manager.createAssociation(mat5, mptMixed2Or4And5Or6, "n");
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
	public void removeAssociationSuccessful() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat5);
		final PersistentAssociation b = Association.createAssociation("b", mptSingle2, mat5);
		final PersistentAssociation c = Association.createAssociation("c", mptMultiple2And4, mat5);
		final PersistentAssociation d = Association.createAssociation("d", mstSingle2, mat5);
		final PersistentAssociation e = Association.createAssociation("e", mstMultiple2And4, mat5);
		final PersistentAssociation f = Association.createAssociation("f", mstMixed2And4Or5And6, mat5);
		final PersistentAssociation g = Association.createAssociation("g", mptMixed2Or4And5Or6, mat5);
		manager.getAssociations().add(a);
		manager.getAssociations().add(b);
		manager.getAssociations().add(c);
		manager.getAssociations().add(d);
		manager.getAssociations().add(e);
		manager.getAssociations().add(f);
		manager.getAssociations().add(g);

		manager.removeAssociation(a);
		manager.removeAssociation(b);
		manager.removeAssociation(c);
		manager.removeAssociation(d);
		manager.removeAssociation(e);
		manager.removeAssociation(f);
		manager.removeAssociation(g);
	}

	@Test(expected = ConsistencyException.class)
	public void removeAssociationCE() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat5);
		try {
			manager.getAssociations().add(a);
			linkManager.createLink(a, mao4, mao5);
		} catch (final Exception e) {
			fail("Exception an der falschen Stelle");
		}
		manager.removeAssociation(a);
	}

	@Test
	public void createHierarchySuccessful() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat5);
		final PersistentAssociation b = Association.createAssociation("b", mptSingle2, mat5);
		final PersistentAssociation c = Association.createAssociation("c", mptMultiple2And4, mat5);
		final PersistentAssociation d = Association.createAssociation("d", mstSingle2, mat5);
		final PersistentAssociation e = Association.createAssociation("e", mstMultiple2And4, mat5);
		final PersistentAssociation f = Association.createAssociation("f", mstMixed2And4Or5And6, mat5);
		final PersistentAssociation g = Association.createAssociation("g", mptMixed2Or4And5Or6, mat5);
		manager.getAssociations().add(a);
		manager.getAssociations().add(b);
		manager.getAssociations().add(c);
		manager.getAssociations().add(d);
		manager.getAssociations().add(e);
		manager.getAssociations().add(f);
		manager.getAssociations().add(g);

		manager.createHierarchy(a, "a");
		manager.createHierarchy(b, "b");
		manager.createHierarchy(c, "c");
		manager.createHierarchy(d, "d");
		manager.createHierarchy(e, "e");
		manager.createHierarchy(f, "f");
		manager.createHierarchy(g, "g");
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createHierarchyDDE() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat5);
		final PersistentAssociation b = Association.createAssociation("b", mptSingle2, mat5);
		manager.getAssociations().add(a);
		manager.getAssociations().add(b);

		manager.createHierarchy(a, "a");
		manager.createHierarchy(b, "a");
	}

	@Test(expected = CycleException.class)
	public void createHierarchyCE() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat4);
		try {
			manager.getAssociations().add(a);
			linkManager.createLink(a, mao4, mao4);
		} catch (final Exception e) {
			fail("Exception an der falschen Stelle");
		}
		manager.createHierarchy(a, "a");
	}

	@Test
	public void removeAssoFormHierarchy() throws PersistenceException, NotAvailableException, CycleException,
			ConsistencyException {
		final PersistentAssociation a = Association.createAssociation("a", mat4, mat5);
		final PersistentHierarchy h = Hierarchy.createHierarchy("a");
		try {
			manager.getAssociations().add(a);
			h.getAssociations().add(a);
			manager.getHierarchies().add(h);
		} catch (final Exception e) {
			fail("Exception an der falschen Stelle");
		}
		manager.removeAssoFrmHier(h, a);
	}

	@Test
	public void addAssoicationWithoutCycleE01() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation firstAsso = Association.createAssociation("a", mat1, mat3);
		final PersistentAssociation secondAsso = Association.createAssociation("b", mat3, mat1);

		manager.getAssociations().add(firstAsso);
		manager.getAssociations().add(secondAsso);

		linkManager.createLink(firstAsso, mao1, mao3);
		linkManager.createLink(secondAsso, mao3, mao1);
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
		linkManager.createLink(secondAsso, mao3, mao1);

		manager.addAssociation(createHierarchy, firstAsso);
		manager.addAssociation(createHierarchy, secondAsso);
		fail("Zyklus konnte erstellt werden");
	}
}
