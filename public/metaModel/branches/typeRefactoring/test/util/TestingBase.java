package util;

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

import org.junit.AfterClass;
import org.junit.BeforeClass;

import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMTrue;
import persistence.PersistentMType;

public abstract class TestingBase {

	protected static PersistentMFalse mFalse;
	protected static PersistentMTrue mTrue;

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

	protected static void assertEquals(PersistentMType expected, PersistentMType actual) throws PersistenceException {
		assertTrue(expected.isStructuralEquivalant(actual),
				String.format("Expected %s but was %s", expected.fetchName(), actual.fetchName()));
	}

}
