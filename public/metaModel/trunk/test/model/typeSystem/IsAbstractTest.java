package model.typeSystem;

import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import util.TestingBase;

public class IsAbstractTest extends TestingBase {

	@Test
	public void onMAtomicType_test01() throws PersistenceException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAtomicType t1 = atomicType("T1", a1);

		org.junit.Assert.assertEquals(mFalse, t1.isAbstract());
	}

	@Test
	public void onMAtomicType_test02() throws PersistenceException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mTrue, a1);

		org.junit.Assert.assertEquals(mTrue, t1.isAbstract());
	}

	@Test
	public void onEmtpyProduct() throws PersistenceException {

		org.junit.Assert.assertEquals(mFalse, MEmptyProductType.getTheMEmptyProductType().isAbstract());
	}

	@Test
	public void onEmtpySum() throws PersistenceException {

		org.junit.Assert.assertEquals(mTrue, MEmptySumType.getTheMEmptySumType().isAbstract());
	}

	@Test
	public void onMProductType_test01() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mTrue, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);

		PersistentMProductType prod = product(t1, t2);

		org.junit.Assert.assertEquals(mTrue, prod.isAbstract());
	}

	@Test
	public void onMProductType_test02() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMProductType prod = product(t1, t2);

		org.junit.Assert.assertEquals(mFalse, prod.isAbstract());
	}

	@Test
	public void onMProductType_test03() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mTrue, a2);

		PersistentMProductType prod = product(t1, t2);
		PersistentMProductType prod1 = product(t3, t4, prod);

		org.junit.Assert.assertEquals(mTrue, prod1.isAbstract());
	}

	@Test
	public void onMProductType_test04() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mFalse, mFalse, a2);

		PersistentMProductType prod = product(t1, t2);
		PersistentMProductType prod1 = product(t3, t4, prod);

		org.junit.Assert.assertEquals(mFalse, prod1.isAbstract());
	}

	@Test
	public void onMProductType_test05() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mTrue, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMSumType sum1 = sum(t2);

		PersistentMProductType prod = product(t1);
		PersistentMProductType prod1 = product(t3, t4, prod, sum1);

		org.junit.Assert.assertEquals(mTrue, prod1.isAbstract());
	}

	@Test
	public void onMProductType_test06() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMSumType sum1 = sum(t2);

		PersistentMProductType prod = product(t1, t2);
		PersistentMProductType prod1 = product(t3, t4, prod, sum1);

		org.junit.Assert.assertEquals(mFalse, prod1.isAbstract());
	}

	@Test
	public void onMProductType_test06b() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMSumType sum1 = sum(t2, t4);

		PersistentMProductType prod = product(t1, t2);
		PersistentMProductType prod1 = product(t3, t4, prod, sum1);

		org.junit.Assert.assertEquals(mTrue, prod1.isAbstract());
	}

	@Test
	public void onMSumType_test01() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mTrue, a2);

		PersistentMSumType sum1 = sum(t2);

		org.junit.Assert.assertEquals(mTrue, sum1.isAbstract());
	}

	@Test
	public void onMSumType_test02() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMSumType sum1 = sum(t2);

		org.junit.Assert.assertEquals(mFalse, sum1.isAbstract());
	}

	@Test
	public void onMSumType_test03() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMSumType sum1 = sum(t2, t1);

		org.junit.Assert.assertEquals(mTrue, sum1.isAbstract());
	}

	@Test
	public void onMSumType_test04() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);

		PersistentMSumType sum1 = sum(t2, t1);

		org.junit.Assert.assertEquals(mTrue, sum1.isAbstract());
	}

	@Test
	public void onMSumType_test05() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMProductType prod1 = product(t3, t4);
		PersistentMSumType sum1 = sum(prod1);

		org.junit.Assert.assertEquals(mFalse, sum1.isAbstract());
	}

	@Test
	public void onMSumType_test06() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mTrue, a2);

		PersistentMProductType prod1 = product(t3, t4);
		PersistentMSumType sum1 = sum(prod1);

		org.junit.Assert.assertEquals(mTrue, sum1.isAbstract());
	}

}
