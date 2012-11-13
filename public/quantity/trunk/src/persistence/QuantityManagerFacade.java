package persistence;

import model.*;

public class QuantityManagerFacade{

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

	

	public QuantityManagerFacade() {
	}

    public QuantityManagerProxi getTheQuantityManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.getNextId();
        QuantityManager result = new QuantityManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (QuantityManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 104);
    }
    
    public QuantityManager getQuantityManager(long QuantityManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 104)) return 104;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long quantitiesAdd(long QuantityManagerId, PersistentAbsQuantity quantitiesVal) throws PersistenceException {
        return 0;
    }
    public void quantitiesRem(long quantitiesId) throws PersistenceException {
        
    }
    public AbsQuantityList quantitiesGet(long QuantityManagerId) throws PersistenceException {
        return new AbsQuantityList(); // remote access for initialization only!
    }
    public void ThisSet(long QuantityManagerId, PersistentQuantityManager ThisVal) throws PersistenceException {
        
    }

}

