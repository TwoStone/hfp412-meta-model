package persistence;

import model.*;

public class TransactionManagerFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public TransactionManagerFacade() {
	}

    public TransactionManagerProxi getTheTransactionManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTransactionManagerFacade.getNextId();
        TransactionManager result = new TransactionManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (TransactionManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 129);
    }
    
    public TransactionManager getTransactionManager(long TransactionManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 129)) return 129;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long akteureAdd(long TransactionManagerId, PersistentAkteur akteureVal) throws PersistenceException {
        return 0;
    }
    public void akteureRem(long akteureId) throws PersistenceException {
        
    }
    public AkteurList akteureGet(long TransactionManagerId) throws PersistenceException {
        return new AkteurList(); // remote access for initialization only!
    }
    public void ThisSet(long TransactionManagerId, PersistentTransactionManager ThisVal) throws PersistenceException {
        
    }

}

