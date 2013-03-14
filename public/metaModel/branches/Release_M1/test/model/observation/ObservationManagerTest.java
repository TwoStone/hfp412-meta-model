package model.observation;

import junit.framework.Assert;
import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.observations.EnumValueManager;
import model.observations.EnumerationManager;
import model.observations.ObsTypeManager;
import model.observations.ObservationManager;
import model.typeSystem.AspectManager;
import model.typeSystem.ObjectManager;
import model.typeSystem.TypeManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import persistence.MAtomicTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentEnumValueManager;
import persistence.PersistentEnumerationManager;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObject;
import persistence.PersistentMObservationType;
import persistence.PersistentObjectManager;
import persistence.PersistentObsTypeManager;
import persistence.PersistentObservationManager;
import persistence.PersistentTypeManager;
import util.GOJAUnitTestRunner;
import util.InjectSingleton;
import util.TestingBase;

@RunWith(GOJAUnitTestRunner.class)
public class ObservationManagerTest extends TestingBase {

	@InjectSingleton(EnumerationManager.class)
	PersistentEnumerationManager enumMan;

	@InjectSingleton(EnumValueManager.class)
	PersistentEnumValueManager enumValMan;

	@InjectSingleton(ObsTypeManager.class)
	PersistentObsTypeManager obsTypeMan;

	@InjectSingleton(ObservationManager.class)
	PersistentObservationManager obsMan;

	@InjectSingleton(AspectManager.class)
	PersistentAspectManager aspectMngr;

	@InjectSingleton(ObjectManager.class)
	PersistentObjectManager objectMan;

	@InjectSingleton(TypeManager.class)
	PersistentTypeManager typeMngr;

	PersistentMEnum enumeration;
	PersistentMEnum enumeration2;

	PersistentMEnumValue enumVal;

	PersistentMAtomicType typeA;

	PersistentMObject objA;

	PersistentMAtomicType typeB;

	@Before
	public void setUpAspects() throws ConsistencyException, PersistenceException, DoubleDefinitionException {
		final PersistentMAspect a = aspectMngr.createAspect("A1");
		typeA = typeMngr.createAtomicRootType(a, "Type A", mFalse, mFalse);
		typeB = typeMngr.createAtomicRootType(a, "Type B", mFalse, mFalse);
		enumeration = enumMan.createEnum("Enum1");
		enumeration2 = enumMan.createEnum("Enum2");
		enumVal = enumValMan.createEnumValue("Val 1", enumeration);
		objA = objectMan.createMObject(typeA, new MAtomicTypeSearchList());
	}

	@Test
	public void createObsType_Test1() throws DoubleDefinitionException, PersistenceException {
		final PersistentMObservationType val = obsTypeMan.createObsType("ObsType1", enumeration, typeA);

		Assert.assertEquals("ObsType1", val.getName());
		Assert.assertEquals(enumeration, val.getEnumType());
		Assert.assertEquals(typeA, val.getTheType());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createObsType_Test2() throws DoubleDefinitionException, PersistenceException {
		obsTypeMan.createObsType("ObsType1", enumeration, typeA);
		obsTypeMan.createObsType("ObsType1", enumeration, typeA);
	}

	@Test
	public void deleteObsType_Test1() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMObservationType val = obsTypeMan.createObsType("ObsType1", enumeration, typeA);

		Assert.assertTrue(obsTypeMan.getObservationTypes().getLength() == 1);
		obsTypeMan.deleteObsType(val);
		Assert.assertTrue(obsTypeMan.getObservationTypes().getLength() == 0);
	}

	@Test(expected = ConsistencyException.class)
	public void deleteObsType_Test2() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMObservationType val = obsTypeMan.createObsType("ObsType1", enumeration, typeA);
		obsMan.createObservation("Obs1", val, objA, enumVal);

		Assert.assertTrue(obsTypeMan.getObservationTypes().getLength() == 1);
		obsTypeMan.deleteObsType(val);
	}

}
