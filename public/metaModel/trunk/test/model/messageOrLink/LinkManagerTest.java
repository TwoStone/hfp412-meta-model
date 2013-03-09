package model.messageOrLink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.AssociationManager;
import model.abstractOperation.Hierarchy;
import model.typeSystem.ObjectManager;

import org.junit.Test;

import persistence.MAtomicTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMObject;
import persistence.PersistentObjectManager;
import util.AbstractTest;
import util.InjectSingleton;

public class LinkManagerTest extends AbstractTest {
	public LinkManagerTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@InjectSingleton(LinkManager.class)
	private PersistentLinkManager linkMan;

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager associationMan;

	@InjectSingleton(ObjectManager.class)
	private PersistentObjectManager objectMan;

	@Test
	public void createLink() throws PersistenceException, ConsistencyException, CycleException,
			DoubleDefinitionException {
		final PersistentAssociation createAssociation = associationMan.createAssociation(mat1, mat6, "testAssociation");
		this.linkMan.createLink(createAssociation, mao1, mao6);
		assertEquals(1, linkMan.getLinks().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createLinkWrongSource() throws PersistenceException, ConsistencyException, CycleException,
			DoubleDefinitionException {
		final PersistentAssociation createAssociation = associationMan.createAssociation(mat1, mat6, "testAssociation");
		this.linkMan.createLink(createAssociation, mao4, mao6);
	}

	@Test(expected = ConsistencyException.class)
	public void createLinkWrongTarget() throws PersistenceException, ConsistencyException, CycleException,
			DoubleDefinitionException {
		final PersistentAssociation createAssociation = associationMan.createAssociation(mat1, mat6, "testAssociation");
		this.linkMan.createLink(createAssociation, mao1, mao3);
	}

	@Test
	public void createLinkWithHierarchieConstraints() throws PersistenceException, DoubleDefinitionException,
			CycleException, ConsistencyException {
		final PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		final PersistentAssociation createAssociation = associationMan.createAssociation(mat1, mat6, "testAssociation");
		this.associationMan.addAssociation(createHierarchy, createAssociation);

		this.linkMan.createLink(createAssociation, mao1, mao6);
		assertEquals(1, linkMan.getLinks().getLength());
	}

	/**
	 * Simpelste Form der Hierarchieverletzung: mao1 -> mao1 und zurueck
	 * 
	 * @throws ConsistencyException
	 */
	@Test(expected = CycleException.class)
	public void createLinkWithHierarchieConstraintsViolation01() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		final PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		final PersistentAssociation firstAssociation = associationMan.createAssociation(mat1, mat1, "firstAssociation");
		final PersistentAssociation secondAssociation = associationMan.createAssociation(mat1, mat1,
				"secondAssociation");

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		this.linkMan.createLink(firstAssociation, mao1, mao1);
		this.linkMan.createLink(secondAssociation, mao1, mao1);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * Hierarchieverletzung: mao1 -> mao6; mao6 -> mao1
	 * 
	 * @throws ConsistencyException
	 */
	@Test(expected = CycleException.class)
	public void createLinkWithHierarchieConstraintsViolation02() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		final PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		final PersistentAssociation firstAssociation = associationMan.createAssociation(mat1, mat6, "firstAssociation");
		final PersistentAssociation secondAssociation = associationMan.createAssociation(mat6, mat1,
				"secondAssociation");

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		final PersistentMObject atmoicObject1 = objectMan.createMObject(mat1, new MAtomicTypeSearchList());
		final PersistentMObject atmoicObject6 = objectMan.createMObject(mat6, new MAtomicTypeSearchList());

		this.linkMan.createLink(firstAssociation, atmoicObject1, atmoicObject6);
		this.linkMan.createLink(secondAssociation, atmoicObject6, atmoicObject1);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * 1ne Hierarchie <br/>
	 * Aufbau: mao1 -x-> mao6; mao6 -x-> mao5; mao5 -x-> mao1; <br/>
	 * Keine Hierarchieverletzung
	 * 
	 * @throws ConsistencyException
	 */
	public void createLinkWithHierarchieConstraints03() throws PersistenceException, DoubleDefinitionException,
			CycleException, ConsistencyException {

		final PersistentHierarchy createHierarchy1 = Hierarchy.createHierarchy("hierarchie1");

		final PersistentAssociation firstAssociation = associationMan.createAssociation(mat1, mat6, "firstAssociation");
		final PersistentAssociation secondAssociation = associationMan.createAssociation(mat6, mat1,
				"secondAssociation");
		final PersistentAssociation thirdAssociation = associationMan.createAssociation(mat5, mat1, "thirdAssociation");

		this.associationMan.addAssociation(createHierarchy1, firstAssociation);
		this.associationMan.addAssociation(createHierarchy1, secondAssociation);
		this.associationMan.addAssociation(createHierarchy1, thirdAssociation);

		this.linkMan.createLink(firstAssociation, mao1, mao6);
		this.linkMan.createLink(secondAssociation, mao6, mao5);
		this.linkMan.createLink(secondAssociation, mao5, mao1);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * 2 Hierarchien: x,y <br/>
	 * Aufbau: mao1 -x-> mao6; mao6 -y-> mao5; mao5 -x-> mao1; <br/>
	 * Keine Hierarchieverletzung
	 * 
	 * @throws ConsistencyException
	 */
	public void createLinkWithHierarchieConstraints02() throws PersistenceException, DoubleDefinitionException,
			CycleException, ConsistencyException {

		final PersistentHierarchy createHierarchy1 = Hierarchy.createHierarchy("hierarchie1");
		final PersistentHierarchy createHierarchy2 = Hierarchy.createHierarchy("hierarchie2");

		final PersistentAssociation firstAssociation = associationMan.createAssociation(mat1, mat6, "firstAssociation");
		final PersistentAssociation secondAssociation = associationMan.createAssociation(mat6, mat1,
				"secondAssociation");
		final PersistentAssociation thirdAssociation = associationMan.createAssociation(mat5, mat1, "thirdAssociation");

		this.associationMan.addAssociation(createHierarchy1, firstAssociation);
		this.associationMan.addAssociation(createHierarchy1, thirdAssociation);

		this.associationMan.addAssociation(createHierarchy2, secondAssociation);

		this.linkMan.createLink(firstAssociation, mao1, mao6);
		this.linkMan.createLink(secondAssociation, mao6, mao5);
		this.linkMan.createLink(secondAssociation, mao5, mao1);
	}

	@Test
	public void removeLinkSuccess01() throws DoubleDefinitionException, ConsistencyException, CycleException,
			PersistenceException {
		final PersistentAssociation firstAssociation = associationMan.createAssociation(mat1, mat6, "firstAssociation");
		final PersistentHierarchy createHierarchy1 = Hierarchy.createHierarchy("hierarchie1");
		this.associationMan.addAssociation(createHierarchy1, firstAssociation);

		final PersistentLink createLink = linkMan.createLink(firstAssociation, mao1, mao6);

		linkMan.removeLink(createLink);
		assertEquals(0, linkMan.getLinks().getLength());
	}

}
