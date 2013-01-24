package persistence;

import model.typeSystem.*;

public class ObjectManagerFacade{

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

	

	public ObjectManagerFacade() {
	}

    public ObjectManagerProxi getTheObjectManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade.getNextId();
        ObjectManager result = new ObjectManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (ObjectManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 237);
    }
    
    public ObjectManager getObjectManager(long ObjectManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 237)) return 237;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long objectsAdd(long ObjectManagerId, PersistentMObject objectsVal) throws PersistenceException {
        return 0;
    }
    public void objectsRem(long objectsId) throws PersistenceException {
        
    }
    public MObjectList objectsGet(long ObjectManagerId) throws PersistenceException {
        return new MObjectList(); // remote access for initialization only!
    }
    public void ThisSet(long ObjectManagerId, PersistentObjectManager ThisVal) throws PersistenceException {
        
    }

}

