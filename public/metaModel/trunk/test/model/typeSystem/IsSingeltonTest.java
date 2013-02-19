package model.typeSystem;

import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import util.TestingBase;

public class IsSingeltonTest extends TestingBase {

	@Test
	public void onMAtomicType_test01() throws PersistenceException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAtomicType t1 = atomicType("T1", a1);

		org.junit.Assert.assertEquals(mFalse, t1.isSingleton());
	}

	@Test
	public void onMAtomicType_test02() throws PersistenceException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);

		org.junit.Assert.assertEquals(mTrue, t1.isSingleton());
	}

	@Test
	public void onEmtpyProduct() throws PersistenceException {
		// Anything Singleton?
		org.junit.Assert.assertEquals(mTrue, MEmptyTypeConjunction.getTheMEmptyTypeConjunction().isSingleton());
	}

	@Test
	public void onEmtpySum() throws PersistenceException {
		// Wirklich? Löwe hatte doch was anderes gesagt, oder?
		org.junit.Assert.assertEquals(mTrue, MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction().isSingleton());
	}

	@Test
	public void onMProductType_test01() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);

		PersistentMMixedConjunction prod = product(t1, t2);

		org.junit.Assert.assertEquals(mTrue, prod.isSingleton());
	}

	@Test
	public void onMProductType_test02() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMMixedConjunction prod = product(t1, t2);

		org.junit.Assert.assertEquals(mFalse, prod.isSingleton());
	}

	@Test
	public void onMProductType_test03() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMMixedConjunction prod = product(t1, t2);
		PersistentMMixedConjunction prod1 = product(t3, t4, prod);

		org.junit.Assert.assertEquals(mTrue, prod1.isSingleton());
	}

	@Test
	public void onMProductType_test04() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mFalse, mFalse, a2);

		PersistentMMixedConjunction prod = product(t1, t2);
		PersistentMMixedConjunction prod1 = product(t3, t4, prod);

		org.junit.Assert.assertEquals(mFalse, prod1.isSingleton());
	}

	@Test
	public void onMProductType_test05() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2);

		PersistentMMixedConjunction prod = product(t1, t2);
		PersistentMMixedConjunction prod1 = product(t3, t4, prod, sum1);

		org.junit.Assert.assertEquals(mTrue, prod1.isSingleton());
	}

	@Test
	public void onMProductType_test06() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2, t4);

		PersistentMMixedConjunction prod = product(t1, t2);
		PersistentMMixedConjunction prod1 = product(t3, t4, prod, sum1);

		org.junit.Assert.assertEquals(mFalse, prod1.isSingleton());
	}

	@Test
	public void onMSumType_test01() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2);

		org.junit.Assert.assertEquals(mTrue, sum1.isSingleton());
	}

	@Test
	public void onMSumType_test02() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2);

		org.junit.Assert.assertEquals(mFalse, sum1.isSingleton());
	}

	@Test
	public void onMSumType_test03() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mFalse, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2, t1);

		org.junit.Assert.assertEquals(mFalse, sum1.isSingleton());
	}

	@Test
	public void onMSumType_test04() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2, t1);

		org.junit.Assert.assertEquals(mFalse, sum1.isSingleton());
	}

	@Test
	public void onMSumType_test05() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMMixedTypeDisjunction sum1 = sum(t2);
		PersistentMMixedTypeDisjunction sum2 = sum(t2, sum1);

		org.junit.Assert.assertEquals(mFalse, sum2.isSingleton());
	}

	@Test
	public void onMSumType_test06() throws PersistenceException, CycleException {

		PersistentMAspect a1 = aspect("A1");
		PersistentMAspect a2 = aspect("A2");
		PersistentMAtomicType t1 = MAtomicType.createMAtomicType("T1", mTrue, mFalse, a1);
		PersistentMAtomicType t2 = MAtomicType.createMAtomicType("T2", mTrue, mFalse, a2);
		PersistentMAtomicType t3 = MAtomicType.createMAtomicType("T3", mTrue, mFalse, a1);
		PersistentMAtomicType t4 = MAtomicType.createMAtomicType("T4", mTrue, mFalse, a2);

		PersistentMMixedConjunction prod1 = product(t3, t4);
		PersistentMMixedTypeDisjunction sum1 = sum(t2, prod1);

		org.junit.Assert.assertEquals(mFalse, sum1.isSingleton());
	}

}
