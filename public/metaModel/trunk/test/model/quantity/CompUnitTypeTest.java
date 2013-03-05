/**
 * 
 */
package model.quantity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentReferenceType;
import persistence.PersistentUnitType;
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

}
