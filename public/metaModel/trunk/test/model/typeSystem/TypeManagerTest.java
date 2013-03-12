package model.typeSystem;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import model.ConsistencyException;
import model.CycleException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMType;
import persistence.PersistentTypeManager;
import persistence.Predcate;
import util.GOJAUnitTestRunner;
import util.InjectSingleton;
import util.TestingBase;
import utils.SearchLists;

@RunWith(GOJAUnitTestRunner.class)
public class TypeManagerTest extends TestingBase {

	@InjectSingleton(TypeManager.class)
	PersistentTypeManager typeMngr;

	@InjectSingleton(AspectManager.class)
	PersistentAspectManager aspectMngr;

	/*
	 * @InjectSingleton(MEmptyTypeConjunction.class) PersistentMEmptyTypeConjunction anything;
	 */
	@InjectSingleton(MEmptyTypeDisjunction.class)
	PersistentMEmptyTypeDisjunction nothing;

	List<PersistentMAspect> aspects;

	@Before
	public void setUpAspects() throws ConsistencyException, PersistenceException {
		aspects = new ArrayList<PersistentMAspect>();
		aspects.add(aspectMngr.createAspect("Aspect1"));
		aspects.add(aspectMngr.createAspect("Aspect2"));
		aspects.add(aspectMngr.createAspect("Aspect3"));
		aspects.add(aspectMngr.createAspect("Aspect4"));
	}

	@Test
	public void createAtomicType_test1() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);

		Assert.assertEquals(aspects.get(0), at1.getAspect());
		Assert.assertEquals("AT1", at1.getName());
		assertMFalse(at1.getSingletonType());
		assertMFalse(at1.getAbstractType());

		Assert.assertTrue(typeManagerContaines(at1));
	}

	@Test
	/**
	 * Creation of two Root ATs in different Aspects
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	public void createAtomicType_test2() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);

		Assert.assertEquals(aspects.get(1), at2.getAspect());
		Assert.assertEquals("AT2", at2.getName());
		assertMFalse(at2.getSingletonType());
		assertMFalse(at2.getAbstractType());

		Assert.assertTrue(typeManagerContaines(at1));
		Assert.assertTrue(typeManagerContaines(at2));
	}

	/**
	 * AtomicTypes muessen paarweise verschiedene Namen in einem Aspekt haben.
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test(expected = ConsistencyException.class)
	public void createAtomicType_test3() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
	}

	/**
	 * AtomicTypes duerfen entweder Singleton oder abstrakt sein.
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test(expected = ConsistencyException.class)
	public void createAtomicType_test4() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mTrue, mTrue);
	}

	/**
	 * AtomicTypes duerfen abstrakt sein.
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createAtomicType_test5() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mTrue);

		assertMTrue(at1.isAbstract());
		assertMFalse(at1.isSingleton());
		Assert.assertTrue(typeManagerContaines(at1));
	}

	/**
	 * AtomicTypes Singleton.
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createAtomicType_test6() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mTrue, mFalse);
		// TODO auf SingletonInstance pruefen
		assertMFalse(at1.isAbstract());
		assertMTrue(at1.isSingleton());
		Assert.assertTrue(typeManagerContaines(at1));
	}

	/**
	 * Empty Conjunction
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createTypeConjunction_test1() throws ConsistencyException, PersistenceException {
		final MTypeSearchList mTypeSearchList = new MTypeSearchList();
		final PersistentMAbstractTypeConjunction emptyConj = typeMngr.createTypeConjunction(mTypeSearchList);

		Assert.assertEquals(anything, emptyConj);
		Assert.assertFalse(typeManagerContaines(emptyConj));
	}

	/**
	 * Conjunction with single AT
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createTypeConjunction_test2() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(at1);

		Assert.assertEquals(1, conj.fetchContainedTypes().getLength());
		Assert.assertTrue(SearchLists.contains(conj.fetchContainedTypes(), at1));
		Assert.assertTrue(typeManagerContaines(conj));
	}

	/**
	 * Conjunction of Conjunction wird aufgeloest
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeConjunction_test3() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeConjunction(at1, at2), createTypeConjunction(at3, at4));

		final PersistentMMixedConjunction expected = product(at1, at2, at3, at4);

		Assert.assertEquals(4, conj.fetchContainedTypes().getLength());
		assertTypeStructureEquals(expected, conj);
		Assert.assertTrue(typeManagerContaines(conj));
	}

	/**
	 * Conj Nothing ist totales Element
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeConjunction_test4() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeConjunction(at1, at2),
				createTypeConjunction(at3, at4, nothing));
		assertTypeSemanticEquals(nothing, conj);
		Assert.assertTrue(typeManagerContaines(conj));
	}

	/**
	 * Conj Anything ist neutrales Element
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeConjunction_test5() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeConjunction(at1, at2),
				createTypeConjunction(at3, at4, anything));

		final PersistentMMixedConjunction expected = product(at1, at2, at3, at4);
		assertTypeStructureEquals(expected, conj);
		Assert.assertTrue(typeManagerContaines(conj));
	}

	/**
	 * Conj Typen muessen aus verschiedenen Aspekten kommen
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test(expected = ConsistencyException.class)
	public void createTypeConjunction_test6() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1_1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at1_2 = typeMngr.createAtomicRootType(aspects.get(0), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);

		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeDisjunction(at3, at1_1), createTypeDisjunction(at4, at1_2));
	}

	/**
	 * Conj: Allgemeinere Typen werden nicht mit aufgenommen
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeConjunction_test9() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicSubType(at1, "AT2", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(at1, at2);
		final PersistentMMixedConjunction expected = product(at2);

		assertTypeSemanticEquals(expected, conj);
		Assert.assertTrue(typeManagerContaines(conj));
	}

	/**
	 * Conj: Allgemeinere Typen werden nicht mit aufgenommen Reihenfolge egal
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeConjunction_test10() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicSubType(at1, "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(1), "AT3", mFalse, mFalse);
		final PersistentMAbstractTypeConjunction conj1 = createTypeConjunction(createTypeDisjunction(at1, at3), at2);
		final PersistentMAbstractTypeConjunction conj2 = createTypeConjunction(at2, createTypeDisjunction(at1, at3));
		final PersistentMMixedConjunction expected = product(at2);

		assertTypeSemanticEquals(expected, conj1);
		assertTypeSemanticEquals(expected, conj2);
		assertTypeSemanticEquals(conj2, conj1);
		Assert.assertTrue(typeManagerContaines(conj1));
		// 3 AT + 1 Disj + 1 Conj
		Assert.assertEquals(5, typeMngr.getTypes().getLength());
	}

	/**
	 * Empty Disjunction
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createTypeDisjunction_test1() throws ConsistencyException, PersistenceException {
		final MTypeSearchList mTypeSearchList = new MTypeSearchList();
		final PersistentMAbstractTypeDisjunction emptyDisj = typeMngr.createTypeDisjunction(mTypeSearchList);

		Assert.assertEquals(nothing, emptyDisj);
		Assert.assertFalse(typeManagerContaines(emptyDisj));
	}

	/**
	 * Disjunction with single AT
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 */
	@Test
	public void createTypeDisjunction_test2() throws ConsistencyException, PersistenceException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(at1);

		Assert.assertEquals(1, disj.fetchContainedTypes().getLength());
		assertTypeSemanticEquals(at1, disj);
		Assert.assertTrue(typeManagerContaines(disj));
	}

	/**
	 * Disjunction of Disjunction wird aufgeloest. Ergebnis DNF (NUR AT)
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeDisjunction_test3() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeDisjunction(at1, at2), createTypeDisjunction(at3, at4));

		final PersistentMMixedTypeDisjunction expected = sum(product(at1), product(at2), product(at3), product(at4));

		Assert.assertEquals(4, disj.fetchContainedTypes().getLength());
		assertTypeStructureEquals(expected, disj);
		Assert.assertTrue(typeManagerContaines(disj));
	}

	/**
	 * Disjunction of Disjunction wird aufgeloest. Ergebnis DNF (NUR AT + ATC)
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeDisjunction_test4() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeConjunction(at1, at2), createTypeDisjunction(at3, at4));

		final PersistentMMixedTypeDisjunction expected = sum(product(at1, at2), product(at3), product(at4));

		Assert.assertEquals(3, disj.fetchContainedTypes().getLength());
		assertTypeStructureEquals(expected, disj);
		Assert.assertTrue(typeManagerContaines(disj));
	}

	/**
	 * Disj Nothing ist neutrales Element
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeDisjunction_test5() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeDisjunction(at1, at2),
				createTypeDisjunction(at3, at4, nothing));

		final PersistentMMixedTypeDisjunction expected = sum(product(at1), product(at2), product(at3), product(at4));

		assertTypeStructureEquals(expected, disj);
		Assert.assertTrue(typeManagerContaines(disj));
	}

	/**
	 * Disj Nothing ist neutrales Element
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeDisjunction_test6() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(nothing);
		assertTypeStructureEquals(nothing, disj);
		Assert.assertFalse(typeManagerContaines(disj));
	}

	/**
	 * Disj Anything ist totales Element
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test
	public void createTypeDisjunction_test7() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType at2 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mFalse, mFalse);
		final PersistentMAtomicType at3 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mFalse, mFalse);
		final PersistentMAtomicType at4 = typeMngr.createAtomicRootType(aspects.get(3), "AT4", mFalse, mFalse);
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeDisjunction(at1, at2),
				createTypeDisjunction(at3, at4, anything));

		assertTypeStructureEquals(sum(anything), disj);
		Assert.assertFalse(typeManagerContaines(disj));
	}

	/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

	private PersistentMAbstractTypeConjunction createTypeConjunction(final PersistentMType... typeList) throws ConsistencyException,
			PersistenceException {
		return typeMngr.createTypeConjunction(SearchLists.createMTypeSearchList(typeList));
	}

	private PersistentMAbstractTypeDisjunction createTypeDisjunction(final PersistentMType... typeList) throws ConsistencyException,
			PersistenceException {
		return typeMngr.createTypeDisjunction(SearchLists.createMTypeSearchList(typeList));
	}

	private boolean typeManagerContaines(final PersistentMType type) throws PersistenceException {
		final PersistentMType findFirst = typeMngr.getTypes().findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return argument.equals(type);
			}
		});
		return findFirst != null;
	}

}
