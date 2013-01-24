package persistence;

import model.quantity.*;

public class FractionManagerFacade{

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

	

	public FractionManagerFacade() {
	}

    public FractionManagerProxi getTheFractionManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFractionManagerFacade.getNextId();
        FractionManager result = new FractionManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (FractionManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 175);
    }
    
    public FractionManager getFractionManager(long FractionManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 175)) return 175;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long FractionManagerId, PersistentFractionManager ThisVal) throws PersistenceException {
        
    }

}

