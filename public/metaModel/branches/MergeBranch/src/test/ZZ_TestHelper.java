package test;

import model.DBConnectionConstants;
import persistence.ConnectionHandler;
import persistence.PersistenceException;

public final class ZZ_TestHelper {
	
	public static void initializeConnection() throws PersistenceException {
		DBConnectionConstants.Password = "gojauser".toCharArray();
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			DBConnectionConstants.Password,
			true);
	}
	
	public static void tearDown() throws PersistenceException {
	}
	

}
