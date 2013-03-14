/**
 * 
 */
package model.quantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.ConsistencyException;
import model.CycleException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentConversion;
import persistence.PersistentFunction;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import util.TestingBase;

import common.Fraction;

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
		final Fraction convertedAmount = c.convert(Fraction.parse("4"));
		assertEquals("31", convertedAmount.toString());
	}

	/**
	 * Test method for {@link model.quantity.Conversion#convertInverse(common.Fraction)}.
	 */
	@Test
	public void testConvertInverse() throws Exception {
		this.initObjects();
		final PersistentConversion c = Conversion.createConversion(unit, function);
		final Fraction convertedAmount = c.convertInverse(Fraction.parse("4"));
		assertEquals("1/7", convertedAmount.toString());
	}

}
