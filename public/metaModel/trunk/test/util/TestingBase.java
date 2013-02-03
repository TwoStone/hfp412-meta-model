package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
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
import org.junit.Before;
import org.junit.BeforeClass;

import persistence.*;
import test.util.EmptyServerReporter;
import utils.Sets;

public abstract class TestingBase {

	protected PersistentMFalse mFalse;
	protected PersistentMTrue mTrue;

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
		ConnectionServer.startTheConnectionServer(EmptyServerReporter.getTheInstance());
		Cache.setReporter(EmptyServerReporter.getTheInstance());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// TODO Hier vielleicht noch das leeren der DB einbauen... Für pauschalbereinigung

		ConnectionServer.stopTheConnectionServer();
	}

	@Before
	public void setup() throws PersistenceException, SQLException, IOException {
		Cache.getTheCache().reset$For$Test();
		MTrue.reset$For$Test = true;
		MFalse.reset$For$Test = true;
		mFalse = MFalse.getTheMFalse();
		mTrue = MTrue.getTheMTrue();
	}

	protected static PersistentMAtomicType atomicType(String name, PersistentMAspect aspect)
			throws PersistenceException {
		return MAtomicType.createMAtomicType(name, MFalse.getTheMFalse(), MFalse.getTheMFalse(), aspect);
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

	protected static void assertMTrue(PersistentMBoolean persistentMBoolean, String message) throws PersistenceException {
		Assert.assertTrue(message, persistentMBoolean.toBoolean());
	}

	protected static void assertMTrue(PersistentMBoolean value) throws PersistenceException {
		Assert.assertTrue(value.toBoolean());
	}

	protected static void assertMFalse(PersistentMBoolean value) throws PersistenceException {
		Assert.assertFalse(value.toBoolean());
	}

	protected static void assertTypeEquals(PersistentMType expected, PersistentMType actual) throws PersistenceException {
		assertMTrue(expected.isStructuralEquivalant(actual),
				String.format("Expected %s but was %s", expected.fetchName(), actual.fetchName()));
	}

	@SuppressWarnings("unchecked")
	protected <T> T getManager(Class<? extends T> managerClazz) {
		String methodName = String.format("getThe%s", managerClazz.getSimpleName());
		Method method;
		try {
			method = managerClazz.getMethod(methodName);

			if (method == null) {
				throw new RuntimeException(String.format("The desired class %s is not a singleton!",
						managerClazz.getName()));
			}

			T manager = (T) method.invoke(null);
			this.manager.add(managerClazz);
			return manager;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@After
	public void cleanUpManagerAndCache() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException, PersistenceException, SQLException, IOException {
		Cache.getTheCache().reset$For$Test();

		for (Class<?> managerClazz : manager) {
			Field field = managerClazz.getField("reset$For$Test");
			field.set(null, true);
		}

		manager.clear();
	}

}
