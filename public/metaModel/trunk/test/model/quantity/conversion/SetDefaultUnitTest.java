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
import test.util.AbstractTest;

import common.Fraction;

public class SetDefaultUnitTest extends AbstractTest {

	public SetDefaultUnitTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test
	public void setDefaultUnit() throws PersistenceException, ConsistencyException {
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");

		UnitTypeManager.getTheUnitTypeManager().setDefaultUnit(unitTypeGewicht, unitKg);

		Assert.assertEquals("DefaultUnit wurde nicht (richtig) gesetzt", unitTypeGewicht.getDefaultUnit(), unitKg);
	}

	@Test
	public void setDefaultUnit_ResetConversions() throws PersistenceException, ConsistencyException {
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");
		PersistentUnit unitG = Unit.createUnit(unitTypeGewicht, "g");

		UnitTypeManager.getTheUnitTypeManager().setDefaultUnit(unitTypeGewicht, unitKg);
		UnitTypeManager.getTheUnitTypeManager().setConversion(unitG, Fraction.parse("1000"), Fraction.parse("0"));

		// TODO fertigstellen

		Assert.assertEquals("", unitTypeGewicht, unitTypeGewicht);
	}

}
