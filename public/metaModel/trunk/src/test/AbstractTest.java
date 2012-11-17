package test;

import model.DBConnectionConstants;
import modelServer.ConnectionServer;
import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import persistence.ConnectionHandler;

public abstract class AbstractTest implements ServerReporter {

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
	}

	@Before
	public void setUp() throws Exception {
		ConnectionServer.startTheConnectionServer(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ConnectionServer.stopTheConnectionServer();
	}

	@Override
	public void reportNewConnection(RemoteServerMaster server) {	}

	@Override
	public void reportCancelledConnection(RemoteServerMaster server) {	}

	@Override
	public void reportCurrentCacheSize(int size) {	}
}
