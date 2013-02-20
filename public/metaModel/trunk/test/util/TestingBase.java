package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Set;

import junit.framework.Assert;
import model.ConsistencyException;
import model.CycleException;
import model.DBConnectionConstants;
import model.basic.MFalse;
import model.basic.MTrue;
import model.typeSystem.MAbstractTypeConjunction;
import model.typeSystem.MAbstractTypeDisjunction;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MMixedConjunction;
import model.typeSystem.MMixedTypeDisjunction;
import modelServer.ConnectionServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import persistence.Cache;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMTrue;
import persistence.PersistentMType;
import test.util.EmptyServerReporter;
import utils.SearchLists;
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

	protected static PersistentMMixedTypeDisjunction sum(PersistentMType... mTypes) throws PersistenceException,
			CycleException {
		PersistentMMixedTypeDisjunction disjuntion = MMixedTypeDisjunction.createMMixedTypeDisjunction();

		for (PersistentMType persistentMType : mTypes) {
			disjuntion.getAddends().add(persistentMType);
		}

		return disjuntion;
	}

	protected static PersistentMMixedConjunction product(PersistentMType... mTypes) throws PersistenceException,
			CycleException {
		PersistentMMixedConjunction conj = MMixedConjunction.createMMixedConjunction();

		for (PersistentMType persistentMType : mTypes) {
			conj.getFactors().add(persistentMType);
		}

		return conj;
	}

	public static PersistentMAbstractTypeDisjunction transNormDisj(PersistentMType... mTypes)
			throws ConsistencyException, PersistenceException {
		return MAbstractTypeDisjunction.transientCreateAbstrTypeDisj(SearchLists.createMTypeSearchList(mTypes));
	}

	public static PersistentMAbstractTypeConjunction transNormConj(PersistentMType... mTypes)
			throws ConsistencyException, PersistenceException {
		return MAbstractTypeConjunction.transientCreateAbstractTypeConj(SearchLists.createMTypeSearchList(mTypes));
	}

	protected static void assertMTrue(PersistentMBoolean persistentMBoolean, String message)
			throws PersistenceException {
		Assert.assertTrue(message, persistentMBoolean.toBoolean());
	}

	protected static void assertMTrue(PersistentMBoolean value) throws PersistenceException {
		Assert.assertTrue(value.toBoolean());
	}

	protected static void assertMFalse(PersistentMBoolean value) throws PersistenceException {
		Assert.assertFalse(value.toBoolean());
	}

	protected static void assertTypeStructureEquals(PersistentMType expected, PersistentMType actual)
			throws PersistenceException {
		assertMTrue(expected.isStructuralEquivalant(actual),
				String.format("Expected %s but was %s", expected.fetchName(), actual.fetchName()));
	}

	protected static void assertTypeSemanticEquals(PersistentMType expected, PersistentMType actual)
			throws PersistenceException {
		Assert.assertTrue(expected.isLessOrEqual(actual).toBoolean() && actual.isLessOrEqual(expected).toBoolean());

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
