/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.CycleException;
import model.MBoolean;
import model.MFalse;
import model.MTrue;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;
import test.util.AbstractTest;

/**
 * Testet die Boolean-implementation
 *
 */
public class MBooleanTest extends AbstractTest {

	public MBooleanTest() throws CycleException, PersistenceException {
		super();
	}
	/**
	 * Testet Grundfunktionalitäten von MBoolean 
	 * @throws PersistenceException
	 */
	@Test
	public void testBoolean() throws PersistenceException{
		PersistentMTrue theMTrue = MTrue.getTheMTrue();
		PersistentMFalse theMFalse = MFalse.getTheMFalse();
		//Boolean conversion
		assertTrue(theMTrue.toBoolean());
		assertFalse(theMFalse.toBoolean());
		assertEquals(theMTrue, MBoolean.create(true));
		assertEquals(theMFalse, MBoolean.create(false));
		//Invert
		assertEquals(theMFalse, theMTrue.invert());
		assertEquals(theMTrue, theMFalse.invert());
	}
}
