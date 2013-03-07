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
import persistence.PersistentMEmptyTypeConjunction;
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

	@InjectSingleton(MEmptyTypeConjunction.class)
	PersistentMEmptyTypeConjunction anything;

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

		Assert.assertEquals(1, conj.getContainedTypes().getLength());
		Assert.assertTrue(SearchLists.contains(conj.getContainedTypes(), at1));
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
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeConjunction(at1, at2),
				createTypeConjunction(at3, at4));

		final PersistentMMixedConjunction expected = product(at1, at2, at3, at4);

		Assert.assertEquals(4, conj.getContainedTypes().getLength());
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
		Assert.assertFalse(typeManagerContaines(conj));
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

		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(createTypeDisjunction(at3, at1_1),
				createTypeDisjunction(at4, at1_2));
	}

	/**
	 * Conj Beinhaltete Typen duerfen nicht singleton sein
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test(expected = ConsistencyException.class)
	public void createTypeConjunction_test7() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType atSingleton = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mTrue, mFalse);

		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(at1, atSingleton);
		System.out.println(conj);
	}

	/**
	 * Conj: Beinhaltete Typen duerfen nicht singleton sein (singleton disj)
	 * 
	 * @throws ConsistencyException
	 * @throws PersistenceException
	 * @throws CycleException
	 */
	@Test(expected = ConsistencyException.class)
	public void createTypeConjunction_test8() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAtomicType at1 = typeMngr.createAtomicRootType(aspects.get(0), "AT1", mFalse, mFalse);
		final PersistentMAtomicType atSingleton1 = typeMngr.createAtomicRootType(aspects.get(1), "AT2", mTrue, mFalse);
		final PersistentMAtomicType atSingleton2 = typeMngr.createAtomicRootType(aspects.get(2), "AT3", mTrue, mFalse);
		final PersistentMAbstractTypeConjunction conj = createTypeConjunction(at1,
				createTypeDisjunction(atSingleton1, atSingleton2));
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

		Assert.assertEquals(1, disj.getContainedTypes().getLength());
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
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeDisjunction(at1, at2),
				createTypeDisjunction(at3, at4));

		final PersistentMMixedTypeDisjunction expected = sum(product(at1), product(at2), product(at3), product(at4));

		Assert.assertEquals(4, disj.getContainedTypes().getLength());
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
		final PersistentMAbstractTypeDisjunction disj = createTypeDisjunction(createTypeConjunction(at1, at2),
				createTypeDisjunction(at3, at4));

		final PersistentMMixedTypeDisjunction expected = sum(product(at1, at2), product(at3), product(at4));

		Assert.assertEquals(3, disj.getContainedTypes().getLength());
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

	private PersistentMAbstractTypeConjunction createTypeConjunction(final PersistentMType... typeList)
			throws ConsistencyException, PersistenceException {
		return typeMngr.createTypeConjunction(SearchLists.createMTypeSearchList(typeList));
	}

	private PersistentMAbstractTypeDisjunction createTypeDisjunction(final PersistentMType... typeList)
			throws ConsistencyException, PersistenceException {
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

	// private static PersistentTypeManager typeMan;
	//
	// private static PersistentMAspect asp1;
	// private static PersistentMAtomicType rootType;// isAbstract
	// private static PersistentMAtomicType rootType2;// isSingleton
	// private static PersistentMAtomicType rootType3;// concrete not singleton
	//
	// private static PersistentMAtomicType t2;
	// private static PersistentMAtomicType t3;
	//
	// private static PersistentMAtomicType subTypeUnderRoot;
	// private static PersistentMAtomicType subTypeUnderSubType;
	// private static PersistentMAtomicType subType2UnderRoot;
	//
	// private static PersistentMAbstractTypeDisjunction sumtype1;
	// private static PersistentMAbstractTypeDisjunction sumtype2;
	//
	// private static PersistentMAbstractTypeConjunction prodtype1;
	// private static PersistentMAbstractTypeConjunction prodtype2;
	//
	// @BeforeClass
	// public static void inits() throws Exception {
	// typeMan = TypeManager.getTheTypeManager();
	// asp1 = AspectManager.getTheAspectManager().createAspect("ABCDEFGHIJ");
	// }
	//
	// @Test
	// public void createAtomicRootType_test01() throws ConsistencyException, PersistenceException {
	// System.out.println(asp1);
	// rootType = typeMan.createAtomicRootType(asp1, "RootType", MFalse.getTheMFalse(), MTrue.getTheMTrue());
	//
	// }
	//
	// @Test(expected = ConsistencyException.class)
	// public void createAtomicRootType_test02() throws ConsistencyException, PersistenceException {
	// typeMan.createAtomicRootType(asp1, "RootType", MFalse.getTheMFalse(), MTrue.getTheMTrue());
	// }
	//
	// @Test(expected = ConsistencyException.class)
	// public void createAtomicRootType_test03() throws ConsistencyException, PersistenceException {
	// typeMan.createAtomicRootType(asp1, "RootType2", MTrue.getTheMTrue(), MTrue.getTheMTrue());
	// }
	//
	// @Test
	// public void createAtomicRootType_test04() throws ConsistencyException, PersistenceException {
	// rootType2 = typeMan.createAtomicRootType(asp1, "RootType2", MTrue.getTheMTrue(), MFalse.getTheMFalse());
	// }
	//
	// @Test
	// public void createAtomicRootType_test06() throws ConsistencyException, PersistenceException {
	// rootType3 = typeMan.createAtomicRootType(asp1, "RootType3", MFalse.getTheMFalse(), MFalse.getTheMFalse());
	// }
	//
	// @Test
	// public void createAtomicSubType_test01() throws ConsistencyException, PersistenceException {
	// subTypeUnderRoot = typeMan
	// .createAtomicSubType(rootType, "SubType1", MTrue.getTheMTrue(), MFalse.getTheMFalse());
	//
	// Assert.assertEquals(rootType.getAspect(), subTypeUnderRoot.getAspect());
	// }
	//
	// @Test(expected = ConsistencyException.class)
	// public void createAtomicSubType_test02() throws ConsistencyException, PersistenceException {
	// subTypeUnderRoot = typeMan
	// .createAtomicSubType(rootType, "SubType1", MTrue.getTheMTrue(), MFalse.getTheMFalse());
	// }
	//
	// @Test
	// public void createAtomicSubType_test03() throws ConsistencyException, PersistenceException {
	// subTypeUnderSubType = typeMan.createAtomicSubType(subTypeUnderRoot, "SubType2", MTrue.getTheMTrue(),
	// MFalse.getTheMFalse());
	//
	// Assert.assertEquals(rootType.getAspect(), subTypeUnderSubType.getAspect());
	// }
	//
	// @Test
	// public void createAtomicSubType_test04() throws ConsistencyException, PersistenceException {
	// subType2UnderRoot = typeMan.createAtomicSubType(rootType, "SubType3", MTrue.getTheMTrue(),
	// MFalse.getTheMFalse());
	//
	// Assert.assertEquals(rootType.getAspect(), subType2UnderRoot.getAspect());
	// }
	//
	// @Test
	// public void createTypeDisjunction_test01() throws ConsistencyException, PersistenceException {
	// t2 = typeMan.createAtomicRootType(asp1, "t2", MFalse.getTheMFalse(), MFalse.getTheMFalse());
	// t3 = typeMan.createAtomicRootType(asp1, "t3", MFalse.getTheMFalse(), MFalse.getTheMFalse());
	//
	// MTypeSearchList addens = new MTypeSearchList();
	// addens.add(subTypeUnderRoot);
	// addens.add(t2);
	// addens.add(t3);
	//
	// sumtype1 = typeMan.createTypeDisjunction(addens);
	//
	// }
	//
	// @Test
	// public void createTypeDisjunction_test02() throws ConsistencyException, PersistenceException {
	// MTypeSearchList addens = new MTypeSearchList();
	// addens.add(subTypeUnderRoot);
	// addens.add(t2);
	// addens.add(t3);
	//
	// assertTypeStructureEquals(sumtype1, typeMan.createTypeDisjunction(addens));
	// }
	//
	// @Test
	// public void createTypeDisjunction_test03() throws ConsistencyException, PersistenceException {
	// // Different Order to createTypeDisjunction_test02...
	// MTypeSearchList addens = new MTypeSearchList();
	// addens.add(subTypeUnderRoot);
	// addens.add(t3);
	// addens.add(t2);
	//
	// sumtype2 = typeMan.createTypeDisjunction(addens);
	// }
	//
	// @Test
	// public void createTypeDisjunction_test04() throws ConsistencyException, PersistenceException {
	// // TODO Test: SumType createation with empty addens should return the EmptySum Instance...
	// // Empty addens list...
	// MTypeSearchList addens = new MTypeSearchList();
	//
	// assertTypeStructureEquals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(),
	// typeMan.createTypeDisjunction(addens));
	//
	// }
	//
	// @Test
	// public void createTypeDisjunction_test05() throws ConsistencyException, PersistenceException {
	// MTypeSearchList addens = new MTypeSearchList();
	// addens.add(sumtype1);
	// addens.add(sumtype2);
	//
	// typeMan.createTypeDisjunction(addens);
	// }
	//
	// @Test
	// public void createTypeDisjunction_test06() throws ConsistencyException, PersistenceException, CycleException {
	// // TODO Test: SumTypes shouldn't have duplicate addens elements...
	// MTypeSearchList addens = new MTypeSearchList();
	// addens.add(sumtype1);
	// addens.add(sumtype1);
	//
	// PersistentMAbstractTypeDisjunction sumType = typeMan.createTypeDisjunction(addens);
	// PersistentMAbstractTypeDisjunction expected = sum(sumtype1);
	//
	// assertTypeStructureEquals(expected, sumType);
	// }
	//
	// @Test
	// public void createTypeConjunction_test01() throws ConsistencyException, PersistenceException {
	//
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(subTypeUnderRoot);
	// factors.add(t2);
	// factors.add(t3);
	//
	// prodtype1 = typeMan.createTypeConjunction(factors);
	//
	// }
	//
	// @Test
	// public void createTypeConjunction_test02() throws ConsistencyException, PersistenceException {
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(subTypeUnderRoot);
	// factors.add(t2);
	// factors.add(t3);
	//
	// assertTypeStructureEquals(prodtype1, typeMan.createTypeConjunction(factors));
	// }
	//
	// @Test
	// public void createTypeConjunction_test03() throws ConsistencyException, PersistenceException {
	// // Different Order to createTypeDisjunction_test02...
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(subTypeUnderRoot);
	// factors.add(t3);
	// factors.add(t2);
	//
	// prodtype2 = typeMan.createTypeConjunction(factors);
	// }
	//
	// @Test
	// public void createTypeConjunction_test04() throws ConsistencyException, PersistenceException {
	// // TODO Test: ProductType createation with empty factors should return the EmptyProduct Instance...
	// // Empty factors list...
	// MTypeSearchList factors = new MTypeSearchList();
	//
	// assertTypeStructureEquals(MEmptyTypeConjunction.getTheMEmptyTypeConjunction(),
	// typeMan.createTypeConjunction(factors));
	//
	// }
	//
	// @Test
	// public void createTypeConjunction_test05() throws ConsistencyException, PersistenceException, CycleException {
	// // TODO Test: ProductTypes shouldn't have duplicate factors elements...
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(t3);
	// factors.add(t3);
	//
	// prodtype2 = typeMan.createTypeConjunction(factors);
	// PersistentMAbstractTypeConjunction expected = product(t3);
	//
	// assertTypeStructureEquals(expected, prodtype2);
	//
	// }
	//
	// @Test(expected = ConsistencyException.class)
	// public void createTypeConjunction_test06() throws ConsistencyException, PersistenceException {
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(subType2UnderRoot);
	// factors.add(subTypeUnderRoot);
	//
	// typeMan.createTypeConjunction(factors);
	// }
	//
	// @Test
	// public void createTypeConjunction_test07() throws PersistenceException, CycleException, ConsistencyException {
	// PersistentMAspect aspect = aspect("A");
	// PersistentMAtomicType typeA = atomicType("typeA", aspect);
	// PersistentMAtomicType typeB = atomicType("typeB", aspect, typeA);
	//
	// MTypeSearchList factors = new MTypeSearchList();
	// factors.add(typeA);
	// factors.add(typeB);
	//
	// PersistentMAbstractTypeConjunction expected = product(typeB);
	// PersistentMAbstractTypeConjunction actual = typeMan.createTypeConjunction(factors);
	//
	// assertTypeStructureEquals(expected, actual);
	// }

}
