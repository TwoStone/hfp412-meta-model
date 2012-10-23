package test;

import junit.framework.TestCase;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentFraction;

public class Fraction extends TestCase {

	public void setUp() {
		try {
			ZZ_TestHelper.initializeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		try {
			ZZ_TestHelper.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void testFractionCreate() throws Exception {
		PersistentFraction fraction = model.Fraction.createFraction();
		fraction.setEnumerator(2);
		fraction.setDenominator(10);
		assertNotNull(fraction);
	}

	public void testToRational() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction();
		bruch1.setEnumerator(10);
		bruch1.setDenominator(2);
		
		assertEquals(5, bruch1.toRational().getEnumerator());
		assertEquals(1, bruch1.toRational().getDenominator());

		PersistentFraction bruch2 = model.Fraction.createFraction();
		bruch2.setEnumerator(10);
		bruch2.setDenominator(3);
		assertEquals(10, bruch2.toRational().getEnumerator());
		assertEquals(3, bruch2.toRational().getDenominator());
	}

	public void testFractionMul01() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction();
		bruch1.setEnumerator(10);
		bruch1.setDenominator(2);
		PersistentFraction bruch2 = model.Fraction.createFraction();
		bruch2.setEnumerator(10);
		bruch2.setDenominator(2);
		// Funktion mul testen
		PersistentFraction multFraction = bruch1.mul(bruch2);
		assertEquals(25, multFraction.getEnumerator());
		assertEquals(1, multFraction.getDenominator());
	}

	public void testFractionMul02() {
		try {
			PersistentFraction fraction1 = model.Fraction.createFraction();
			fraction1.setEnumerator(1);
			fraction1.setDenominator(2);

			PersistentFraction fraction2 = model.Fraction.createFraction();
			fraction2.setEnumerator(2);
			fraction2.setDenominator(3);

			PersistentFraction result = fraction1.mul(fraction2);
			assertEquals(1, result.getEnumerator());
			assertEquals(3, result.getDenominator());

		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testFractionToRational() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction();
		bruch1.setEnumerator(10);
		bruch1.setDenominator(2);
		PersistentFraction bruch2 = model.Fraction.createFraction();
		bruch2.setEnumerator(3);
		bruch2.setDenominator(9);

		// Funktion toRational testen
		assertEquals(5, bruch1.toRational().getEnumerator());
		assertEquals(1, bruch1.toRational().getDenominator());
		assertEquals(1, bruch2.toRational().getEnumerator());
		assertEquals(3, bruch2.toRational().getDenominator());
	}

	public void testFractionAdd() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction(); // 30/6
		bruch1.setEnumerator(10);
		bruch1.setDenominator(2);
		PersistentFraction bruch2 = model.Fraction.createFraction(); // 20/6
		bruch2.setEnumerator(10);
		bruch2.setDenominator(3);
		
		// Funktion add testen
		PersistentFraction multFraction = bruch1.add(bruch2);
		assertEquals(25, multFraction.getEnumerator());
		assertEquals(3, multFraction.getDenominator());
	}

	public void testFractionNennerNull() throws Exception {
		try {
			PersistentFraction fraction = model.Fraction.createFraction();
			fraction.setEnumerator(3);
			fraction.setDenominator(0);
			fail();
		} catch (PersistenceException e) {
			assertEquals(constants.ExceptionConstants.NENNER_IST_0,
					e.getMessage());
		}
	}

}
