package viewClient;

public interface ClientReporter {
	
	public void reportNewClient(ConnectionMaster master);
	public void reportLostClient(ConnectionMaster master);

}
