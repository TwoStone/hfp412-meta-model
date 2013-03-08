package model.quantity.conversion;

import model.ConsistencyException;
import model.CycleException;
import model.quantity.Unit;
import model.quantity.UnitType;
import model.quantity.UnitTypeManager;

import org.junit.Assert;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.TestingBase;

import common.Fraction;

public class SetConversionTest extends TestingBase {

	public SetConversionTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test(expected = ConsistencyException.class)
	public void testSetConversionWithoutDefaultUnit() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");

		utm.setConversion(unitKg, Fraction.parse("1"), Fraction.parse("0")); // Fehler
	}

	@Test
	public void testSetDefaultConversion() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);

		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		utm.setDefaultUnit(unitTypeGewicht, unitKg);

		// UnitTypeManager.getTheUnitTypeManager().setConversion(unitKg, Fraction.parse("1"), Fraction.parse("0"));

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitKg.getMyConversion()
				.getMyFunction().getFactor());
		Assert.assertEquals("Conversion weist eine falsche Konstante auf", Fraction.parse("0"), unitKg
				.getMyConversion().getMyFunction().getConstant());
	}

	@Test
	public void testChangeDefaultUnit() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);

		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		PersistentUnit unitG = Unit.createUnit(unitTypeGewicht, "g");

		// Default: g
		// Conversion: 1g = 1g
		utm.setDefaultUnit(unitTypeGewicht, unitG);

		// Conversion für kg (1g = 1/1000g)
		utm.setConversion(unitKg, Fraction.parse("1/1000"), Fraction.parse("0"));

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1/1000"), unitKg
				.getMyConversion().getMyFunction().getFactor());

		// Default: kg
		utm.setDefaultUnit(unitTypeGewicht, unitKg);

		// Conversions wurden angepasst?
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitKg.getMyConversion()
				.getMyFunction().getFactor());

		// Wurde die g-Conversion auf 1kg = 1000g gesetzt?
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1000"), unitG
				.getMyConversion().getMyFunction().getFactor());

	}

	@Test
	public void testChangeDefaultUnitToConversionlessUnit() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);

		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitT = Unit.createUnit(unitTypeGewicht, "T");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		PersistentUnit unitG = Unit.createUnit(unitTypeGewicht, "g");
		utm.setDefaultUnit(unitTypeGewicht, unitKg);

		UnitTypeManager.getTheUnitTypeManager().setConversion(unitG, Fraction.parse("1000"), Fraction.parse("0"));

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitKg.getMyConversion().getMyFunction()
				.getFactor());

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1000"), unitG.getMyConversion().getMyFunction()
				.getFactor());

		utm.setDefaultUnit(unitTypeGewicht, unitT); // Conversionless Unit

		Assert.assertEquals("Conversion weist einen falschen Factor auf", null, unitKg.getMyConversion());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", null, unitG.getMyConversion());

	}

	@Test
	public void testChangeDefaultUnitConstant() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);

		PersistentUnitType unitTypeTemp = UnitType.createUnitType("Temperatur");
		PersistentUnit unitC = Unit.createUnit(unitTypeTemp, "Celsius");
		PersistentUnit unitK = Unit.createUnit(unitTypeTemp, "Kelvin");

		utm.setDefaultUnit(unitTypeTemp, unitC);

		UnitTypeManager.getTheUnitTypeManager().setConversion(unitK, Fraction.parse("1"), Fraction.parse("273"));


		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitK.getMyConversion().getMyFunction()
				.getFactor());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("273"), unitK.getMyConversion().getMyFunction()
				.getConstant());

		utm.setDefaultUnit(unitTypeTemp, unitK); // Conversionless Unit

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitC.getMyConversion().getMyFunction().getFactor());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("-273"), unitC.getMyConversion().getMyFunction().getConstant());

	}

	@Test
	public void testChangeDefaultUnitFactorAndConstant() throws PersistenceException, ConsistencyException {
		PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);

		PersistentUnitType unitType = UnitType.createUnitType("Type");
		PersistentUnit unitA = Unit.createUnit(unitType, "A");
		PersistentUnit unitB = Unit.createUnit(unitType, "B");
		PersistentUnit unitC = Unit.createUnit(unitType, "C");

		utm.setDefaultUnit(unitType, unitA);

		UnitTypeManager.getTheUnitTypeManager().setConversion(unitB, Fraction.parse("2"), Fraction.parse("1"));
		UnitTypeManager.getTheUnitTypeManager().setConversion(unitC, Fraction.parse("3"), Fraction.parse("2"));

		utm.setDefaultUnit(unitType, unitB);

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1/2"), unitA.getMyConversion().getMyFunction().getFactor());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("-1/2"), unitA.getMyConversion().getMyFunction().getConstant());

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1"), unitB.getMyConversion().getMyFunction().getFactor());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("0"), unitB.getMyConversion().getMyFunction().getConstant());

		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("3/2"), unitC.getMyConversion().getMyFunction().getFactor());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", Fraction.parse("1/2"), unitC.getMyConversion().getMyFunction().getConstant());
	}
}
