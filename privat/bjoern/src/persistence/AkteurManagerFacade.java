package persistence;

import model.*;

public class AkteurManagerFacade{

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

	

	public AkteurManagerFacade() {
	}

    public AkteurManagerProxi getTheAkteurManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAkteurManagerFacade.getNextId();
        AkteurManager result = new AkteurManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (AkteurManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 117);
    }
    
    public AkteurManager getAkteurManager(long AkteurManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 117)) return 117;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long akteureAdd(long AkteurManagerId, PersistentAkteur akteureVal) throws PersistenceException {
        return 0;
    }
    public void akteureRem(long akteureId) throws PersistenceException {
        
    }
    public AkteurList akteureGet(long AkteurManagerId) throws PersistenceException {
        return new AkteurList(); // remote access for initialization only!
    }
    public void ThisSet(long AkteurManagerId, PersistentAkteurManager ThisVal) throws PersistenceException {
        
    }

}

