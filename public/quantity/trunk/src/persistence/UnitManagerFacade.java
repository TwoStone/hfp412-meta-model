package persistence;

import model.*;

public class UnitManagerFacade{

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

	

	public UnitManagerFacade() {
	}

    public UnitManagerProxi getTheUnitManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theUnitManagerFacade.getNextId();
        UnitManager result = new UnitManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (UnitManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 119);
    }
    
    public UnitManager getUnitManager(long UnitManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 119)) return 119;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long unitsAdd(long UnitManagerId, PersistentAbsUnit unitsVal) throws PersistenceException {
        return 0;
    }
    public void unitsRem(long unitsId) throws PersistenceException {
        
    }
    public AbsUnitList unitsGet(long UnitManagerId) throws PersistenceException {
        return new AbsUnitList(); // remote access for initialization only!
    }
    public void ThisSet(long UnitManagerId, PersistentUnitManager ThisVal) throws PersistenceException {
        
    }

}

