package persistence;

import model.*;

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
        return (TypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 101);
    }
    
    public TypeManager getTypeManager(long TypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 101)) return 101;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long unitTypesAdd(long TypeManagerId, PersistentAbsUnitType unitTypesVal) throws PersistenceException {
        return 0;
    }
    public void unitTypesRem(long unitTypesId) throws PersistenceException {
        
    }
    public AbsUnitTypeList unitTypesGet(long TypeManagerId) throws PersistenceException {
        return new AbsUnitTypeList(); // remote access for initialization only!
    }
    public void ThisSet(long TypeManagerId, PersistentTypeManager ThisVal) throws PersistenceException {
        
    }

}

