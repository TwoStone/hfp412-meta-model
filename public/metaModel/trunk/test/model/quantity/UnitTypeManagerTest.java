/**
 * 
 */
package model.quantity;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.TestingBase;
import constants.ExceptionConstants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Testet den UnitTypeManager
 * 
 */
public class UnitTypeManagerTest extends TestingBase {

	public UnitTypeManagerTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	/**
	 * Testet das Erstellen von UnitTypes.
	 */
	@Test
	public void testCreateUnitType() {

		try {

			final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
			final String name = "Temperatur";
			final long currentLength = typeManager.getUnitTypes().getLength();
			try {
				typeManager.createUnitType(name);
				assertEquals("Es sollte nur einen UnitType geben.", currentLength + 1, typeManager.getUnitTypes()
						.getLength());
			} catch (final DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}

			try {
				typeManager.createUnitType(name);
				fail("Temperatur doppelt definiert, fehlende DoubleDefinitionExcpetion!");
			} catch (final DoubleDefinitionException e) {
				// Exception korrekt!
				assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION, e.getMessage());
			}
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}

	/**
	 * Testet das Erstellen von Units.
	 */
	@Test
	public void testCreateUnit() {
		try {
			final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
			final String unitTypeName = "Laenge";
			try {
				typeManager.createUnitType(unitTypeName);
			} catch (final DoubleDefinitionException e) {
				// UnitType Temperatur ggf. schon aus vorherigem Testfall vorhanden.
			}
			final PersistentUnitType unitType = (PersistentUnitType) AbsUnitType.getAbsUnitTypeByName(unitTypeName)
					.iterator().next();
			final String unitName = "Meter";
			try {
				typeManager.createUnit(unitName, unitType);
				assertEquals("Es sollte nur eine Unit geben.", 1, typeManager.getUnits().getLength());
			} catch (final DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}

			try {
				typeManager.createUnit(unitName, unitType);
				fail("Temperatur doppelt definiert, fehlende DoubleDefinitionExcpetion!");
			} catch (final DoubleDefinitionException e) {
				// Exception korrekt!
				assertEquals(ExceptionConstants.DOUBLE_UNIT_DEFINITION + unitName, e.getMessage());
			}

		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}

	/**
	 * Testet das Hinzuf�gen einer DefaultUnit.
	 */
	@Test
	public void testAddDefaultUnit() {
		// TODO Test schreiben!
	}

	/**
	 * Testet das Erstellen und abschließen einer Compound Unit Nachbedingungen: Name gesetzt, |Refs| = 0, isFinal =
	 * false
	 */
	@Test
	public void testCreateCompoundUnitType() {
		// TODO Test schreiben
	}

	@Test
	public void testCreateCompoundUnitTypeSpeedExample() {
		// TODO: Test schreiben
		try {
			final PersistentUnitTypeManager utm = this.getManager(UnitTypeManager.class);
			final String nameOfLength = "Length";
			final String nameOfTime = "Time";
			final String nameOfSpeed = "Speed";
			try {
				utm.createUnitType(nameOfLength);
				utm.createUnitType(nameOfTime);
				// utm.createCompUnitType(nameOfSpeed);
				final PersistentUnitType length = (PersistentUnitType) AbsUnitType.getAbsUnitTypeByName(nameOfLength)
						.iterator().next();
				final PersistentUnitType time = (PersistentUnitType) AbsUnitType.getAbsUnitTypeByName(nameOfTime)
						.iterator().next();
				final PersistentCompUnitType speed = (PersistentCompUnitType) AbsUnitType
						.getAbsUnitTypeByName(nameOfSpeed).iterator().next();
				// assertFalse(this.isTrue(speed.isFinal()));
				utm.addReferenceType(nameOfSpeed, speed, length, 1);
				utm.addReferenceType(nameOfSpeed, speed, time, -1);
				// assertFalse(this.isTrue(speed.isFinal()));
				// speed.finishModeling();sertTrue(this.isTrue(speed.isFinal()));

			} catch (final DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}

	/**
	 * Testet das Erstellen eines CompoundUnitTypes. Eine CompoundUnit darf erstellt werden k�nnen.
	 */
	@Test
	public void testCreateCompoundUnit() {
		// TODO : Test schreiben!
	}

}
