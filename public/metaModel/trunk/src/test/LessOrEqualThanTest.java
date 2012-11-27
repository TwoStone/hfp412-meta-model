package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import model.CycleException;
import model.MAspect;
import model.MAtomicType;
import model.MFalse;
import model.MProductType;
import model.MSumType;
import model.MTrue;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;

public class LessOrEqualThanTest extends AbstractTest {

	private PersistentMBoolean mTrue;
	private PersistentMBoolean mFalse;

	private PersistentMAtomicType mat1;
	private PersistentMAtomicType mat2;
	private PersistentMAtomicType mat3;
	private PersistentMAtomicType mat4;
	private PersistentMAtomicType mat5;
	private PersistentMAtomicType mat6;

	private PersistentMProductType mptEmpty;
	private PersistentMProductType mptSingle1;
	private PersistentMProductType mptSingle2;
	private PersistentMProductType mptSingle3;
	private PersistentMProductType mptSingle4;
	private PersistentMProductType mptSingle5;
	private PersistentMProductType mptMultiple2And4;
	private PersistentMProductType mptMultiple4And2;
	private PersistentMProductType mptMultiple5And6;
	private PersistentMProductType mptMultiple4And5;

	private PersistentMSumType mstSingle1;
	private PersistentMSumType mstSingle2;
	private PersistentMSumType mstSingle3;
	private PersistentMSumType mstSingle4;
	private PersistentMSumType mstSingle5;
	private PersistentMSumType mstMultiple2And4;
	private PersistentMSumType mstMultiple4And2;
	private PersistentMSumType mstMultiple4And5;
	private PersistentMSumType mstMultiple5And6;
	private PersistentMSumType mstMultiple2And4And5;

	public LessOrEqualThanTest() throws PersistenceException, CycleException {
		// Boolean
		mTrue = MTrue.getTheMTrue();
		mFalse = MFalse.getTheMFalse();

		// AtomicType
		mat1 = MAtomicType.createMAtomicType("Typ1", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 1"));
		mat2 = MAtomicType.createMAtomicType("Typ2", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 2"));
		mat3 = MAtomicType.createMAtomicType("Typ3", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 3"));
		mat4 = MAtomicType.createMAtomicType("Typ4", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 4"));
		mat5 = MAtomicType.createMAtomicType("Typ5", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 5"));
		mat6 = MAtomicType.createMAtomicType("Typ5", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 6"));

		mat1.setSuperType(mat2);
		mat2.setSuperType(mat3);

		// ProductType
		mptEmpty = MProductType.createMProductType();
		mptSingle1 = MProductType.createMProductType();
		mptSingle2 = MProductType.createMProductType();
		mptSingle3 = MProductType.createMProductType();
		mptSingle4 = MProductType.createMProductType();
		mptSingle5 = MProductType.createMProductType();
		mptMultiple2And4 = MProductType.createMProductType();
		mptMultiple4And2 = MProductType.createMProductType();
		mptMultiple5And6 = MProductType.createMProductType();
		mptMultiple4And5 = MProductType.createMProductType();

		mptSingle1.getContainedTypes().add(mat1);
		mptSingle2.getContainedTypes().add(mat2);
		mptSingle3.getContainedTypes().add(mat3);
		mptSingle4.getContainedTypes().add(mat4);
		mptSingle5.getContainedTypes().add(mat5);
		mptMultiple2And4.getContainedTypes().add(mat2);
		mptMultiple2And4.getContainedTypes().add(mat4);
		mptMultiple4And2.getContainedTypes().add(mat4);
		mptMultiple4And2.getContainedTypes().add(mat2);
		mptMultiple5And6.getContainedTypes().add(mat5);
		mptMultiple5And6.getContainedTypes().add(mat6);
		mptMultiple4And5.getContainedTypes().add(mat4);
		mptMultiple4And5.getContainedTypes().add(mat5);

		// SumType
		mstSingle1 = MSumType.createMSumType();
		mstSingle2 = MSumType.createMSumType();
		mstSingle3 = MSumType.createMSumType();
		mstSingle4 = MSumType.createMSumType();
		mstSingle5 = MSumType.createMSumType();
		mstMultiple2And4 = MSumType.createMSumType();
		mstMultiple4And2 = MSumType.createMSumType();
		mstMultiple4And5 = MSumType.createMSumType();
		mstMultiple5And6 = MSumType.createMSumType();
		mstMultiple2And4And5 = MSumType.createMSumType();

		mstSingle1.getContainedTypes().add(mat1);
		mstSingle2.getContainedTypes().add(mat2);
		mstSingle3.getContainedTypes().add(mat3);
		mstSingle4.getContainedTypes().add(mat4);
		mstSingle5.getContainedTypes().add(mat5);
		mstMultiple2And4.getContainedTypes().add(mat2);
		mstMultiple2And4.getContainedTypes().add(mat4);
		mstMultiple4And2.getContainedTypes().add(mat4);
		mstMultiple4And2.getContainedTypes().add(mat2);
		mstMultiple4And5.getContainedTypes().add(mat4);
		mstMultiple4And5.getContainedTypes().add(mat5);
		mstMultiple5And6.getContainedTypes().add(mat5);
		mstMultiple5And6.getContainedTypes().add(mat6);
		mstMultiple2And4And5.getContainedTypes().add(mat2);
		mstMultiple2And4And5.getContainedTypes().add(mat4);
		mstMultiple2And4And5.getContainedTypes().add(mat5);
	}

	@Test
	public void atomicTypeisLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		// Identitaet
		assertEquals(mTrue, mat1.isLessOrEqual(mat1));
		// Vererbung eine Ebene
		assertEquals(mTrue, mat1.isLessOrEqual(mat2));
		assertEquals(mFalse, mat2.isLessOrEqual(mat1));
		// Vererbung zwei Ebenen
		assertEquals(mTrue, mat1.isLessOrEqual(mat3));
		assertEquals(mFalse, mat3.isLessOrEqual(mat1));
		// voneinander unabhaengig
		assertEquals(mFalse, mat4.isLessOrEqual(mat1));
	}

	@Test
	public void atomicTypeisLessOrEqualThanProductType() throws PersistenceException, CycleException {
		// leeres Produkt
		assertEquals(mFalse, mat1.isLessOrEqual(mptEmpty));
		// Einwertige Produkte
		assertEquals(mTrue, mat2.isLessOrEqual(mptSingle2));
		assertEquals(mTrue, mat1.isLessOrEqual(mptSingle2));
		assertEquals(mFalse, mat1.isLessOrEqual(mptSingle4));
		// Mehrwertige Produkte
		assertEquals(mFalse, mat2.isLessOrEqual(mptMultiple2And4));
		
		assertEquals(mFalse, mat5.isLessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mat1.isLessOrEqual(mptMultiple2And4));
	}

	@Test
	public void atomicTypeisLessOrEqualThanSumType() throws PersistenceException, CycleException {
		// Einwertige Summen
		assertEquals(mTrue, mat2.isLessOrEqual(mstSingle2));
		assertEquals(mTrue, mat1.isLessOrEqual(mstSingle2));
		assertEquals(mFalse, mat4.isLessOrEqual(mstSingle2));
		// Mehrwertige Summen
		assertEquals(mTrue, mat5.isLessOrEqual(mstMultiple4And5));
		assertEquals(mFalse, mat1.isLessOrEqual(mstMultiple4And5));
		assertEquals(mTrue, mat1.isLessOrEqual(mstMultiple2And4));
	}

	@Test
	public void productTypeisLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mptEmpty.isLessOrEqual(mat1));

		assertEquals(mFalse, mptSingle2.isLessOrEqual(mat1));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mat2));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mat3));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mat4));

		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mat1));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mat2));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mat3));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mat5));
	}

	@Test
	public void productTypeisLessOrEqualThanProductType() throws PersistenceException, CycleException {
		// Identit�t
		assertEquals(mTrue, mptEmpty.isLessOrEqual(mptEmpty));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mptSingle2));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptMultiple2And4));

		assertEquals(mFalse, mptSingle2.isLessOrEqual(mptEmpty));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mptSingle3));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mptSingle1));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mptSingle4));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mptSingle1.isLessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mptSingle4.isLessOrEqual(mptMultiple2And4));

		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mptEmpty));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mptSingle1));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptSingle2));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptSingle3));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptSingle4));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptMultiple2And4));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mptMultiple4And2));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mptMultiple5And6));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mptMultiple4And5));
	}

	@Test
	public void productTypeisLessOrEqualThanSumType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mptEmpty.isLessOrEqual(mstSingle2));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mstSingle2));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mstSingle1));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mstSingle3));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mstSingle4));
		assertEquals(mTrue, mptSingle2.isLessOrEqual(mstMultiple2And4));
		assertEquals(mFalse, mptSingle2.isLessOrEqual(mstMultiple4And5));

		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mstSingle1));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstSingle2));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstSingle3));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstSingle4));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mstSingle5));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstMultiple2And4));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstMultiple4And2));
		assertEquals(mFalse, mptMultiple2And4.isLessOrEqual(mstMultiple5And6));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstMultiple2And4And5));
		assertEquals(mTrue, mptMultiple2And4.isLessOrEqual(mstMultiple4And5));

	}

	@Test
	public void sumTypeisLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mat1));
		assertEquals(mTrue, mstSingle2.isLessOrEqual(mat2));
		assertEquals(mTrue, mstSingle2.isLessOrEqual(mat3));
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mat4));
		assertEquals(mTrue, mstSingle1.isLessOrEqual(mat3));

		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mat1));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mat2));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mat3));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mat4));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mat5));
	}

	@Test
	public void sumTypeisLessOrEqualThanProductType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mptEmpty));
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mptSingle1));
		assertEquals(mTrue, mstSingle2.isLessOrEqual(mptSingle2));
		assertEquals(mTrue, mstSingle2.isLessOrEqual(mptSingle3));
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mptSingle4));
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mstSingle2.isLessOrEqual(mptMultiple5And6));

		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptEmpty));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptSingle1));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptSingle2));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptSingle3));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptSingle4));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptSingle5));
		assertEquals(mFalse, mstMultiple2And4.isLessOrEqual(mptMultiple2And4));
	}

	@Test
	public void sumTypeisLessOrEqualThanSumType() throws PersistenceException, CycleException {
		fail("Testf�lle fehlen noch");
	}
}