/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.CycleException;
import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;

/**
 * Testet die Boolean-implementation
 *
 */
public class MBooleanTest {

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
		assertEquals(theMTrue, MBoolean.createFromBoolean(true));
		assertEquals(theMFalse, MBoolean.createFromBoolean(false));
		//Invert
		assertEquals(theMFalse, theMTrue.invert());
		assertEquals(theMTrue, theMFalse.invert());
	}
}
