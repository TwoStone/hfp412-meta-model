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
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentObjectManager;
import persistence.PersistentObsTypeManager;
import persistence.PersistentObservationManager;
import persistence.PersistentTypeManager;
import util.GOJAUnitTestRunner;
import util.InjectSingleton;
import util.TestingBase;

@RunWith(GOJAUnitTestRunner.class)
public class ObsTypeManagerTest extends TestingBase {

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
	PersistentMEnumValue enumVal2;

	PersistentMAtomicType typeA;

	PersistentMObject objA;

	PersistentMAtomicType typeB;

	PersistentMObject objB;

	PersistentMObservationType obsType;

	@Before
	public void setUpAspects() throws ConsistencyException, PersistenceException, DoubleDefinitionException {
		final PersistentMAspect a = aspectMngr.createAspect("A1");
		typeA = typeMngr.createAtomicRootType(a, "Type A", mFalse, mFalse);
		typeB = typeMngr.createAtomicRootType(a, "Type B", mFalse, mFalse);
		enumeration = enumMan.createEnum("Enum1");
		enumeration2 = enumMan.createEnum("Enum2");
		enumVal = enumValMan.createEnumValue("Val 1", enumeration);
		enumVal2 = enumValMan.createEnumValue("Val 2", enumeration2);
		objA = objectMan.createMObject(typeA, new MAtomicTypeSearchList());
		objB = objectMan.createMObject(typeB, new MAtomicTypeSearchList());
		obsType = obsTypeMan.createObsType("Obs Type", enumeration, typeA);
	}

	@Test
	public void createObservation_Test1() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMObservation val = obsMan.createObservation("Obs", obsType, objA, enumVal);

		Assert.assertEquals("Obs", val.getName());
		Assert.assertEquals(obsType, val.getTheType());
		Assert.assertEquals(objA, val.getTheObsObject());
		Assert.assertEquals(enumVal, val.getEnumValue());
	}

	@Test(expected = ConsistencyException.class)
	public void createObservation_Test2() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		obsMan.createObservation("Obs", obsType, objB, enumVal);
	}

	@Test(expected = ConsistencyException.class)
	public void createObservation_Test3() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		obsMan.createObservation("Obs", obsType, objA, enumVal2);
	}

	@Test(expected = ConsistencyException.class)
	public void createObservation_Test4() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		obsMan.createObservation("Obs", obsType, objB, enumVal2);
	}

	@Test
	public void deleteObservation_Test1() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentMObservation val = obsMan.createObservation("Obs", obsType, objA, enumVal);
		Assert.assertTrue(obsMan.getObservations().getLength() == 1);
		obsMan.deleteObservation(val);
		Assert.assertTrue(obsMan.getObservations().getLength() == 0);
	}
}
