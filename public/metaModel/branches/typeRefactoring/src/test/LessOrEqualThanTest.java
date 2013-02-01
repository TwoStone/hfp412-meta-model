package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import test.util.AbstractTest;

public class LessOrEqualThanTest extends AbstractTest {

	public LessOrEqualThanTest() throws PersistenceException, CycleException {
		super();
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