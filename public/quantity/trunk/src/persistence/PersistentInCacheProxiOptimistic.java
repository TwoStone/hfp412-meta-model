package persistence;

import java.util.Hashtable;
import java.util.Iterator;

public abstract class PersistentInCacheProxiOptimistic extends PersistentInCacheProxi {

	protected Hashtable<CommitConnectionHandler, PersistentObject> copies;
	
	protected PersistentInCacheProxiOptimistic(long id) {
		super(id);
		this.copies = new Hashtable<CommitConnectionHandler, PersistentObject>();
	}
	protected PersistentInCacheProxiOptimistic(PersistentObject object) {
		super(object);
		this.copies = new Hashtable<CommitConnectionHandler, PersistentObject>();
	}

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (ConnectionHandler.isCommitConnectionHandler()){
			CommitConnectionHandler connectionHandler = (CommitConnectionHandler) ConnectionHandler.getTheConnectionHandler();
			PersistentObject localCopy = this.copies.get(connectionHandler);
			if (localCopy != null) return localCopy;
			PersistentObject result = this.object;
			if(result == null) result = getRemote();
			else result = result.provideCopy();
			this.copies.put(connectionHandler, result);
			connectionHandler.addObject(this);
			return result;
		}
		return super.getTheObject();
	}
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		if(ConnectionHandler.isCommitConnectionHandler()){
			this.copies.put((CommitConnectionHandler) ConnectionHandler.getTheConnectionHandler(), object);
			((CommitConnectionHandler)ConnectionHandler.getTheConnectionHandler()).addObject(this);
		}else{
			super.setObject(object);
		}
	}
			
	protected synchronized void clear() throws PersistenceException {
		if (ConnectionHandler.isCommitConnectionHandler()){
			CommitConnectionHandler connectionHandler = (CommitConnectionHandler) ConnectionHandler.getTheConnectionHandler();
			this.copies.put(connectionHandler,getRemote());
		}else{
			this.object = null;
		}
	}

	protected synchronized void commit() {
		try {
			PersistentObject original = this.copies.get(ConnectionHandler.getTheConnectionHandler());
			this.copies.remove(ConnectionHandler.getTheConnectionHandler());
			this.object = original;
			Iterator<CommitConnectionHandler> tooLateTransactions = this.copies.keySet().iterator();
			while (tooLateTransactions.hasNext()){
				tooLateTransactions.next().setUncommitable();
			}
			if(this.isRemovable())Cache.getTheCache().remove(this);
		} catch (PersistenceException e) {
			throw new Error("Commit can only be performed by CommitConnectionHandler that exists already!");
		}
	}
	protected synchronized void rollBack() {
		try {
			this.copies.remove(ConnectionHandler.getTheConnectionHandler());
			if(this.isRemovable())Cache.getTheCache().remove(this);
		} catch (PersistenceException e) {
			throw new Error("Roll-back only performed by CommitConnectionHandler that exist already!");
		}
	}
	protected boolean isRemovable() {
		return super.isRemovable() && this.copies.isEmpty();
	}
	public synchronized void tryBreak() {
		try {
			if(!this.isDelayed$Persistence() && this.copies.isEmpty())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}


}
