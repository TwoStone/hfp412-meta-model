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
		Fraction fraction = Fraction.parse("2/10");
		assertNotNull(fraction);
	}
	
	public void testFractionCreateConst() throws Exception {
		Fraction fraction = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(2));
		assertNotNull(fraction);
	}

	public void testToRational() throws Exception {
		Fraction bruch1 = Fraction.parse("10/2");
		assertEquals(Fraction.parse("5/1"), bruch1);

		Fraction bruch2 = Fraction.parse("10/3");
		assertEquals(Fraction.parse("10/3"), bruch2);
	}

	public void testFractionMul01() throws Throwable {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("10/2");
		// Funktion mul testen
		Fraction multFraction = bruch1.mul(bruch2);
		assertEquals(Fraction.parse("25/1"), multFraction);
	}

	public void testFractionMul02() throws Throwable {
		Fraction fraction1 = Fraction.parse("1/2");
		Fraction fraction2 = Fraction.parse("2/3");
		
		Fraction result = fraction1.mul(fraction2);
		assertEquals(Fraction.parse("1/3"), result);
	}

	public void testFractionToRational() throws Exception {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("3/9");
		assertEquals(Fraction.parse("5/1"), bruch1);
		assertEquals(Fraction.parse("1/3"), bruch2);
	}

	public void testFractionAdd() throws Throwable {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("10/3");
		
		// Funktion add testen
		Fraction multFraction = bruch1.add(bruch2);
		assertEquals(Fraction.parse("25/3"), multFraction);
	}
	
	public void testFractionDivisionByZero() {
		try{
			Fraction.parse("10/0");
			fail();
		}
		catch (NumberFormatException e){
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO,	e.getMessage());
		}
	}
	
	public void testFractionDivisionByZeroConst() {
		try{
			new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(0));
			fail();
		}
		catch (NumberFormatException e){
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO,	e.getMessage());
		}
	}
	


}
