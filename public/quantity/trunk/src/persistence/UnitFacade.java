package persistence;

import model.*;

public class UnitFacade{



	public UnitFacade() {
	}

    public UnitProxi newUnit(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        Unit result = new Unit(name,null,null,id);
        Cache.getTheCache().put(result);
        return (UnitProxi)PersistentProxi.createProxi(id, 118);
    }
    
    public Unit getUnit(long UnitId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void unitTypeSet(long UnitId, PersistentUnitType unitTypeVal) throws PersistenceException {
        
    }

}

