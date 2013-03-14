package model.observation;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.observations.EnumValueManager;
import model.observations.EnumerationManager;
import model.observations.ObsTypeManager;
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
import persistence.PersistentObsTypeManager;
import persistence.PersistentTypeManager;
import util.GOJAUnitTestRunner;
import util.InjectSingleton;
import util.TestingBase;

@RunWith(GOJAUnitTestRunner.class)
public class EnumerationManagerTest extends TestingBase {

	@InjectSingleton(EnumerationManager.class)
	PersistentEnumerationManager enumMan;

	@InjectSingleton(EnumValueManager.class)
	PersistentEnumValueManager enumValMan;

	@InjectSingleton(ObsTypeManager.class)
	PersistentObsTypeManager obsTypeMan;

	@InjectSingleton(AspectManager.class)
	PersistentAspectManager aspectMngr;

	@InjectSingleton(TypeManager.class)
	PersistentTypeManager typeMngr;

	PersistentMAtomicType typeA;
	PersistentMAtomicType typeB;

	@Before
	public void setUpAspects() throws ConsistencyException, PersistenceException {
		final PersistentMAspect a = aspectMngr.createAspect("A1");
		typeA = typeMngr.createAtomicRootType(a, "Type A", mFalse, mFalse);
		typeB = typeMngr.createAtomicRootType(a, "Type B", mFalse, mFalse);
	}

	@Test
	public void createEnum_Test1() throws DoubleDefinitionException, PersistenceException {
		final PersistentMEnum val = enumMan.createEnum("Enum1");

		Assert.assertEquals("Enum1", val.getName());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createEnum_Test2() throws DoubleDefinitionException, PersistenceException {
		enumMan.createEnum("Enum1");
		enumMan.createEnum("Enum1");
	}

	@Test
	public void deleteEnum_Test1() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMEnum enumeration = enumMan.createEnum("Enum1");
		assertTrue(enumMan.getEnumTypes().getLength() == 1);
		enumMan.deleteEnum(enumeration);
		assertTrue(enumMan.getEnumTypes().getLength() == 0);
	}

	@Test(expected = ConsistencyException.class)
	public void deleteEnum_Test2() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMEnum enumeration = enumMan.createEnum("Enum1");
		enumValMan.createEnumValue("Val1", enumeration);
		assertTrue(enumMan.getEnumTypes().getLength() == 1);
		enumMan.deleteEnum(enumeration);
	}

	@Test(expected = ConsistencyException.class)
	public void deleteEnum_Test3() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMEnum enumeration = enumMan.createEnum("Enum1");
		obsTypeMan.createObsType("O1", enumeration, typeA);

		assertTrue(enumMan.getEnumTypes().getLength() == 1);
		enumMan.deleteEnum(enumeration);
	}

}
