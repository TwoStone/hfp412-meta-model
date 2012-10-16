package persistence;

import java.util.TreeSet;
import java.util.Vector;

public class Connection {

	private java.sql.Connection connection;
	private boolean test = true;
	private long commandCounter;
	private java.util.HashMap<String, Integer> operationCounters;
	
	protected Connection(java.sql.Connection connection){
		this.connection = connection;
		this.commandCounter = 0;
		this.operationCounters = new java.util.HashMap<String, Integer>();
	}

	public java.util.HashMap<String, Integer> getOperationCounters(){
		return this.operationCounters;
	}
	public long getCommandCounter(){
		return this.commandCounter;
	}
	public boolean isClosed() throws java.sql.SQLException {
		return this.connection == null || this.connection.isClosed();
	}

	public void close() throws java.sql.SQLException {
		this.connection.close();
	}

	public java.sql.CallableStatement prepareCall(String sql) throws java.sql.SQLException {
		synchronized (this) {
			if (test) {
				this.commandCounter++;
				this.increment(sql);
			}
		}
		return this.connection.prepareCall(sql);
	}
	
	private static final String dot = ".";

	private void increment(String sql) {
		String normalized = sql.substring(sql.indexOf(dot) + dot.length(), sql.indexOf(";"));
		Integer oldCounter = this.getOperationCounters().get(normalized);
		if (oldCounter == null) oldCounter = 0;
		this.operationCounters.put(normalized, oldCounter + 1);
	}

	public void setAutoCommit(boolean autoCommit) throws java.sql.SQLException {
		this.connection.setAutoCommit(autoCommit);
	}

	public void commit() throws java.sql.SQLException {
		this.connection.commit();
	}

	public void rollback() throws java.sql.SQLException {
		this.connection.rollback();
	}
	class InfoPair implements Comparable<InfoPair> {

		private String method;
		private Integer counter;

		public InfoPair(String method, Integer counter) {
			this.method = method;
			this.counter = counter;
		}

		public int compareTo(InfoPair o) {
			int result = o.counter.compareTo(this.counter);
			if (result == 0) result = o.method.compareTo(this.method);
			return result;
		}
		
	}
	public Vector<String> getOperationCounterInfos() {
		TreeSet<InfoPair> sorter = new TreeSet<InfoPair>();
		for (String key : this.operationCounters.keySet()) {
			sorter.add(new InfoPair(key,this.operationCounters.get(key)));
		}
		Vector<String> result = new Vector<String>();
		for (InfoPair current : sorter) {
			result.add(current.method + " :  " + current.counter);
		}
		return result;
	}
	
}
