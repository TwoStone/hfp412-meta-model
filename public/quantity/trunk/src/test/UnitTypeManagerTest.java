/**
 * 
 */
package test;

import junit.framework.TestCase;
import model.AbsUnitType;
import model.AlreadyFinalizedException;
import model.DoubleDefinitionException;
import model.UnitTypeManager;
import model.visitor.BooleanValueReturnVisitor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentBooleanFalse;
import persistence.PersistentBooleanTrue;
import persistence.PersistentBooleanValue;
import persistence.PersistentCompUnitType;
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
			long currentLength = typeManager.getUnitTypes().getLength();
			try {
				typeManager.createUnitType(name);
				assertEquals("Es sollte nur einen UnitType geben.", currentLength+1, typeManager.getUnitTypes().getLength());
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
		
			
			try {
				typeManager.createUnitType(name);
				fail("Temperatur doppelt definiert, fehlende DoubleDefinitionExcpetion!");
			} catch (DoubleDefinitionException e) {
				// Exception korrekt!
				assertEquals(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION, e.getMessage());
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
				typeManager.createUnit(unitName, unitType);
				assertEquals("Es sollte nur eine Unit geben.", 1, typeManager.getUnits().getLength());
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
			
			try {
				typeManager.createUnit(unitName, unitType);
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
	/**
	 * Testet das Erstellen und abschließen einer Compound Unit
	 * Nachbedingungen: Name gesetzt, |Refs| = 0, isFinal = false
	 */
	@Test
	public void testCreateCompoundUnitType(){
		try {
			PersistentUnitTypeManager utm = UnitTypeManager.getTheUnitTypeManager();
			String name = "Hello, I'm a complex Type!";
			try {
				utm.createCompUnitType(name);
				PersistentCompUnitType cut = (PersistentCompUnitType)AbsUnitType.getAbsUnitTypeByName(name).iterator().next();
				assertEquals(name, cut.getName());
				assertTrue(cut.getRefs().getLength() == 0);
				assertFalse(this.isTrue(cut.isFinal()));
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
			
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testCreateCompoundUnitTypeSpeedExample(){
		try {
			PersistentUnitTypeManager utm = UnitTypeManager.getTheUnitTypeManager();
			String nameOfLength = "Length";
			String nameOfTime = "Time";
			String nameOfSpeed = "Speed";
			try {
				utm.createUnitType(nameOfLength);
				utm.createUnitType(nameOfTime);
				utm.createCompUnitType(nameOfSpeed);
				PersistentUnitType length = (PersistentUnitType) AbsUnitType.getAbsUnitTypeByName(nameOfLength).iterator().next();
				PersistentUnitType time = (PersistentUnitType) AbsUnitType.getAbsUnitTypeByName(nameOfTime).iterator().next();
				PersistentCompUnitType speed = (PersistentCompUnitType)AbsUnitType.getAbsUnitTypeByName(nameOfSpeed).iterator().next();
				assertFalse(this.isTrue(speed.isFinal()));
				try {
					utm.addReferenceType(speed, length, 1);
					utm.addReferenceType(speed, time, -1);
					assertFalse(this.isTrue(speed.isFinal()));
					speed.finishModeling();
				} catch (AlreadyFinalizedException e) {
					fail("AlreadyFinalizedException vor finalize()-Aufruf!");
				}
				assertTrue(this.isTrue(speed.isFinal()));
				
			} catch (DoubleDefinitionException e) {
				fail("Es sollte keine DoubleDefinitionException geben.");
			}
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
		
	}

	/**
	 * Macht aus BooleanValue ein Java-Boolean (Visitor Aufruf ausgelagert);-)
	 * weil Instanceof ist uncool
	 * @throws PersistenceException 
	 * 
	 */
	private boolean isTrue(PersistentBooleanValue bool) throws PersistenceException {
		boolean result = false;
		result = bool.accept(new BooleanValueReturnVisitor< Boolean >() {

			@Override
			public Boolean handleBooleanFalse(
					PersistentBooleanFalse booleanFalse)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleBooleanTrue(PersistentBooleanTrue booleanTrue)
					throws PersistenceException {
				return true;
			}

			
		});
		return result;
	}

}
