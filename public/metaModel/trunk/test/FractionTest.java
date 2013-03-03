import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import model.ConsistencyException;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import util.TestingBase;

import common.Fraction;

public class FractionTest extends TestingBase {

	public FractionTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test
	public void testFractionCreate() throws Exception {
		final Fraction fraction = Fraction.parse("2/10");
		assertNotNull(fraction);
	}

	@Test
	public void testFractionCreateConst() throws Exception {
		final Fraction fraction = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(2));
		assertNotNull(fraction);
	}

	@Test
	public void testSimple1() throws Exception {
		final Fraction bruch1 = Fraction.parse("10/1");
		assertEquals("10", bruch1.toString());
	}

	@Test
	public void testSimple2() throws Exception {
		final Fraction bruch1 = Fraction.parse("10");
		assertEquals("10", bruch1.toString());
	}

	@Test
	public void testToRational() throws Exception {
		final Fraction bruch1 = Fraction.parse("10/2");
		assertEquals(Fraction.parse("5/1"), bruch1);

		final Fraction bruch2 = Fraction.parse("10/3");
		assertEquals(Fraction.parse("10/3"), bruch2);
	}

	@Test
	public void testFractionMul01() throws Throwable {
		final Fraction bruch1 = Fraction.parse("10/2");
		final Fraction bruch2 = Fraction.parse("10/2");
		// Funktion mul testen
		final Fraction multFraction = bruch1.mul(bruch2);
		assertEquals(Fraction.parse("25/1"), multFraction);
	}

	@Test
	public void testFractionMul02() throws Throwable {
		final Fraction fraction1 = Fraction.parse("1/2");
		final Fraction fraction2 = Fraction.parse("2/3");

		final Fraction result = fraction1.mul(fraction2);
		assertEquals(Fraction.parse("1/3"), result);
	}

	@Test
	public void testFractionToRational() throws Exception {
		final Fraction bruch1 = Fraction.parse("10/2");
		final Fraction bruch2 = Fraction.parse("3/9");
		assertEquals(Fraction.parse("5/1"), bruch1);
		assertEquals(Fraction.parse("1/3"), bruch2);
	}

	@Test
	public void testFractionAdd() throws Throwable {
		final Fraction bruch1 = Fraction.parse("10/2");
		final Fraction bruch2 = Fraction.parse("10/3");

		// Funktion add testen
		final Fraction multFraction = bruch1.add(bruch2);
		assertEquals(Fraction.parse("25/3"), multFraction);
	}

	@Test
	public void testFractionDivisionByZero() {
		try {
			Fraction.parse("10/0");
			fail();
		} catch (final NumberFormatException e) {
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO, e.getMessage());
		}
	}

	@Test
	public void testFractionDivisionByZeroConst() {
		try {
			new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(0));
			fail();
		} catch (final NumberFormatException e) {
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO, e.getMessage());
		}
	}

	@Test
	public void testFractionDivision_1() throws Throwable {
		final Fraction frac1 = Fraction.parse("6/1");
		final Fraction frac2 = Fraction.parse("2/1");

		final Fraction result = frac1.div(frac2);
		assertEquals(Fraction.parse("3/1"), result);
	}

	@Test
	public void testFractionDivision_2() throws Throwable {
		final Fraction frac1 = Fraction.parse("3/2");
		final Fraction frac2 = Fraction.parse("1/2");

		final Fraction result = frac1.div(frac2);
		assertEquals(Fraction.parse("3/1"), result);
	}

	@Test
	public void testFractionSub_1() throws Throwable {
		final Fraction frac1 = Fraction.parse("25/3");
		final Fraction frac2 = Fraction.parse("10/2");

		// Funktion add testen
		final Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("10/3"), result);
	}

	@Test
	public void testFractionSub_2() throws Throwable {
		final Fraction frac1 = Fraction.parse("2/1");
		final Fraction frac2 = Fraction.parse("1/1");

		// Funktion add testen
		final Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("1/1"), result);
	}

	@Test
	public void testFractionSub_3() throws Throwable {
		final Fraction frac1 = Fraction.parse("3/4");
		final Fraction frac2 = Fraction.parse("7/8");

		// Funktion add testen
		final Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("-1/8"), result);
	}

	/**
	 * String "1/1" parsen
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFractionParseOneWithStroke() throws Throwable {
		final Fraction onefr = Fraction.parse("1/1");
		final BigInteger onebi = BigInteger.ONE;

		assertTrue(onefr.getDenominator().equals(onebi));
		assertTrue(onefr.getEnumerator().equals(onebi));
	}

	/**
	 * String "1" parsen
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFractionParseOneWithoutStroke() throws Throwable {
		final Fraction onefr = Fraction.parse("1");
		final BigInteger onebi = BigInteger.ONE;

		assertTrue(onefr.getEnumerator().equals(onebi));
	}

	/**
	 * 1 : 1 = 1 testen :0)
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFractionDivOneByOne_1() {
		Fraction one = null;
		try {
			one = Fraction.parse("1").div(Fraction.parse("1"));
		} catch (final Throwable e) {
			fail();
		}

		assertEquals(BigInteger.ONE, one.getEnumerator());
		assertEquals(BigInteger.ONE, one.getDenominator());
	}

	@Test
	public void testInvertSign_1() {
		// TODO: implement testcase
	}
}
