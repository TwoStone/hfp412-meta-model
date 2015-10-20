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

public class SetDefaultUnitTest extends TestingBase {

	public SetDefaultUnitTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test
	public void setDefaultUnit() throws PersistenceException, ConsistencyException {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		
		typeManager.setDefaultUnit(unitTypeGewicht, unitKg);

		Assert.assertEquals("DefaultUnit wurde nicht (richtig) gesetzt", unitTypeGewicht.getDefaultUnit(), unitKg);
	}

	@Test
	public void setDefaultUnit_ResetConversions() throws PersistenceException, ConsistencyException {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		PersistentUnit unitG = Unit.createUnit(unitTypeGewicht, "g");

		typeManager.setDefaultUnit(unitTypeGewicht, unitKg);
		typeManager.setConversion(unitG, Fraction.parse("1000"), Fraction.parse("0"));

		Assert.assertEquals("", unitTypeGewicht, unitTypeGewicht);
	}

	@Test
	public void setDefaultUnit_DeleteConversions() throws PersistenceException, ConsistencyException {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		PersistentUnit unitG = Unit.createUnit(unitTypeGewicht, "g");
		PersistentUnit unitT = Unit.createUnit(unitTypeGewicht, "T");

		typeManager.setDefaultUnit(unitTypeGewicht, unitKg);
		typeManager.setConversion(unitG, Fraction.parse("1000"), Fraction.parse("0"));
		
		typeManager.setDefaultUnit(unitTypeGewicht, unitT);

		Assert.assertEquals("unitG Conversion sollte null sein", null, unitG.getMyConversion());
		Assert.assertEquals("unitKg Conversion sollte null sein", null, unitKg.getMyConversion());
		

		typeManager.setDefaultUnit(unitTypeGewicht, unitKg);

		Assert.assertEquals("unitT Conversion sollte null sein", null, unitG.getMyConversion());
		Assert.assertEquals("unitKg Conversion sollte null sein", null, unitT.getMyConversion());
	}
}
