/**
 * 
 */
package model.quantity;

import java.util.Iterator;

import model.ConsistencyException;
import model.DoubleDefinitionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.ReferenceList;
import persistence.ReferenceTypeSearchList;
import util.TestingBase;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Testet die Klasse CompUnitType.
 * 
 */
public class CompUnitTypeTest extends TestingBase {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.quantity.CompUnitType#hasReferences(persistence.ReferenceTypeSearchList)}.
	 */
	@Test
	public void testHasReferences() {
		try {
			final PersistentUnitType length = UnitType.createUnitType("Laenge");
			final PersistentReferenceType lengthRef = ReferenceType.createReferenceType(1, length);
			final PersistentUnitType time = UnitType.createUnitType("Zeit");
			final PersistentReferenceType timeRef = ReferenceType.createReferenceType(-1, time);
			final PersistentCompUnitType cut = CompUnitType.createCompUnitType("Laenge*Zeit");
			cut.getRefs().add(timeRef);
			cut.getRefs().add(lengthRef);

			final ReferenceTypeSearchList refTypes = new ReferenceTypeSearchList();
			assertTrue("Leere Liste sollte immer enthalten sein.", cut.hasReferences(refTypes).toBoolean());

			refTypes.add(timeRef);
			assertTrue("timeRef ist in cut vorhanden.", cut.hasReferences(refTypes).toBoolean());

			refTypes.add(lengthRef);
			assertTrue("timeRef und lengthRef sind in cut vorhanden.", cut.hasReferences(refTypes).toBoolean());

			final PersistentCompUnitType scalarCUT = CompUnitType.createCompUnitType("scalar");
			assertFalse("Skalar enthält kein timeRef und lengthRef", scalarCUT.hasReferences(refTypes).toBoolean());

		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}
	}

	/**
	 * Test method for {@link model.quantity.CompUnitType#fetchDefaultUnit()}.
	 */
	@Test
	public void testFetchDefaultUnit() {
		final PersistentUnitTypeManager typeManager = this.getManager(UnitTypeManager.class);
		try {
			// ScalarType auf DefaultUnit prüfen
			final PersistentCompUnitType scalarType = typeManager.fetchScalarType();
			try {
				final PersistentAbsUnit defaultUnit = scalarType.fetchDefaultUnit();
				assertTrue("DefaultUnit des ScalarTypes sollte eine CompUnit sein.",
						defaultUnit instanceof PersistentCompUnit);
				assertTrue("DefaultUnit des ScalarTypes sollte keine Referenzen haben.",
						((PersistentCompUnit) defaultUnit).getRefs().getLength() == 0);
			} catch (final ConsistencyException e) {
				fail("DefaultUnit des ScalarTypes sollte automatisch gesetzt werden. Falsche ConsistencyException: "
						+ e.getMessage());
			}

			// CompUnitType erstellen
			final PersistentUnitType unitType1 = typeManager.createUnitType("unitType1");
			final PersistentUnitType unitType2 = typeManager.createUnitType("unitType2");
			final PersistentAbsUnitType unitType12 = typeManager
					.addReferenceType("unitType12", unitType1, unitType2, 1);
			try {
				unitType12.fetchDefaultUnit();
				fail("Es sollte eine ConsistencyException kommen, da keine DefaultUnits in den einzelnen unitTypes gesetzt wurden.");
			} catch (final ConsistencyException e) {
				// Exception berechtigt, da keine DefaultUnits gesetzt wurden
			}

			// DefaultUnits erstellen und setzen
			final PersistentUnit unit1 = typeManager.createUnit("unit1", unitType1);
			final PersistentUnit unit2 = typeManager.createUnit("unit2", unitType2);
			typeManager.setDefaultUnit(unitType1, unit1);
			typeManager.setDefaultUnit(unitType2, unit2);
			try {
				final PersistentAbsUnit defaultUnit = unitType12.fetchDefaultUnit();
				assertTrue("defaultUnit sollte ein CompUnitType sein.", defaultUnit instanceof PersistentCompUnit);
				final ReferenceList refs = ((PersistentCompUnit) defaultUnit).getRefs().getList();
				assertTrue("DefaultUnit sollte zwei Referenzen haben", refs.getLength() == 2);
				final Iterator<PersistentReference> i = refs.iterator();
				while (i.hasNext()) {
					final PersistentReference next = i.next();
					assertTrue("Die Referenz sollte auf unit1 oder unit2 gehen", next.getRef().equals(unit1)
							|| next.getRef().equals(unit2));
					assertTrue("Der Exponent sollte 1 sein.", next.getExponent() == 1);
				}
			} catch (final ConsistencyException e) {
				fail("Da DefaultUnits vorher gesetzt wurden, sollte keine ConsistencyException kommen.");
			}

		} catch (final DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final PersistenceException e) {
			fail("Exception: " + e.getMessage());
		}

	}
}
