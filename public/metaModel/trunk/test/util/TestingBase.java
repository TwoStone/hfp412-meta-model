package util;

import model.DBConnectionConstants;
import modelServer.ConnectionServer;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import persistence.ConnectionHandler;

public abstract class TestingBase {

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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// TODO Hier vielleicht noch das leeren der DB einbauen... Für pauschalbereinigung

		ConnectionServer.stopTheConnectionServer();
	}

}
