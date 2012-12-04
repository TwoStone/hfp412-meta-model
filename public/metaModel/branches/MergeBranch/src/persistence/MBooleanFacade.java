package persistence;

import model.*;

public class MBooleanFacade{

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

	

	public MBooleanFacade() {
	}

    public MBooleanProxi getTheMBoolean() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMBooleanFacade.getNextId();
        MBoolean result = new MBoolean(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MBooleanProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 137);
    }
    
    public MBoolean getMBoolean(long MBooleanId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 136)) return 136;
        if(Cache.getTheCache().contains(objectId, 138)) return 138;
        if(Cache.getTheCache().contains(objectId, 137)) return 137;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MBooleanId, PersistentMBoolean ThisVal) throws PersistenceException {
        
    }

}

