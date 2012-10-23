package persistence;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class CommitConnectionHandler extends ConnectionHandler{

	private static Object serializer = new Object();
	
	private Collection<PersistentInCacheProxiOptimistic> readOrWrittenObjects;
	private boolean commitable;
	private boolean inTransaction;
	
	protected CommitConnectionHandler(String name) throws PersistenceException {
		super(name);
		this.readOrWrittenObjects = new Vector<PersistentInCacheProxiOptimistic>();
		this.commitable = true;
		this.inTransaction = false;
	}
	public void setInTransaction(boolean inTransaction){
		this.inTransaction = inTransaction;
	}
	public boolean isInTransaction(){
		return this.inTransaction;
	}
	public void addObject(PersistentInCacheProxiOptimistic proxi){
		this.readOrWrittenObjects.add(proxi);
	}
	protected Iterator<PersistentInCacheProxiOptimistic> iterator(){
		return this.readOrWrittenObjects.iterator();
	}
	public void beginWork(){
		this.readOrWrittenObjects.clear();
	}
	public void commit() throws PersistenceException {
		synchronized (serializer){
			if (this.commitable){
				try {
					this.con.commit();
					this.commitServer();
					this.beginWork();
				} catch (SQLException sqlExc) {
					this.rollback();
					throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
				}
			}else{
				throw new ConflictException();
			}
		}
	}
	private void commitServer(){
		Iterator<PersistentInCacheProxiOptimistic> copies = this.iterator();
		while (copies.hasNext()){
			PersistentInCacheProxiOptimistic current = copies.next();
			current.commit();
		}
	}
	public void rollback() throws PersistenceException{
		synchronized (serializer){
			try {
				this.con.rollback();
				this.rollbackServer();
				this.beginWork();
			} catch (SQLException sqlExc) {
				this.rollbackServer();
				throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
			} 
		}
	}

	private void rollbackServer(){
		Iterator<PersistentInCacheProxiOptimistic> copies = this.iterator();
		while (copies.hasNext()){
			PersistentInCacheProxiOptimistic current = copies.next();
			current.rollBack();
		}		
	}
	public void setUncommitable() {
		this.commitable = false;
	}
	private Command command;
	public void setCommand(Command command) {
		this.command = command;
	}
	public Command getCommand(){
		return this.command;
	}
}
