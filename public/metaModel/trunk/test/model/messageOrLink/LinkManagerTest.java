package model.messageOrLink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.Association;
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
	public void createLink() throws PersistenceException, ConsistencyException, CycleException {
		final PersistentAssociation createAssociation = Association.createAssociation("testAssociation", mat1, mat6);
		associationMan.getAssociations().add(createAssociation);

		this.linkMan.createLink(createAssociation, mao1, mao6);

		assertEquals(1, linkMan.getLinks().getLength());
	}

	@Test
	public void createLinkWithHierarchieConstraints() throws PersistenceException, DoubleDefinitionException,
			CycleException, ConsistencyException {
		final PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		final PersistentAssociation createAssociation = Association.createAssociation("testAssociation", mat1, mat6);
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
		final PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat1);
		final PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat1, mat1);

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
		final PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat6);
		final PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat6, mat1);

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

		final PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat6);
		final PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat6, mat1);
		final PersistentAssociation thirdAssociation = Association.createAssociation("thirdAssociation", mat5, mat1);

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

		final PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat6);
		final PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat6, mat1);
		final PersistentAssociation thirdAssociation = Association.createAssociation("thirdAssociation", mat5, mat1);

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
		final PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat6);
		final PersistentHierarchy createHierarchy1 = Hierarchy.createHierarchy("hierarchie1");
		this.associationMan.addAssociation(createHierarchy1, firstAssociation);

		final PersistentLink createLink = Link.createLink(mao1, mao6, firstAssociation);
		// TODO: Die Manager sollten beim create das erstellte Objekt zurueck geben. SO bring das nichts! (SIeht man
		// beim debuggen).
		linkMan.getLinks().add(createLink);

		linkMan.removeLink(createLink);
		assertEquals(0, linkMan.getLinks().getLength());
	}

}
