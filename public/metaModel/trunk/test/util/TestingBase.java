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
import model.typeSystem.MEmptyTypeConjunction;
import model.typeSystem.MMixedConjunction;
import model.typeSystem.MMixedTypeDisjunction;
import modelServer.ConnectionServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import persistence.Cache;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMFalse;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMTrue;
import persistence.PersistentMType;
import persistence.PersistentRoot;
import test.TestSupport;
import utils.SearchLists;
import utils.Sets;

@RunWith(GOJAUnitTestRunner.class)
public abstract class TestingBase {

	@InjectSingleton(MFalse.class)
	protected PersistentMFalse mFalse;

	@InjectSingleton(MTrue.class)
	protected PersistentMTrue mTrue;

	@InjectSingleton(MEmptyTypeConjunction.class)
	protected static PersistentMEmptyTypeConjunction anything;

	private final Set<Class<? extends PersistentRoot>> manager = Sets.newHashSet();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cache.getTheCache().reset$For$Test();
		final ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName, DBConnectionConstants.SchemaName, DBConnectionConstants.UserName,
				DBConnectionConstants.Password, true);
		ConnectionHandler.initializeMapsForMappedFields();

		ConnectionServer.startTheConnectionServer(EmptyServerReporter.getTheInstance());
		Cache.setReporter(EmptyServerReporter.getTheInstance());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// TODO Hier vielleicht noch das leeren der DB einbauen... Für pauschalbereinigung

		ConnectionServer.stopTheConnectionServer();
	}

	@Before
	public void resetSingletons() {
		TestSupport.prepareSingletons();
	}

	protected static PersistentMAtomicType atomicType(final String name, final PersistentMAspect aspect) throws PersistenceException, CycleException {

		return MAtomicType.createMAtomicType(name, MFalse.getTheMFalse(), MFalse.getTheMFalse(), aspect, anything);
	}

	protected static PersistentMAtomicType atomicType(final String name, final PersistentMAspect aspect, final PersistentMAtomicType superType)
			throws PersistenceException, CycleException {

		return MAtomicType.createMAtomicType(name, MFalse.getTheMFalse(), MFalse.getTheMFalse(), aspect, superType);
	}

	protected static PersistentMAspect aspect(final String name) throws PersistenceException {
		return MAspect.createMAspect(name);
	}

	protected static PersistentMMixedTypeDisjunction sum(final PersistentMType... mTypes) throws PersistenceException, CycleException {
		final PersistentMMixedTypeDisjunction disjuntion = MMixedTypeDisjunction.createMMixedTypeDisjunction();

		for (final PersistentMType persistentMType : mTypes) {
			disjuntion.getAddends().add(persistentMType);
		}

		return disjuntion;
	}

	protected static PersistentMMixedConjunction product(final PersistentMType... mTypes) throws PersistenceException, CycleException {
		final PersistentMMixedConjunction conj = MMixedConjunction.createMMixedConjunction();

		for (final PersistentMType persistentMType : mTypes) {
			conj.getFactors().add(persistentMType);
		}

		return conj;
	}

	public static PersistentMAbstractTypeDisjunction transNormDisj(final PersistentMType... mTypes) throws ConsistencyException, PersistenceException {
		return MAbstractTypeDisjunction.transientCreateAbstrTypeDisj(SearchLists.createMTypeSearchList(mTypes));
	}

	public static PersistentMAbstractTypeConjunction transNormConj(final PersistentMType... mTypes) throws ConsistencyException, PersistenceException {
		return MAbstractTypeConjunction.transientCreateAbstractTypeConj(SearchLists.createMTypeSearchList(mTypes));
	}

	protected static void assertMTrue(final PersistentMBoolean persistentMBoolean, final String message) throws PersistenceException {
		Assert.assertTrue(message, persistentMBoolean.toBoolean());
	}

	protected static void assertMTrue(final PersistentMBoolean value) throws PersistenceException {
		Assert.assertTrue(value.toBoolean());
	}

	protected static void assertMFalse(final PersistentMBoolean value) throws PersistenceException {
		Assert.assertFalse(value.toBoolean());
	}

	protected static void assertTypeStructureEquals(final PersistentMType expected, final PersistentMType actual) throws PersistenceException {
		assertMTrue(expected.isStructuralEquivalant(actual), String.format("Expected %s but was %s", expected.fetchName(), actual.fetchName()));
	}

	protected static void assertTypeSemanticEquals(final PersistentMType expected, final PersistentMType actual) throws PersistenceException {
		Assert.assertTrue(expected.isLessOrEqual(actual).toBoolean() && actual.isLessOrEqual(expected).toBoolean());

	}

	@SuppressWarnings("unchecked")
	protected <T extends PersistentRoot> T getManager(final Class<? extends T> managerClazz) {
		final String methodName = String.format("getThe%s", managerClazz.getSimpleName());
		Method method;
		try {
			method = managerClazz.getMethod(methodName);

			if (method == null) {
				throw new RuntimeException(String.format("The desired class %s is not a singleton!", managerClazz.getName()));
			}

			final T manager = (T) method.invoke(null);
			this.manager.add(managerClazz);
			return manager;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	@After
	public void cleanUpManagerAndCache() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException,
			PersistenceException, SQLException, IOException {
		Cache.getTheCache().reset$For$Test();

		for (final Class<?> managerClazz : manager) {
			resetSingleton(managerClazz);
		}

		manager.clear();
	}

	protected void resetSingleton(final Class<?> managerClazz) throws NoSuchFieldException, IllegalAccessException {
		final Field field = managerClazz.getField("reset$For$Test");
		field.set(null, true);
	}

}
