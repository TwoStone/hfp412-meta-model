/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.AlreadyFinalizedException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.MBoolean;
import model.MTrue;
import model.NotFinalizedException;
import model.quantity.AbsUnitType;
import model.quantity.CompUnit;
import model.quantity.UnitTypeManager;
import model.visitor.MBooleanReturnVisitor;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import test.util.AbstractTest;
import constants.ExceptionConstants;

/**
 * Testet den UnitTypeManager
 *
 */
public class UnitTypeManagerTest extends AbstractTest {

	public UnitTypeManagerTest() throws CycleException, PersistenceException {
		super();
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
			String unitTypeName = "Laenge";
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
	 * Testet das Hinzufï¿½gen einer DefaultUnit.
	 */
	@Test
	public void testAddDefaultUnit(){
		//TODO!!
	}
	/**
	 * Testet das Erstellen und abschlieï¿½en einer Compound Unit
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
	 * Testet das Erstellen eines nicht finalen CompoundUnitTypes.
	 * Eine CompoundUnit darf nicht erstellt werden können. 
	 */
	@Test
	public void testCreateCompoundUnitIfNotFinal(){
		try {
			PersistentUnitTypeManager utm = UnitTypeManager.getTheUnitTypeManager();
			String name = "Hello, I'm a complex Type!";
			String nameU = "Hello, I'm a complex Unit!";
			try {
				utm.createCompUnitType(name);
				PersistentCompUnitType cut = (PersistentCompUnitType)AbsUnitType.getAbsUnitTypeByName(name).iterator().next();
				utm.createCompUnit(nameU, cut);
				fail("Es darf keine CompundUnit erzeugt werden dürfe, wenn Type nicht final.");
			} catch (DoubleDefinitionException e) {
				
			} catch (NotFinalizedException e) {
				assertEquals(constants.ExceptionConstants.NOT_FINAL, e.getMessage());
			}
			
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}
	
	/**
	 * Testet das Erstellen eines finalen CompoundUnitTypes.
	 * Eine CompoundUnit darf erstellt werden können. 
	 */
	@Test
	public void testCreateCompoundUnitIfFinal(){
		try {
			PersistentUnitTypeManager utm = UnitTypeManager.getTheUnitTypeManager();
			String name = "Hello, I'm a complex Type!";
			String nameU = "Hello, I'm a complex Unit!";
			try {
				utm.createCompUnitType(name);
				PersistentCompUnitType cut = (PersistentCompUnitType)AbsUnitType.getAbsUnitTypeByName(name).iterator().next();
				cut.setIsFinal(MTrue.getTheMTrue());
				utm.createCompUnit(nameU, cut);
			} catch (DoubleDefinitionException e) {
				
			} catch (NotFinalizedException e) {
				fail("CUT ist final, darf also nicht auftreten.");
			}
			
		} catch (PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}
	
	
	/**
	 * Macht aus BooleanValue ein Java-Boolean (Visitor Aufruf ausgelagert);-)
	 * weil Instanceof ist uncool ... !!!!! kann weg!!!!!
	 * @throws PersistenceException 
	 * 
	 */
	private boolean isTrue(PersistentMBoolean bool) throws PersistenceException {
		return bool.toBoolean();
	}

}
