package modelServer;

public class ConnectionDistributor{

	private ConnectionServer connectionServer;

	public ConnectionDistributor(ConnectionServer connectionServer) {
		this.connectionServer = connectionServer;
	}
	public Object execute(String connection, byte[] command){
		return this.connectionServer.execute(connection, command);
	}
}
