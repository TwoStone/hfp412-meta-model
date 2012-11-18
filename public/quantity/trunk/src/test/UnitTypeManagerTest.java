/**
 * 
 */
package test;

import junit.framework.TestCase;
import model.AbsUnitType;
import model.DoubleDefinitionException;
import model.UnitTypeManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import constants.ExceptionConstants;

/**
 * Testet den UnitTypeManager
 *
 */
public class UnitTypeManagerTest extends TestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		try {
			ZZ_TestHelper.initializeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		try {
			ZZ_TestHelper.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testet das Erstellen von UnitTypes.
	 */
	@Test
	public void testCreateUnitType() {
		try {
			PersistentUnitTypeManager typeManager = UnitTypeManager.getTheUnitTypeManager();
			String name = "Temperatur";
			try {
				typeManager.createUnitType(name);
				assertEquals("Es sollte nur einen UnitType geben.", 1, typeManager.getUnitTypes().getLength());
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
			
			try {
				typeManager.createUnitType(name);
				fail("Temperatur doppelt definiert, fehlende DoubleDefinitionExcpetion!");
			} catch (DoubleDefinitionException e) {
				// Exception korrekt!
				assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name, e.getMessage());
			}
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}
	
	/**
	 * Testet das Erstellen von Units.
	 */
	@Test
	public void testCreateUnit(){
		try {
			PersistentUnitTypeManager typeManager = UnitTypeManager.getTheUnitTypeManager();
			String unitTypeName = "Länge";
			try {
				typeManager.createUnitType(unitTypeName);
			} catch (DoubleDefinitionException e) {
				//UnitType Temperatur ggf. schon aus vorherigem Testfall vorhanden.
			}
			PersistentUnitType unitType = (PersistentUnitType)AbsUnitType.getAbsUnitTypeByName(unitTypeName).iterator().next();
			String unitName = "Meter";
			try {
				typeManager.createUnit(unitType, unitName);
				assertEquals("Es sollte nur eine Unit geben.", 1, typeManager.getUnits().getLength());
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
			
			try {
				typeManager.createUnit(unitType, unitName);
				fail("Temperatur doppelt definiert, fehlende DoubleDefinitionExcpetion!");
			} catch (DoubleDefinitionException e) {
				// Exception korrekt!
				assertEquals(ExceptionConstants.DOUBLE_UNIT_DEFINITION + unitName, e.getMessage());
			}
			
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}
	
	/**
	 * Testet das Hinzufügen einer DefaultUnit.
	 */
	@Test
	public void testAddDefaultUnit(){
		//TODO!!
	}

}
