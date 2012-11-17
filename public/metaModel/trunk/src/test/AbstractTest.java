package test;

import model.DBConnectionConstants;
import modelServer.ConnectionServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import persistence.ConnectionHandler;

public abstract class AbstractTest  {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBConnectionConstants.Password = new char[2];
		ConnectionHandler connection = ConnectionHandler
				.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName,
				DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName, DBConnectionConstants.Password,
				true);
		ConnectionHandler.initializeMapsForMappedFields();
		ConnectionServer.startTheConnectionServer(EmptyServerReporter.getTheInstance());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ConnectionServer.stopTheConnectionServer();
	}
}
