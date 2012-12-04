package persistence;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class CommitConnectionHandler extends ConnectionHandler{

	private static Object serializer = new Object();
	
	private Collection<PersistentInCacheProxiOptimistic> readOrWrittenObjects;
	private boolean commitable;
	private boolean inTransaction;
	
	protected CommitConnectionHandler() throws PersistenceException {
		super();
		this.readOrWrittenObjects = new Vector<PersistentInCacheProxiOptimistic>();
		this.commitable = true;
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
				this.commitServer();
				this.beginWork();
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
			this.rollbackServer();
			this.beginWork(); 
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
