package persistence;

import model.typeSystem.*;

public class TypeManagerFacade{

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

	

	public TypeManagerFacade() {
	}

    public TypeManagerProxi getTheTypeManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.getNextId();
        TypeManager result = new TypeManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (TypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 167);
    }
    
    public TypeManager getTypeManager(long TypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 167)) return 167;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long typesAdd(long TypeManagerId, PersistentMType typesVal) throws PersistenceException {
        return 0;
    }
    public void typesRem(long typesId) throws PersistenceException {
        
    }
    public MTypeList typesGet(long TypeManagerId) throws PersistenceException {
        return new MTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long TypeManagerId, PersistentTypeManager ThisVal) throws PersistenceException {
        
    }

}

