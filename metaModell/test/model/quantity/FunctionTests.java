package model.quantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentFunction;
import util.TestingBase;

import common.Fraction;

public class FunctionTests extends TestingBase {

	public FunctionTests() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test
	public void testFunctionCreate() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("1"), Fraction.parse("1"));
		assertNotNull(f);
	}

	// f(x):=x*factor+constant
	// y=5*1+1
	@Test
	public void testFunctionExecute1() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("1"), Fraction.parse("1"));
		Fraction y = f.execute(Fraction.parse("5"));
		assertEquals("6", y.toString());
	}

	// f(x):=x*factor+constant
	// y=4*7+3
	@Test
	public void testFunctionExecute2() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("7"), Fraction.parse("3"));
		Fraction y = f.execute(Fraction.parse("4"));
		assertEquals("31", y.toString());
	}

	// 1 EUR = 1,2966 USD | 2 EUR -> 2,5932 USD
	@Test
	public void testFunctionExecute3() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("12966/10000"), Fraction.parse("0"));
		Fraction y = f.execute(Fraction.parse("2"));
		assertEquals(Fraction.parse("25932/10000").toString(), y.toString()); // 6483/2500
	}

	// 2,5932 USD -> 2 EUR
	@Test
	public void testFunctionExecuteInv3() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("10000/12966"), Fraction.parse("0"));
		Fraction y = f.execute(Fraction.parse("25932/10000"));
		assertEquals(Fraction.parse("2").toString(), y.toString()); // 6483/2500
	}

	@Test
	public void testFunctionExecuteAndInv1() throws Exception {
		PersistentFunction f = Function.createFunction(Fraction.parse("10000/12966"), Fraction.parse("0"));
		Fraction x = Fraction.parse("6483/2500");
		Fraction y = f.execute(x);
		Fraction z = f.executeInverse(y);
		assertEquals(x, z);
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

}
