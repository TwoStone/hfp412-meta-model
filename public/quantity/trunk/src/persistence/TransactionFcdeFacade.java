package persistence;

import model.*;

public class TransactionFcdeFacade{

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

	

	public TransactionFcdeFacade() {
	}

    public TransactionFcdeProxi getTheTransactionFcde() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTransactionFcdeFacade.getNextId();
        TransactionFcde result = new TransactionFcde(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (TransactionFcdeProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 104);
    }
    
    public TransactionFcde getTransactionFcde(long TransactionFcdeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 104)) return 104;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long TransactionFcdeId, PersistentTransactionFcde ThisVal) throws PersistenceException {
        
    }

}

