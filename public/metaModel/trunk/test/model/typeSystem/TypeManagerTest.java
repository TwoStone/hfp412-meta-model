package model.typeSystem;

import model.ConsistencyException;
import model.CycleException;
import model.basic.MFalse;
import model.basic.MTrue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentTypeManager;
import util.TestingBase;

public class TypeManagerTest extends TestingBase {

	private static PersistentTypeManager typeMan;

	private static PersistentMAspect asp1;
	private static PersistentMAtomicType rootType;// isAbstract
	private static PersistentMAtomicType rootType2;// isSingleton
	private static PersistentMAtomicType rootType3;// concrete not singleton

	private static PersistentMAtomicType t2;
	private static PersistentMAtomicType t3;

	private static PersistentMAtomicType subTypeUnderRoot;
	private static PersistentMAtomicType subTypeUnderSubType;
	private static PersistentMAtomicType subType2UnderRoot;

	private static PersistentMAbstractTypeDisjunction sumtype1;
	private static PersistentMAbstractTypeDisjunction sumtype2;

	private static PersistentMAbstractTypeConjunction prodtype1;
	private static PersistentMAbstractTypeConjunction prodtype2;

	@BeforeClass
	public static void inits() throws Exception {
		typeMan = TypeManager.getTheTypeManager();
		asp1 = AspectManager.getTheAspectManager().createAspect("ABCDEFGHIJ");
	}

	@Test
	public void createAtomicRootType_test01() throws ConsistencyException, PersistenceException {
		System.out.println(asp1);
		rootType = typeMan.createAtomicRootType(asp1, "RootType", MFalse.getTheMFalse(), MTrue.getTheMTrue());

	}

	@Test(expected = ConsistencyException.class)
	public void createAtomicRootType_test02() throws ConsistencyException, PersistenceException {
		typeMan.createAtomicRootType(asp1, "RootType", MFalse.getTheMFalse(), MTrue.getTheMTrue());
	}

	@Test(expected = ConsistencyException.class)
	public void createAtomicRootType_test03() throws ConsistencyException, PersistenceException {
		typeMan.createAtomicRootType(asp1, "RootType2", MTrue.getTheMTrue(), MTrue.getTheMTrue());
	}

	@Test
	public void createAtomicRootType_test04() throws ConsistencyException, PersistenceException {
		rootType2 = typeMan.createAtomicRootType(asp1, "RootType2", MTrue.getTheMTrue(), MFalse.getTheMFalse());
	}

	@Test
	public void createAtomicRootType_test06() throws ConsistencyException, PersistenceException {
		rootType3 = typeMan.createAtomicRootType(asp1, "RootType3", MFalse.getTheMFalse(), MFalse.getTheMFalse());
	}

	@Test
	public void createAtomicSubType_test01() throws ConsistencyException, PersistenceException {
		subTypeUnderRoot = typeMan
				.createAtomicSubType(rootType, "SubType1", MTrue.getTheMTrue(), MFalse.getTheMFalse());

		Assert.assertEquals(rootType.getAspect(), subTypeUnderRoot.getAspect());
	}

	@Test(expected = ConsistencyException.class)
	public void createAtomicSubType_test02() throws ConsistencyException, PersistenceException {
		subTypeUnderRoot = typeMan
				.createAtomicSubType(rootType, "SubType1", MTrue.getTheMTrue(), MFalse.getTheMFalse());
	}

	@Test
	public void createAtomicSubType_test03() throws ConsistencyException, PersistenceException {
		subTypeUnderSubType = typeMan.createAtomicSubType(subTypeUnderRoot, "SubType2", MTrue.getTheMTrue(),
				MFalse.getTheMFalse());

		Assert.assertEquals(rootType.getAspect(), subTypeUnderSubType.getAspect());
	}

	@Test
	public void createAtomicSubType_test04() throws ConsistencyException, PersistenceException {
		subType2UnderRoot = typeMan.createAtomicSubType(rootType, "SubType3", MTrue.getTheMTrue(),
				MFalse.getTheMFalse());

		Assert.assertEquals(rootType.getAspect(), subType2UnderRoot.getAspect());
	}

	@Test
	public void createTypeDisjunction_test01() throws ConsistencyException, PersistenceException {
		t2 = typeMan.createAtomicRootType(asp1, "t2", MFalse.getTheMFalse(), MFalse.getTheMFalse());
		t3 = typeMan.createAtomicRootType(asp1, "t3", MFalse.getTheMFalse(), MFalse.getTheMFalse());

		MTypeSearchList addens = new MTypeSearchList();
		addens.add(subTypeUnderRoot);
		addens.add(t2);
		addens.add(t3);

		sumtype1 = typeMan.createTypeDisjunction(addens);

	}

	@Test
	public void createTypeDisjunction_test02() throws ConsistencyException, PersistenceException {
		MTypeSearchList addens = new MTypeSearchList();
		addens.add(subTypeUnderRoot);
		addens.add(t2);
		addens.add(t3);

		assertTypeStructureEquals(sumtype1, typeMan.createTypeDisjunction(addens));
	}

	@Test
	public void createTypeDisjunction_test03() throws ConsistencyException, PersistenceException {
		// Different Order to createTypeDisjunction_test02...
		MTypeSearchList addens = new MTypeSearchList();
		addens.add(subTypeUnderRoot);
		addens.add(t3);
		addens.add(t2);

		sumtype2 = typeMan.createTypeDisjunction(addens);
	}

	@Test
	public void createTypeDisjunction_test04() throws ConsistencyException, PersistenceException {
		// TODO Test: SumType createation with empty addens should return the EmptySum Instance...
		// Empty addens list...
		MTypeSearchList addens = new MTypeSearchList();

		assertTypeStructureEquals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(),
				typeMan.createTypeDisjunction(addens));

	}

	@Test
	public void createTypeDisjunction_test05() throws ConsistencyException, PersistenceException {
		MTypeSearchList addens = new MTypeSearchList();
		addens.add(sumtype1);
		addens.add(sumtype2);

		typeMan.createTypeDisjunction(addens);
	}

	@Test
	public void createTypeDisjunction_test06() throws ConsistencyException, PersistenceException, CycleException {
		// TODO Test: SumTypes shouldn't have duplicate addens elements...
		MTypeSearchList addens = new MTypeSearchList();
		addens.add(sumtype1);
		addens.add(sumtype1);

		PersistentMAbstractTypeDisjunction sumType = typeMan.createTypeDisjunction(addens);
		PersistentMAbstractTypeDisjunction expected = sum(sumtype1);

		assertTypeStructureEquals(expected, sumType);
	}

	@Test
	public void createTypeConjunction_test01() throws ConsistencyException, PersistenceException {

		MTypeSearchList factors = new MTypeSearchList();
		factors.add(subTypeUnderRoot);
		factors.add(t2);
		factors.add(t3);

		prodtype1 = typeMan.createTypeConjunction(factors);

	}

	@Test
	public void createTypeConjunction_test02() throws ConsistencyException, PersistenceException {
		MTypeSearchList factors = new MTypeSearchList();
		factors.add(subTypeUnderRoot);
		factors.add(t2);
		factors.add(t3);

		assertTypeStructureEquals(prodtype1, typeMan.createTypeConjunction(factors));
	}

	@Test
	public void createTypeConjunction_test03() throws ConsistencyException, PersistenceException {
		// Different Order to createTypeDisjunction_test02...
		MTypeSearchList factors = new MTypeSearchList();
		factors.add(subTypeUnderRoot);
		factors.add(t3);
		factors.add(t2);

		prodtype2 = typeMan.createTypeConjunction(factors);
	}

	@Test
	public void createTypeConjunction_test04() throws ConsistencyException, PersistenceException {
		// TODO Test: ProductType createation with empty factors should return the EmptyProduct Instance...
		// Empty factors list...
		MTypeSearchList factors = new MTypeSearchList();

		assertTypeStructureEquals(MEmptyTypeConjunction.getTheMEmptyTypeConjunction(),
				typeMan.createTypeConjunction(factors));

	}

	@Test
	public void createTypeConjunction_test05() throws ConsistencyException, PersistenceException, CycleException {
		// TODO Test: ProductTypes shouldn't have duplicate factors elements...
		MTypeSearchList factors = new MTypeSearchList();
		factors.add(t3);
		factors.add(t3);

		prodtype2 = typeMan.createTypeConjunction(factors);
		PersistentMAbstractTypeConjunction expected = product(t3);

		assertTypeStructureEquals(expected, prodtype2);

	}

	@Test(expected = ConsistencyException.class)
	public void createTypeConjunction_test06() throws ConsistencyException, PersistenceException {
		MTypeSearchList factors = new MTypeSearchList();
		factors.add(subType2UnderRoot);
		factors.add(subTypeUnderRoot);

		typeMan.createTypeConjunction(factors);
	}

	@Test
	public void createTypeConjunction_test07() throws PersistenceException, CycleException, ConsistencyException {
		PersistentMAspect aspect = aspect("A");
		PersistentMAtomicType typeA = atomicType("typeA", aspect);
		PersistentMAtomicType typeB = atomicType("typeB", aspect, typeA);

		MTypeSearchList factors = new MTypeSearchList();
		factors.add(typeA);
		factors.add(typeB);

		PersistentMAbstractTypeConjunction expected = product(typeB);
		PersistentMAbstractTypeConjunction actual = typeMan.createTypeConjunction(factors);

		assertTypeStructureEquals(expected, actual);
	}

}
