package model.abstractOperation;

import static org.junit.Assert.assertTrue;
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
import persistence.PersistentOperationManager;
import persistence.Predcate;
import util.AbstractTest;
import util.InjectSingleton;

public class AssociationManagerTest extends AbstractTest {

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager manager;

	@InjectSingleton(OperationManager.class)
	private PersistentOperationManager opManager;

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

		manager.createAssociation(mptEmpty, mat1, "o");
		manager.createAssociation(mat1, mptEmpty, "p");
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
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentAssociation b = manager.createAssociation(mptSingle2, mat5, "b");
		final PersistentAssociation c = manager.createAssociation(mptMultiple2And4, mat5, "c");
		final PersistentAssociation d = manager.createAssociation(mstSingle2, mat5, "d");
		final PersistentAssociation e = manager.createAssociation(mstMultiple2And4, mat5, "e");
		final PersistentAssociation f = manager.createAssociation(mstMixed2And4Or5And6, mat5, "f");
		final PersistentAssociation g = manager.createAssociation(mptMixed2Or4And5Or6, mat5, "g");

		manager.removeAssociation(a);
		manager.removeAssociation(b);
		manager.removeAssociation(c);
		manager.removeAssociation(d);
		manager.removeAssociation(e);
		manager.removeAssociation(f);
		manager.removeAssociation(g);
	}

	@Test(expected = ConsistencyException.class)
	public void removeAssociationCE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		manager.getAssociations().add(a);
		linkManager.createLink(a, mao4, mao5);
		manager.removeAssociation(a);
	}

	@Test(expected = ConsistencyException.class)
	public void removeAssociationCE02() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		manager.createHierarchy(a, "h");
		manager.removeAssociation(a);
	}

	@Test(expected = NotAvailableException.class)
	public void removeAssoFromHierarchyCE01() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException, NotAvailableException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentAssociation b = manager.createAssociation(mat4, mat5, "b");
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.removeAssoFrmHier(h, b);
	}

	@Test
	public void removeHierarchy() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.removeHierarchy(h);
	}

	@Test
	public void createHierarchySuccessful() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentAssociation b = manager.createAssociation(mptSingle2, mat5, "b");
		final PersistentAssociation c = manager.createAssociation(mptMultiple2And4, mat5, "c");
		final PersistentAssociation d = manager.createAssociation(mstSingle2, mat5, "d");
		final PersistentAssociation e = manager.createAssociation(mstMultiple2And4, mat5, "e");
		final PersistentAssociation f = manager.createAssociation(mstMixed2And4Or5And6, mat5, "f");
		final PersistentAssociation g = manager.createAssociation(mptMixed2Or4And5Or6, mat5, "g");

		assertTrue(checkHierarchyInList(manager.createHierarchy(a, "a")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(b, "b")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(c, "c")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(d, "d")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(e, "e")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(f, "f")));
		assertTrue(checkHierarchyInList(manager.createHierarchy(g, "g")));
	}

	private Boolean checkHierarchyInList(final PersistentHierarchy h) throws PersistenceException {
		if (manager.getHierarchies().findFirst(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				if (argument.equals(h)) {
					return true;
				}
				return false;
			}
		}) != null) {
			return true;
		}
		return false;
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createHierarchyDDE() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentAssociation b = manager.createAssociation(mptSingle2, mat5, "b");
		manager.createHierarchy(a, "a");
		manager.createHierarchy(b, "a");
	}

	@Test(expected = CycleException.class)
	public void createHierarchyCE() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat4, "a");
		linkManager.createLink(a, mao4, mao4);
		manager.createHierarchy(a, "a");
	}

	@Test
	public void removeAssoFormHierarchy() throws PersistenceException, NotAvailableException, CycleException,
			ConsistencyException, DoubleDefinitionException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentAssociation b = manager.createAssociation(mat3, mat5, "b");
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.addAssociation(h, b);
		manager.removeAssoFrmHier(h, a);
	}

	@Test(expected = ConsistencyException.class)
	public void removeAssoFormHierarchyCE02() throws PersistenceException, NotAvailableException, CycleException,
			ConsistencyException, DoubleDefinitionException {
		final PersistentAssociation a = manager.createAssociation(mat4, mat5, "a");
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.removeAssoFrmHier(h, a);
	}

	@Test
	public void addAssoicationWithoutCycleE01() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		final PersistentAssociation a = manager.createAssociation(mat1, mat3, "a");
		final PersistentAssociation b = manager.createAssociation(mat3, mat1, "b");
		linkManager.createLink(a, mao1, mao3);
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.addAssociation(h, b);
	}

	@Test(expected = CycleException.class)
	public void addAssoicationCycleE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation firstAsso = manager.createAssociation(mat1, mat3, "a");
		final PersistentAssociation secondAsso = manager.createAssociation(mat3, mat1, "b");
		linkManager.createLink(firstAsso, mao1, mao3);
		linkManager.createLink(secondAsso, mao3, mao1);
		final PersistentHierarchy createHierarchy = manager.createHierarchy(firstAsso, "firstHierarchy");
		manager.addAssociation(createHierarchy, secondAsso);
	}

	@Test(expected = ConsistencyException.class)
	public void addAssoicationCE01() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			CycleException {
		final PersistentAssociation a = manager.createAssociation(mat1, mat3, "a");
		final PersistentHierarchy h = manager.createHierarchy(a, "h");
		manager.addAssociation(h, a);
	}

	@Test
	public void createAssoicationAndOpWithSameName() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException, CycleException {
		opManager.createFp("x", mat6);
		opManager.createOperation(mat1, mat3, "a", opManager.getFormalParameters().getList());
		final PersistentAssociation a = manager.createAssociation(mat1, mat3, "a");
	}
}
