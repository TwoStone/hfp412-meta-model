package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import junit.framework.Assert;
import model.CycleException;
import model.DBConnectionConstants;
import model.basic.MFalse;
import model.basic.MTrue;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MProductType;
import model.typeSystem.MSumType;
import modelServer.ConnectionServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import persistence.*;
import utils.Sets;

public abstract class TestingBase {

	protected static PersistentMFalse mFalse;
	protected static PersistentMTrue mTrue;

	private final Set<Class<?>> manager = Sets.newHashSet();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// System.out.println("Abstract initializations...");
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName, DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName, DBConnectionConstants.Password, true);
		ConnectionHandler.initializeMapsForMappedFields();

		/*
		 * TODO Vielleicht hier den EmptyReporter verwenden, was auch immer der tut! Standardmäßig wird NoReporter
		 * gesetzt.
		 */
		ConnectionServer.startTheConnectionServer(null);

		mFalse = MFalse.getTheMFalse();
		mTrue = MTrue.getTheMTrue();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// TODO Hier vielleicht noch das leeren der DB einbauen... Für pauschalbereinigung

		ConnectionServer.stopTheConnectionServer();
	}

	protected static PersistentMAtomicType atomicType(String name, PersistentMAspect aspect)
			throws PersistenceException {
		return MAtomicType.createMAtomicType(name, mFalse, mFalse, aspect);
	}

	protected static PersistentMAtomicType atomicType(String string, PersistentMAspect aspect,
			PersistentMAtomicType superType) throws PersistenceException, CycleException {
		PersistentMAtomicType atomicType = atomicType(string, aspect);
		atomicType.setSuperType(superType);

		return atomicType;
	}

	protected static PersistentMAspect aspect(String name) throws PersistenceException {
		return MAspect.createMAspect(name);
	}

	protected static PersistentMSumType sum(PersistentMType... mTypes) throws PersistenceException, CycleException {
		PersistentMSumType sumType = MSumType.createMSumType();

		for (PersistentMType persistentMType : mTypes) {
			sumType.getAddends().add(persistentMType);
		}

		return sumType;
	}

	protected static PersistentMProductType product(PersistentMType... mTypes) throws PersistenceException,
			CycleException {
		PersistentMProductType product = MProductType.createMProductType();

		for (PersistentMType persistentMType : mTypes) {
			product.getFactors().add(persistentMType);
		}

		return product;
	}

	protected static void assertTrue(PersistentMBoolean persistentMBoolean, String message) throws PersistenceException {
		Assert.assertTrue(message, persistentMBoolean.toBoolean());
	}

	protected static void assertTrue(PersistentMBoolean value) throws PersistenceException {
		Assert.assertTrue(value.toBoolean());
	}

	protected static void assertFalse(PersistentMBoolean value) throws PersistenceException {
		Assert.assertFalse(value.toBoolean());
	}

	protected static void assertEquals(PersistentMType expected, PersistentMType actual) throws PersistenceException {
		assertTrue(expected.isStructuralEquivalant(actual),
				String.format("Expected %s but was %s", expected.fetchName(), actual.fetchName()));
	}

	@SuppressWarnings("unchecked")
	protected <T> T getManager(Class<? extends T> managerClazz) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = String.format("getThe%s", managerClazz.getSimpleName());
		Method method = managerClazz.getMethod(methodName);
		if (method == null) {
			throw new RuntimeException(
					String.format("The desired class %s is not a singleton!", managerClazz.getName()));
		}

		T manager = (T) method.invoke(null);
		this.manager.add(managerClazz);
		return manager;
	}

	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {
		for (Class<?> managerClazz : manager) {
			Field field = managerClazz.getField("reset$For$Test");
			field.set(null, true);
		}
	}

}
