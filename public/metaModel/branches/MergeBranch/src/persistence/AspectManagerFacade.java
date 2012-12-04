package persistence;

import model.*;

public class AspectManagerFacade{

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

	

	public AspectManagerFacade() {
	}

    public AspectManagerProxi getTheAspectManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.getNextId();
        AspectManager result = new AspectManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (AspectManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 126);
    }
    
    public AspectManager getAspectManager(long AspectManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 126)) return 126;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long aspectsAdd(long AspectManagerId, PersistentMAspect aspectsVal) throws PersistenceException {
        return 0;
    }
    public void aspectsRem(long aspectsId) throws PersistenceException {
        
    }
    public MAspectList aspectsGet(long AspectManagerId) throws PersistenceException {
        return new MAspectList(); // remote access for initialization only!
    }
    public void ThisSet(long AspectManagerId, PersistentAspectManager ThisVal) throws PersistenceException {
        
    }

}

