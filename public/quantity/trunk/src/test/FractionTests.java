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

	public void testToRational() throws Exception {
		Fraction bruch1 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(2));
		assertEquals(BigInteger.valueOf(5), bruch1.getEnumerator());
		assertEquals(BigInteger.valueOf(1), bruch1.getDenominator());

		Fraction bruch2 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(3));
		assertEquals(BigInteger.valueOf(10), bruch2.getEnumerator());
		assertEquals(BigInteger.valueOf(3), bruch2.getDenominator());
	}

	public void testFractionMul01() throws Throwable {
		Fraction bruch1 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(2));
		Fraction bruch2 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(2));
		// Funktion mul testen
		Fraction multFraction = bruch1.mul(bruch2);
		assertEquals(BigInteger.valueOf(25), multFraction.getEnumerator());
		assertEquals(BigInteger.valueOf(1), multFraction.getDenominator());
	}

	public void testFractionMul02() throws Throwable {
		Fraction fraction1 = new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(2));
		Fraction fraction2 = new Fraction(BigInteger.valueOf(2),BigInteger.valueOf(3));
		
		Fraction result = fraction1.mul(fraction2);
		assertEquals(BigInteger.valueOf(1), result.getEnumerator());
		assertEquals(BigInteger.valueOf(3), result.getDenominator());
	}

	public void testFractionToRational() throws Exception {
		Fraction bruch1 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(2));
		Fraction bruch2 = new Fraction(BigInteger.valueOf(3),BigInteger.valueOf(9));

		// Funktion toRational testen
		assertEquals(BigInteger.valueOf(5), bruch1.getEnumerator());
		assertEquals(BigInteger.valueOf(1), bruch1.getDenominator());
		assertEquals(BigInteger.valueOf(1), bruch2.getEnumerator());
		assertEquals(BigInteger.valueOf(3), bruch2.getDenominator());
	}

	public void testFractionAdd() throws Throwable {
		Fraction bruch1 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(2));
		Fraction bruch2 = new Fraction(BigInteger.valueOf(10),BigInteger.valueOf(3));
		
		// Funktion add testen
		Fraction multFraction = bruch1.add(bruch2);
		assertEquals(BigInteger.valueOf(25), multFraction.getEnumerator());
		assertEquals(BigInteger.valueOf(3), multFraction.getDenominator());
	}


}
