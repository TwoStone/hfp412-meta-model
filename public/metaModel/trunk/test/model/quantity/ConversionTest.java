/**
 * 
 */
package model.quantity;

import model.ConsistencyException;
import model.CycleException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentConversion;
import persistence.PersistentFunction;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import util.TestingBase;

import common.Fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testet die Klasse Conversion
 * 
 */
public class ConversionTest extends TestingBase {
	private PersistentUnitType type;
	private PersistentUnit unit;
	private PersistentUnit defaultUnit;
	private PersistentFunction function;

	public ConversionTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Before
	public void furtherSetup() throws NoSuchFieldException, IllegalAccessException {
		resetSingleton(QuantityManager.class);
		resetSingleton(FractionManager.class);
	}

	private void initObjects() throws Exception {
		type = UnitType.createUnitType("TestType");
		unit = Unit.createUnit(type, "TestUnit");
		defaultUnit = Unit.createUnit(type, "TestDefaultUnit");
		type.setDefaultUnit(defaultUnit);
		function = Function.createFunction(Fraction.parse("7"), Fraction.parse("3"));
	}

	@Test
	public void testCreate() throws Exception {
		this.initObjects();
		final PersistentConversion c = Conversion.createConversion(unit, function);
		assertNotNull(c);
	}

	/**
	 * Test method for {@link model.quantity.Conversion#convert(common.Fraction)}.
	 * 
	 * @throws PersistenceException
	 */
	@Test
	public void testConvert() throws Exception {
		this.initObjects();
		final PersistentConversion c = Conversion.createConversion(unit, function);
		final PersistentQuantity convertedAmount = c.convert(Fraction.parse("4"));
		assertEquals(this.defaultUnit, convertedAmount.getUnit());
		assertEquals("31", convertedAmount.getAmount().toString());
	}

	/**
	 * Test method for {@link model.quantity.Conversion#convertInverse(common.Fraction)}.
	 */
	@Test
	public void testConvertInverse() throws Exception {
		this.initObjects();
		final PersistentConversion c = Conversion.createConversion(unit, function);
		final PersistentQuantity convertedAmount = c.convertInverse(Fraction.parse("4"));
		assertEquals(this.unit, convertedAmount.getUnit());
		assertEquals("1/7", convertedAmount.getAmount().toString());
	}

}
