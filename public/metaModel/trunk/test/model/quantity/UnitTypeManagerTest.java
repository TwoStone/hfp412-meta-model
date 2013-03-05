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
import persistence.PersistentReferenceType;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.ReferenceTypeSearchList;
import util.TestingBase;
import constants.ExceptionConstants;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
				// UnitType Laenge ggf. schon aus vorherigem Testfall vorhanden.
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
				fail("Meter doppelt definiert, fehlende DoubleDefinitionExcpetion!");
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
	public void testSetDefaultUnit() {
		// TODO Test schreiben!
	}

	/**
	 * Testet das Erstellen eines Compound Unit Type
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

	/**
	 * Testet die Methode fetchCompUnitTypeWithReferenceTypes
	 */
	@Test
	public void testGetExistinCUT() {
		try {
			final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
			final PersistentUnitType length = UnitType.createUnitType("Laenge");
			final PersistentReferenceType lengthRef = ReferenceType.createReferenceType(1, length);
			final PersistentUnitType time = UnitType.createUnitType("Zeit");
			final PersistentReferenceType timeRef = ReferenceType.createReferenceType(-1, time);
			final ReferenceTypeSearchList refTypes = new ReferenceTypeSearchList();
			refTypes.add(timeRef);
			refTypes.add(lengthRef);

			// Testen ohne erstellten CompUnitType
			PersistentCompUnitType existingCompUnitType = typeManager.getExistingCUT(refTypes);
			assertNull("Es sollte kein CompUnitType mit diesen Referenzen existieren.", existingCompUnitType);

			final PersistentCompUnitType lengthTimeCompUnit = CompUnitType.createCompUnitType("Laenge/Zeit");
			lengthTimeCompUnit.getRefs().add(lengthRef);
			lengthTimeCompUnit.getRefs().add(timeRef);

			// Testen nach erstellen des CompUnitType
			existingCompUnitType = typeManager.getExistingCUT(refTypes);
			assertNotNull("Es sollte ein CompUnitType mit diesen Referenzen existieren.", existingCompUnitType);

		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}

	@Test
	public void testFetchScalarType() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		try {
			final PersistentCompUnitType scalarType = typeManager.fetchScalarType();
			assertTrue("Referenz-Liste von scalarType sollte leer sein.", scalarType.getRefs().getLength() == 0);
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}
}
