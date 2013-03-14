package util;

import modelServer.RemoteServerMaster;
import modelServer.ServerReporter;

public class EmptyServerReporter implements ServerReporter {

	private static EmptyServerReporter theInstance;

	private EmptyServerReporter() {
	}

	public static EmptyServerReporter getTheInstance() {
		if (theInstance == null) {
			theInstance = new EmptyServerReporter();
		}

		return theInstance;
	}

	@Override
	public void reportNewConnection(RemoteServerMaster server) {
	}

	@Override
	public void reportCancelledConnection(RemoteServerMaster server) {
	}

	@Override
	public void reportCurrentCacheSize(int size) {

	}

}
