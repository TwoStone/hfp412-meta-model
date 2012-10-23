package viewClient;

import java.util.HashMap;

public class ConnectionIndex {

	private static ConnectionIndex theConnectionIndex;

	public static ConnectionIndex getTheConnectionIndex() {
		if (theConnectionIndex == null) theConnectionIndex = new ConnectionIndex();
		return theConnectionIndex;
	}
	
	private HashMap<ExceptionAndEventHandler, ConnectionMaster> index;
	
	private ConnectionIndex(){
		this.index = new HashMap<ExceptionAndEventHandler, ConnectionMaster>();
	}
	private HashMap<ExceptionAndEventHandler, ConnectionMaster> getIndex(){
		return this.index;
	}
	public ConnectionMaster getConnection(ExceptionAndEventHandler connectionKey) {
		return this.getIndex().get(connectionKey);
	}
	public void setConnection(ExceptionAndEventHandler connectionKey, ConnectionMaster connection){
		this.getIndex().put(connectionKey, connection);
	}

}
