package model.messageOrLink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.abstractOperation.Association;
import model.abstractOperation.AssociationManager;
import model.abstractOperation.Hierarchy;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLinkManager;
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

	@Test
	public void createLink() throws PersistenceException, ConsistencyException, CycleException {
		PersistentAssociation createAssociation = Association.createAssociation("testAssociation", mat1, mat6);
		// FIXME: Gibt Exception obwohl der Typ anfänglich gesetzt wird Oo mao1.getTypes ist leer!
		this.linkMan.createLink(createAssociation, mao1, mao6);

		assertEquals(1, linkMan.getLinks().getLength());
	}

	@Test
	public void createLinkWithHierarchieConstraints() throws PersistenceException, DoubleDefinitionException,
			CycleException, ConsistencyException {
		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation createAssociation = Association.createAssociation("testAssociation", mat1, mat6);
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
	public void createLinkWithHierarchieConstraintsViolationAtomic2Atomic01() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat1);
		PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat1, mat1);

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
	public void createLinkWithHierarchieConstraintsViolationAtomic2Atomic02() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1, mat6);
		PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat6, mat1);

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		this.linkMan.createLink(firstAssociation, mao1, mao6);
		this.linkMan.createLink(secondAssociation, mao6, mao1);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * Hierarchieverletzung <br/>
	 * Typebene: mat1 -> mat4**mat5; mat4 -> mat1 Entsprechende Links erzeugt => Zyklus
	 * 
	 * @throws ConsistencyException
	 */
	@Test(expected = CycleException.class)
	public void createLinkWithHierarchieConstraintsViolationAtomic2Product01() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat1,
				mptMultiple4And5);
		PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat4, mat1);

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		this.linkMan.createLink(firstAssociation, mao1, mpo4And5);
		this.linkMan.createLink(secondAssociation, mao4, mao1);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * Hierarchieverletzung <br/>
	 * Typebene: mat4**mat5 -> mat1; mat1 -> mat5 Entsprechende Links erzeugt => Zyklus
	 * 
	 * @throws ConsistencyException
	 */
	@Test(expected = CycleException.class)
	public void createLinkWithHierarchieConstraintsViolationProduct2Atomic() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mptMultiple4And5,
				mat1);
		PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat1, mat5);

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		this.linkMan.createLink(firstAssociation, mpo4And5, mao1);
		this.linkMan.createLink(secondAssociation, mao1, mao5);
		fail("Zyklische Links konnten angelegt werden!");
	}

	/**
	 * Hierarchieverletzung <br/>
	 * Typebene: mat4 -> mat4++mat5; mat5 -> mat4 Entsprechende Links erzeugt => Zyklus
	 * 
	 * @throws ConsistencyException
	 */
	@Test(expected = CycleException.class)
	public void createLinkWithHierarchieConstraintsViolationSum2Atomic01() throws PersistenceException,
			DoubleDefinitionException, CycleException, ConsistencyException {

		PersistentHierarchy createHierarchy = Hierarchy.createHierarchy("hierarchie1");
		PersistentAssociation firstAssociation = Association.createAssociation("firstAssociation", mat4,
				mstMultiple4And5);
		PersistentAssociation secondAssociation = Association.createAssociation("secondAssociation", mat5, mat4);

		this.associationMan.addAssociation(createHierarchy, firstAssociation);
		this.associationMan.addAssociation(createHierarchy, secondAssociation);

		this.linkMan.createLink(firstAssociation, mao4, mao5);
		this.linkMan.createLink(secondAssociation, mao5, mao4);
		fail("Zyklische Links konnten angelegt werden!");
	}

}
