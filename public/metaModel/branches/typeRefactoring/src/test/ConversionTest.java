/**
 * 
 */
package test;

import model.CycleException;
import model.quantity.Conversion;
import model.quantity.Function;
import model.quantity.Unit;
import model.quantity.UnitType;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentConversion;
import persistence.PersistentFunction;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import test.util.AbstractTest;

import common.Fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Steffi
 * 
 */
public class ConversionTest extends AbstractTest {
	private final PersistentUnitType type;
	private final PersistentUnit unit;
	private final PersistentUnit defaultUnit;
	private final PersistentFunction function;

	public ConversionTest() throws CycleException, PersistenceException {
		super();
		type = UnitType.createUnitType("TestType");
		unit = Unit.createUnit(type, "TestUnit");
		defaultUnit = Unit.createUnit(type, "TestDefaultUnit");
		type.setDefaultUnit(defaultUnit);
		function = Function.createFunction(Fraction.parse("7"), Fraction.parse("3"));
	}

	@Test
	public void testCreate() throws Exception {
		PersistentConversion c = Conversion.createConversion(unit, function);
		assertNotNull(c);
	}

	/**
	 * Test method for {@link model.quantity.Conversion#convert(common.Fraction)}.
	 * 
	 * @throws PersistenceException
	 */
	@Test
	public void testConvert() throws Exception {
		PersistentConversion c = Conversion.createConversion(unit, function);
		PersistentQuantity convertedAmount = c.convert(Fraction.parse("4"));
		assertEquals(this.defaultUnit, convertedAmount.getUnit());
		assertEquals("31", convertedAmount.getAmount().toString());
	}

	/**
	 * Test method for {@link model.quantity.Conversion#convertInverse(common.Fraction)}.
	 */
	@Test
	public void testConvertInverse() throws Exception {
		PersistentConversion c = Conversion.createConversion(unit, function);
		PersistentQuantity convertedAmount = c.convertInverse(Fraction.parse("4"));
		assertEquals(this.unit, convertedAmount.getUnit());
		assertEquals("1/7", convertedAmount.getAmount().toString());
	}

}
