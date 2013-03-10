/**
 * 
 */
package model.quantity;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnitType;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
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
				assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name, e.getMessage());
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
	 * Testet die korrekte Ausführung der Methode addReferenceType
	 */
	@Test
	public void testAddReferenceType() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		try {
			PersistentUnitType unitType = null;
			try {
				unitType = typeManager.createUnitType("bla");
			} catch (final DoubleDefinitionException e) {
				fail("DoubleDefinitionException: " + e.getMessage());
			}

			// addReferenceType mit schon vorhandenem Namen ausführen
			try {
				typeManager.addReferenceType("bla", unitType, unitType, 1);
				fail("Fehlende DoubleDefinitionException.");
			} catch (final DoubleDefinitionException e) {
				// DoubleDefinitionException korrekt
				assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + "bla", e.getMessage());
			}

			// neuen CompUnitType mit addReference erstellen
			PersistentCompUnitType cut = null;
			try {
				final PersistentAbsUnitType type = typeManager.addReferenceType("cut", unitType, unitType, 1);
				assertTrue("Erstellter UnitType sollte vom Typ CompUnitType sein.",
						type instanceof PersistentCompUnitType);
				cut = (PersistentCompUnitType) type;
				assertTrue("Cut sollte einen ReferenceType haben", cut.getRefs().getLength() == 1);
				final PersistentReferenceType referenceType = cut.getRefs().iterator().next();
				assertTrue("Exponent des ReferenceType sollte 2 sein.", referenceType.getExponent() == 2);
				assertTrue("ReferenceType sollte auf unitType zeigen.", referenceType.getRef().equals(unitType));
			} catch (final DoubleDefinitionException e) {
				fail("DoubleDefinitionException: " + e.getMessage());
			}

			// Schon vorhandenen CompUnitType erstellen mit schon vorhandenem Namen
			try {
				final PersistentAbsUnitType type = typeManager.addReferenceType("bla", unitType, unitType, 1);
				assertEquals("Eben erstellter CompUnitType sollte mit zuvor erstellten übereinstimmen.", type, cut);
			} catch (final DoubleDefinitionException e) {
				fail("DoubleDefinitionException sollte nicht kommen, da CompUnitType nicht neu erstellt wird, weil schon vorhanden. "
						+ e.getMessage());
			}

			// SkalarType durch addReference erstellen
			try {
				final PersistentAbsUnitType scalarType = typeManager.addReferenceType("bla", unitType, unitType, -1);
				assertTrue("scalarType sollte ein CompUnitType sein.", scalarType instanceof PersistentCompUnitType);
				assertTrue("scalarType sollte keine ReferenceTypes haben.", ((PersistentCompUnitType) scalarType)
						.getRefs().getLength() == 0);
			} catch (final DoubleDefinitionException e) {
				fail("DoubleDefinitionException: " + e.getMessage());
			}

			// UnitType durch addReference erstellen
			try {
				final PersistentAbsUnitType type = typeManager.addReferenceType("bla", unitType, unitType, 0);
				assertTrue("Sollte ein UnitType sein", type instanceof PersistentUnitType);
				assertTrue("Sollte mit unitType übereinstimmen.", type.equals(unitType));
			} catch (final DoubleDefinitionException e) {
				fail("DoubleDefinitionException: " + e.getMessage());
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
	public void testGetExistingCUT() {
		try {
			final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
			final PersistentUnitType length = UnitType.createUnitType("Laenge");
			final PersistentReferenceType lengthRef = ReferenceType.createReferenceType(1, length);
			final PersistentUnitType time = UnitType.createUnitType("Zeit");
			final PersistentReferenceType timeRef = ReferenceType.createReferenceType(-1, time);
			final ReferenceTypeSearchList refTypes = new ReferenceTypeSearchList();

			// Testen mit leerer Referenz-Liste
			PersistentCompUnitType existingCompUnitType = typeManager.getExistingCUT(refTypes);
			assertTrue("Referenzliste des gefundenen CompUnitType sollte leer sein.", existingCompUnitType.getRefs()
					.getLength() == 0);

			refTypes.add(timeRef);
			refTypes.add(lengthRef);

			// Testen ohne erstellten CompUnitType
			existingCompUnitType = typeManager.getExistingCUT(refTypes);
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

	/**
	 * Testet die Methode fetchScalarType
	 */
	@Test
	public void testFetchScalarType() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		try {
			PersistentCompUnitType scalarType = typeManager.fetchScalarType();
			assertTrue("Referenz-Liste von scalarType sollte leer sein.", scalarType.getRefs().getLength() == 0);

			final PersistentUnitType ut = typeManager.createUnitType("unitType");
			typeManager.addReferenceType("cut", ut, ut, 1);

			scalarType = typeManager.fetchScalarType();
			assertTrue("Referenz-Liste von scalarType sollte leer sein.", scalarType.getRefs().getLength() == 0);
		} catch (final DoubleDefinitionException e) {
			fail("Exception: " + e.getMessage());
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}

	/**
	 * Testet die Methode changeUTName
	 */
	@Test
	public void testChangeUTName() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitType = null;
		try {
			unitType = typeManager.createUnitType("bla");
			typeManager.changeUTName(unitType, "blub");
		} catch (final DoubleDefinitionException e) {
			fail("Ungewollte DoubleDefinitionException: " + e.getMessage());
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
		try {
			final PersistentUnitType unitType2 = typeManager.createUnitType("bla");
			typeManager.changeUTName(unitType2, "blub");
			fail("Es sollte eine DoubleDefinitionException kommen, da UnitType mit Namen 'blub' schon vorhanden ist.");
		} catch (final DoubleDefinitionException e) {
			// Exception erwartet
			assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + "blub", e.getMessage());
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}

	/**
	 * Testet die Methode changeUName
	 */
	@Test
	public void testChangeUName() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		PersistentUnitType unitType = null;
		PersistentUnit unit = null;
		try {
			unitType = typeManager.createUnitType("bla");
			unit = typeManager.createUnit("blaUnit", unitType);
			typeManager.changeUName(unit, "blubUnit");
		} catch (final DoubleDefinitionException e) {
			fail("Ungewollte DoubleDefinitionException: " + e.getMessage());
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
		try {
			final PersistentUnit unit2 = typeManager.createUnit("blaUnit", unitType);
			typeManager.changeUName(unit2, "blubUnit");
			fail("Es sollte eine DoubleDefinitionException kommen, da UnitType mit Namen 'blub' schon vorhanden ist.");
		} catch (final DoubleDefinitionException e) {
			// Exception erwartet
			assertEquals(ExceptionConstants.DOUBLE_UNIT_DEFINITION + "blubUnit", e.getMessage());
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}
}
