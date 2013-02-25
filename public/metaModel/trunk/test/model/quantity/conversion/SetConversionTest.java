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

		Assert.assertEquals("Conversion weist einen falschen Factor auf", unitKg.getMyConversion().getMyFunction()
				.getFactor(), Fraction.parse("1"));

		Assert.assertEquals("Conversion weist einen falschen Factor auf", unitG.getMyConversion().getMyFunction()
				.getFactor(), Fraction.parse("1000"));

		utm.setDefaultUnit(unitTypeGewicht, unitT); // Conversionless Unit

		Assert.assertEquals("Conversion weist einen falschen Factor auf", null, unitKg.getMyConversion());
		Assert.assertEquals("Conversion weist einen falschen Factor auf", null, unitG.getMyConversion());

	}
}
