package persistence;

import model.*;

public class UnitTypeManagerFacade{

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

	

	public UnitTypeManagerFacade() {
	}

    public UnitTypeManagerProxi getTheUnitTypeManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.getNextId();
        UnitTypeManager result = new UnitTypeManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (UnitTypeManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 118);
    }
    
    public UnitTypeManager getUnitTypeManager(long UnitTypeManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 118)) return 118;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long unitTypesAdd(long UnitTypeManagerId, PersistentAbsUnitType unitTypesVal) throws PersistenceException {
        return 0;
    }
    public void unitTypesRem(long unitTypesId) throws PersistenceException {
        
    }
    public AbsUnitTypeList unitTypesGet(long UnitTypeManagerId) throws PersistenceException {
        return new AbsUnitTypeList(); // remote access for initialization only!
    }
    public long unitsAdd(long UnitTypeManagerId, PersistentAbsUnit unitsVal) throws PersistenceException {
        return 0;
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        
    }
    public AbsUnitList unitsGet(long UnitTypeManagerId) throws PersistenceException {
        return new AbsUnitList(); // remote access for initialization only!
    }
    public void ThisSet(long UnitTypeManagerId, PersistentUnitTypeManager ThisVal) throws PersistenceException {
        
    }

}

