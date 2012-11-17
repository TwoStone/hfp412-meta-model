package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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

	private PersistentMProductType mptEmpty;
	private PersistentMProductType mptSingle2;
	private PersistentMProductType mptSingle4;
	private PersistentMProductType mptMultiple2And4;

	private PersistentMSumType mstSingle2;
	private PersistentMSumType mstMultiple2And4;
	private PersistentMSumType mstMultiple4And5;

	public LessOrEqualThanTest() throws PersistenceException, CycleException {
		// Boolean
		mTrue = MTrue.getTheMTrue();
		mFalse = MFalse.getTheMFalse();
		
		// AtomicType
		mat1 = MAtomicType.createMAtomicType("Typ1", MAspect.createMAspect("Aspekt No. 1"));
		mat2 = MAtomicType.createMAtomicType("Typ2", MAspect.createMAspect("Aspekt No. 2"));
		mat3 = MAtomicType.createMAtomicType("Typ3", MAspect.createMAspect("Aspekt No. 3"));
		mat4 = MAtomicType.createMAtomicType("Typ4", MAspect.createMAspect("Aspekt No. 4"));
		mat5 = MAtomicType.createMAtomicType("Typ5", MAspect.createMAspect("Aspekt No. 5"));
		
		mat1.setSuperType(mat2);
		mat2.setSuperType(mat3);
		
		// ProductType
		mptEmpty = MProductType.createMProductType();
		mptSingle2 = MProductType.createMProductType();
		mptSingle4 = MProductType.createMProductType();
		mptMultiple2And4 = MProductType.createMProductType();
		
		mptSingle2.getContainedTypes().add(mat2);
		mptSingle4.getContainedTypes().add(mat4);
		mptMultiple2And4.getContainedTypes().add(mat2);
		mptMultiple2And4.getContainedTypes().add(mat4);
		
		// SumType
		mstSingle2 = MSumType.createMSumType();
		mstMultiple2And4 = MSumType.createMSumType();
		mstMultiple4And5 = MSumType.createMSumType();
		
		mstSingle2.getContainedTypes().add(mat2);
		mstMultiple2And4.getContainedTypes().add(mat2);
		mstMultiple2And4.getContainedTypes().add(mat4);
		mstMultiple4And5.getContainedTypes().add(mat4);
		mstMultiple4And5.getContainedTypes().add(mat5);
		
	}

	@Test
	public void atomicTypeLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		// Identitaet
		assertEquals(mTrue, mat1.lessOrEqual(mat1));
		// Vererbung eine Ebene
		assertEquals(mTrue, mat1.lessOrEqual(mat2));
		assertEquals(mFalse, mat2.lessOrEqual(mat1));
		// Vererbung zwei Ebenen
		assertEquals(mTrue, mat1.lessOrEqual(mat3));
		assertEquals(mFalse, mat3.lessOrEqual(mat1));
		// voneinander unabhaengig
		assertEquals(mFalse, mat4.lessOrEqual(mat1));
	}

	@Test
	public void atomicTypeLessOrEqualThanProductType() throws PersistenceException, CycleException {
		// leeres Produkt
		assertEquals(mFalse, mat1.lessOrEqual(mptEmpty));
		// Einwertige Produkte
		assertEquals(mTrue, mat2.lessOrEqual(mptSingle2));
		assertEquals(mTrue, mat1.lessOrEqual(mptSingle2));
		assertEquals(mFalse, mat1.lessOrEqual(mptSingle4));
		// Mehrwertige Produkte
		assertEquals(mFalse, mat2.lessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mat5.lessOrEqual(mptMultiple2And4));
		assertEquals(mFalse, mat1.lessOrEqual(mptMultiple2And4));
	}

	@Test
	public void atomicTypeLessOrEqualThanSumType() throws PersistenceException, CycleException {
		// Einwertige Summen
		assertEquals(mTrue, mat2.lessOrEqual(mstSingle2));
		assertEquals(mTrue, mat1.lessOrEqual(mstSingle2));
		assertEquals(mFalse, mat4.lessOrEqual(mstSingle2));
		// Mehrwertige Summen
		assertEquals(mTrue, mat5.lessOrEqual(mstMultiple4And5));
		assertEquals(mFalse, mat1.lessOrEqual(mstMultiple4And5));
		assertEquals(mTrue, mat1.lessOrEqual(mstMultiple2And4));
	}
}