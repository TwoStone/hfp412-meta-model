package test;

import static org.junit.Assert.assertEquals;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;

public class ContainsTypeTest extends AbstractTest {

	public ContainsTypeTest() throws CycleException, PersistenceException {
		super();
	}

	@Test
	public void atomicTypeContainsAtomicType() throws PersistenceException, CycleException {
		// Reflexivitaet
		assertEquals(mTrue, mat1.contains(mat1));
		
		// Nicht contains trotz Vererbung
		assertEquals(mTrue, mat2.contains(mat2));

		
		// Unabhaengig
		assertEquals(mFalse, mat1.contains(mat4));
	}
	
	@Test
	public void atomicTypeContainsProductType() throws PersistenceException, CycleException {
		
		// Schlaegt immer fehl - atomicTypes enthalten keine Produkte
		
		// leeres Produkt
		assertEquals(mFalse, mat1.contains(mptEmpty)); // TODO: Klaerung! False oder True?
		
		// Einwertige Produkte
		assertEquals(mTrue, mat2.contains(mptSingle2));
		assertEquals(mFalse, mat1.contains(mptSingle2));
		assertEquals(mFalse, mat1.contains(mptSingle4));
		// Mehrwertige Produkte
		assertEquals(mFalse, mat2.contains(mptMultiple2And4));
		
		assertEquals(mFalse, mat5.contains(mptMultiple2And4));
		assertEquals(mFalse, mat1.contains(mptMultiple2And4));
	}
	
	@Test
	public void atomicTypeContainsSumType() throws PersistenceException, CycleException {
		
		// Einwertige Summen
		assertEquals(mTrue, mat2.contains(mstSingle2));
		assertEquals(mFalse, mat1.contains(mstSingle2));
		assertEquals(mFalse, mat4.contains(mstSingle2));
		// Mehrwertige Summen
		assertEquals(mTrue, mat5.contains(mstMultiple4And5)); // TODO: Angucken
		assertEquals(mFalse, mat1.contains(mstMultiple4And5));
		assertEquals(mFalse, mat1.contains(mstMultiple2And4));
	}
	
	@Test
	public void productTypeContainsAtomicType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mptEmpty.contains(mat1));

		assertEquals(mFalse, mptSingle2.contains(mat1));
		assertEquals(mTrue, mptSingle2.contains(mat2));
		assertEquals(mFalse, mptSingle2.contains(mat3)); // TODO: Zu klaeren! Spezialisierung im Contains beruecksichtigen?
		assertEquals(mFalse, mptSingle2.contains(mat4));

		assertEquals(mTrue, mptMultiple2And4.contains(mat2));
		assertEquals(mTrue, mptMultiple2And4.contains(mat4));
		assertEquals(mFalse, mptMultiple2And4.contains(mat1));
		assertEquals(mFalse, mptMultiple2And4.contains(mat3)); // Ebenfalls zu klaeren (gleicher Fall)
		assertEquals(mFalse, mptMultiple2And4.contains(mat5));
	}
	

	@Test
	public void productTypeContainsProductType() throws PersistenceException, CycleException {
		// Identitaet
		assertEquals(mTrue, mptEmpty.contains(mptEmpty));
		assertEquals(mTrue, mptSingle2.contains(mptSingle2));
		assertEquals(mTrue, mptMultiple2And4.contains(mptMultiple2And4));

		assertEquals(mTrue, mptSingle2.contains(mptEmpty)); // TODO: Enthaelt jedes Produkt auch das leere Produkt?
		assertEquals(mFalse, mptSingle2.contains(mptSingle3)); // Spezialisierung
		assertEquals(mFalse, mptSingle2.contains(mptSingle1));
		assertEquals(mFalse, mptSingle2.contains(mptSingle4));
		assertEquals(mFalse, mptSingle2.contains(mptMultiple2And4));
		assertEquals(mFalse, mptSingle1.contains(mptMultiple2And4));
		assertEquals(mFalse, mptSingle4.contains(mptMultiple2And4));

		assertEquals(mTrue, mptMultiple2And4.contains(mptEmpty)); // Empty-Klaerung
		assertEquals(mFalse, mptMultiple2And4.contains(mptSingle1));
		assertEquals(mTrue, mptMultiple2And4.contains(mptSingle2));
		assertEquals(mFalse, mptMultiple2And4.contains(mptSingle3)); // Spez
		assertEquals(mTrue, mptMultiple2And4.contains(mptSingle4));
		assertEquals(mTrue, mptMultiple2And4.contains(mptMultiple2And4));
		assertEquals(mTrue, mptMultiple2And4.contains(mptMultiple4And2));
		assertEquals(mFalse, mptMultiple2And4.contains(mptMultiple5And6));
		assertEquals(mFalse, mptMultiple2And4.contains(mptMultiple4And5));
	}
	
	@Test
	public void productTypeContainsSumType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mptEmpty.contains(mstSingle2));
		assertEquals(mTrue, mptSingle2.contains(mstSingle2));
		assertEquals(mFalse, mptSingle2.contains(mstSingle1));
		assertEquals(mFalse, mptSingle2.contains(mstSingle3)); // Spez
		assertEquals(mFalse, mptSingle2.contains(mstSingle4));
		assertEquals(mTrue, mptSingle2.contains(mstMultiple2And4)); // TODO: Klaerung
		assertEquals(mFalse, mptSingle2.contains(mstMultiple4And5));

		assertEquals(mFalse, mptMultiple2And4.contains(mstSingle1));
		assertEquals(mTrue, mptMultiple2And4.contains(mstSingle2));
		assertEquals(mFalse, mptMultiple2And4.contains(mstSingle3));
		assertEquals(mTrue, mptMultiple2And4.contains(mstSingle4));
		assertEquals(mFalse, mptMultiple2And4.contains(mstSingle5));
		assertEquals(mTrue, mptMultiple2And4.contains(mstMultiple2And4));
		assertEquals(mTrue, mptMultiple2And4.contains(mstMultiple4And2));
		assertEquals(mFalse, mptMultiple2And4.contains(mstMultiple5And6));
		assertEquals(mTrue, mptMultiple2And4.contains(mstMultiple2And4And5)); // TODO: Klaerung!
		assertEquals(mTrue, mptMultiple2And4.contains(mstMultiple4And5)); // TODO: Klaerung
		
	}
	
	@Test
	public void sumTypeContainsAtomicType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mstSingle2.contains(mat1));
		assertEquals(mTrue, mstSingle2.contains(mat2));
		assertEquals(mFalse, mstSingle2.contains(mat3)); // Spez
		assertEquals(mFalse, mstSingle2.contains(mat4));
		assertEquals(mFalse, mstSingle1.contains(mat3)); // Spez

		assertEquals(mFalse, mstMultiple2And4.contains(mat1));
		assertEquals(mTrue, mstMultiple2And4.contains(mat2));
		assertEquals(mFalse, mstMultiple2And4.contains(mat3));
		assertEquals(mTrue, mstMultiple2And4.contains(mat4));
		assertEquals(mFalse, mstMultiple2And4.contains(mat5));
	}

	@Test
	public void sumTypeContainsProductType() throws PersistenceException, CycleException {
		assertEquals(mFalse, mstSingle2.contains(mptEmpty)); // TODO: Empty-Klaerung
		assertEquals(mFalse, mstSingle2.contains(mptSingle1));
		assertEquals(mTrue, mstSingle2.contains(mptSingle2));
		assertEquals(mFalse, mstSingle2.contains(mptSingle3));
		assertEquals(mFalse, mstSingle2.contains(mptSingle4));
		assertEquals(mFalse, mstSingle2.contains(mptMultiple2And4));
		assertEquals(mFalse, mstSingle2.contains(mptMultiple5And6));

		assertEquals(mFalse, mstMultiple2And4.contains(mptEmpty)); // TODO: Empty-Klaerung
		assertEquals(mFalse, mstMultiple2And4.contains(mptSingle1));
		assertEquals(mTrue, mstMultiple2And4.contains(mptSingle2));
		assertEquals(mFalse, mstMultiple2And4.contains(mptSingle3));
		assertEquals(mTrue, mstMultiple2And4.contains(mptSingle4));
		assertEquals(mFalse, mstMultiple2And4.contains(mptSingle5));
		assertEquals(mFalse, mstMultiple2And4.contains(mptMultiple2And4)); // Klaeren

		assertEquals(mFalse, mstMultiple2And4And5.contains(mptMultiple2And4));

	}
	

}
