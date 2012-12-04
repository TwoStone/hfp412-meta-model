package modelServer;

public interface ServerReporter {

	void reportNewConnection(RemoteServerMaster server);
	void reportCancelledConnection(RemoteServerMaster server);
	void reportCurrentCacheSize(int size);
}
