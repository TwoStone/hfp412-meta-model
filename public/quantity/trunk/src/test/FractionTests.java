package test;

import java.math.BigInteger;

import junit.framework.TestCase;

import common.Fraction;

public class FractionTests extends TestCase {

	@Override
	public void setUp() {
		try {
			ZZ_TestHelper.initializeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tearDown() {
		try {
			ZZ_TestHelper.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void testFractionCreate() throws Exception {
		Fraction fraction = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(10));
		assertNotNull(fraction);
	}
/*
	public void testToRational() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction(10,2);
		assertEquals(5, bruch1.toRational().getEnumerator());
		assertEquals(1, bruch1.toRational().getDenominator());

		PersistentFraction bruch2 = model.Fraction.createFraction(10,3);
		assertEquals(10, bruch2.toRational().getEnumerator());
		assertEquals(3, bruch2.toRational().getDenominator());
	}

	public void testFractionMul01() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction(10,2);
		PersistentFraction bruch2 = model.Fraction.createFraction(10,2);
		// Funktion mul testen
		PersistentFraction multFraction = bruch1.mul(bruch2);
		assertEquals(25, multFraction.getEnumerator());
		assertEquals(1, multFraction.getDenominator());
	}

	public void testFractionMul02() throws Exception {
		PersistentFraction fraction1 = model.Fraction.createFraction(1,2);
		PersistentFraction fraction2 = model.Fraction.createFraction(2,3);

		PersistentFraction result = fraction1.mul(fraction2);
		assertEquals(1, result.getEnumerator());
		assertEquals(3, result.getDenominator());
	}

	public void testFractionToRational() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction(10,2);
		PersistentFraction bruch2 = model.Fraction.createFraction(3,9);

		// Funktion toRational testen
		assertEquals(5, bruch1.toRational().getEnumerator());
		assertEquals(1, bruch1.toRational().getDenominator());
		assertEquals(1, bruch2.toRational().getEnumerator());
		assertEquals(3, bruch2.toRational().getDenominator());
	}

	public void testFractionAdd() throws Exception {
		PersistentFraction bruch1 = model.Fraction.createFraction(10,2);
		PersistentFraction bruch2 = model.Fraction.createFraction(10,3);
		
		// Funktion add testen
		PersistentFraction multFraction = bruch1.add(bruch2);
		assertEquals(25, multFraction.getEnumerator());
		assertEquals(3, multFraction.getDenominator());
	}

	public void testFractionNennerNull() throws Exception {
		try {
			model.Fraction.createFraction(3,0);
			fail();
		} catch (PersistenceException e) {
			assertEquals(constants.ExceptionConstants.NENNER_IST_0,	e.getMessage());
		}
	}
*/
}
