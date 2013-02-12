package model.quantity.conversion;

import model.ConsistencyException;
import model.CycleException;
import model.quantity.Unit;
import model.quantity.UnitType;
import model.quantity.UnitTypeManager;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import test.util.AbstractTest;

import common.Fraction;

public class SetConversionTest extends AbstractTest {

	public SetConversionTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Test(expected = ConsistencyException.class)
	public void addConversionWithoutDefaultUnit() throws PersistenceException, ConsistencyException {
		PersistentUnitType unitTypeGewicht = UnitType.createUnitType("Gewicht");
		PersistentUnit unitKg = Unit.createUnit(unitTypeGewicht, "Kg");

		UnitTypeManager.getTheUnitTypeManager().setConversion(unitKg, Fraction.parse("1"), Fraction.parse("0"));
	}
}
