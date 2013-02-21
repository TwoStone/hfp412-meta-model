
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
		Fraction fraction = Fraction.parse("2/10");
		assertNotNull(fraction);
	}

	@Test
	public void testFractionCreateConst() throws Exception {
		Fraction fraction = new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(2));
		assertNotNull(fraction);
	}

	@Test
	public void testSimple1() throws Exception {
		Fraction bruch1 = Fraction.parse("10/1");
		assertEquals("10", bruch1.toString());
	}

	@Test
	public void testSimple2() throws Exception {
		Fraction bruch1 = Fraction.parse("10");
		assertEquals("10", bruch1.toString());
	}

	@Test
	public void testToRational() throws Exception {
		Fraction bruch1 = Fraction.parse("10/2");
		assertEquals(Fraction.parse("5/1"), bruch1);

		Fraction bruch2 = Fraction.parse("10/3");
		assertEquals(Fraction.parse("10/3"), bruch2);
	}

	@Test
	public void testFractionMul01() throws Throwable {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("10/2");
		// Funktion mul testen
		Fraction multFraction = bruch1.mul(bruch2);
		assertEquals(Fraction.parse("25/1"), multFraction);
	}

	@Test
	public void testFractionMul02() throws Throwable {
		Fraction fraction1 = Fraction.parse("1/2");
		Fraction fraction2 = Fraction.parse("2/3");

		Fraction result = fraction1.mul(fraction2);
		assertEquals(Fraction.parse("1/3"), result);
	}

	@Test
	public void testFractionToRational() throws Exception {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("3/9");
		assertEquals(Fraction.parse("5/1"), bruch1);
		assertEquals(Fraction.parse("1/3"), bruch2);
	}

	@Test
	public void testFractionAdd() throws Throwable {
		Fraction bruch1 = Fraction.parse("10/2");
		Fraction bruch2 = Fraction.parse("10/3");

		// Funktion add testen
		Fraction multFraction = bruch1.add(bruch2);
		assertEquals(Fraction.parse("25/3"), multFraction);
	}

	@Test
	public void testFractionDivisionByZero() {
		try {
			Fraction.parse("10/0");
			fail();
		} catch (NumberFormatException e) {
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO, e.getMessage());
		}
	}

	@Test
	public void testFractionDivisionByZeroConst() {
		try {
			new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(0));
			fail();
		} catch (NumberFormatException e) {
			assertEquals(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO, e.getMessage());
		}
	}

	@Test
	public void testFractionDivision_1() throws Throwable {
		Fraction frac1 = Fraction.parse("6/1");
		Fraction frac2 = Fraction.parse("2/1");

		Fraction result = frac1.div(frac2);
		assertEquals(Fraction.parse("3/1"), result);
	}

	@Test
	public void testFractionDivision_2() throws Throwable {
		Fraction frac1 = Fraction.parse("3/2");
		Fraction frac2 = Fraction.parse("1/2");

		Fraction result = frac1.div(frac2);
		assertEquals(Fraction.parse("3/1"), result);
	}

	@Test
	public void testFractionSub_1() throws Throwable {
		Fraction frac1 = Fraction.parse("25/3");
		Fraction frac2 = Fraction.parse("10/2");

		// Funktion add testen
		Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("10/3"), result);
	}

	@Test
	public void testFractionSub_2() throws Throwable {
		Fraction frac1 = Fraction.parse("2/1");
		Fraction frac2 = Fraction.parse("1/1");

		// Funktion add testen
		Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("1/1"), result);
	}

	@Test
	public void testFractionSub_3() throws Throwable {
		Fraction frac1 = Fraction.parse("3/4");
		Fraction frac2 = Fraction.parse("7/8");

		// Funktion add testen
		Fraction result = frac1.sub(frac2);
		assertEquals(Fraction.parse("-1/8"), result);
	}
}
