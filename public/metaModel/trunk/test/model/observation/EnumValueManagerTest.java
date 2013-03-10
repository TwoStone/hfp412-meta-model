package model.observation;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.observations.EnumValueManager;
import model.observations.EnumerationManager;
import model.typeSystem.AspectManager;
import model.typeSystem.TypeManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentEnumValueManager;
import persistence.PersistentEnumerationManager;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentTypeManager;
import util.GOJAUnitTestRunner;
import util.InjectSingleton;
import util.TestingBase;

@RunWith(GOJAUnitTestRunner.class)
public class EnumValueManagerTest extends TestingBase {

	@InjectSingleton(EnumerationManager.class)
	PersistentEnumerationManager enumMan;

	@InjectSingleton(EnumValueManager.class)
	PersistentEnumValueManager enumValMan;

	@InjectSingleton(AspectManager.class)
	PersistentAspectManager aspectMngr;

	@InjectSingleton(TypeManager.class)
	PersistentTypeManager typeMngr;

	PersistentMEnum enumeration;
	PersistentMEnum enumeration2;

	PersistentMAtomicType typeA;
	PersistentMAtomicType typeB;

	@Before
	public void setUpAspects() throws ConsistencyException, PersistenceException, DoubleDefinitionException {
		final PersistentMAspect a = aspectMngr.createAspect("A1");
		typeA = typeMngr.createAtomicRootType(a, "Type A", mFalse, mFalse);
		typeB = typeMngr.createAtomicRootType(a, "Type B", mFalse, mFalse);
		enumeration = enumMan.createEnum("Enum1");
		enumeration2 = enumMan.createEnum("Enum2");
	}

	@Test
	public void createEnumValue_Test1() throws DoubleDefinitionException, PersistenceException {
		final PersistentMEnumValue val = enumValMan.createEnumValue("Val 1", enumeration);

		Assert.assertEquals("Val 1", val.getName());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createEnumValue_Test2() throws DoubleDefinitionException, PersistenceException {
		enumValMan.createEnumValue("Val 1", enumeration);
		enumValMan.createEnumValue("Val 1", enumeration);
	}

	@Test
	public void createEnumValue_Test3() throws DoubleDefinitionException, PersistenceException {
		final PersistentMEnumValue val = enumValMan.createEnumValue("Val 1", enumeration);
		final PersistentMEnumValue val2 = enumValMan.createEnumValue("Val 1", enumeration2);

		Assert.assertEquals("Val 1", val.getName());
		Assert.assertEquals(enumeration, val.getTheType());
		Assert.assertEquals("Val 1", val2.getName());
		Assert.assertEquals(enumeration2, val2.getTheType());
	}

	@Test
	public void deleteEnumValue_Test1() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMEnumValue val = enumValMan.createEnumValue("Val 1", enumeration);

		assertTrue(enumValMan.getEnumValues().getLength() == 1);
		enumValMan.deleteEnumValue(val);
		assertTrue(enumValMan.getEnumValues().getLength() == 0);
	}
}
