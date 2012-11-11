package persistence;

import model.*;

public class UnitFacade{



	public UnitFacade() {
	}

    public UnitProxi newUnit(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (UnitProxi)PersistentProxi.createProxi(createMinusStorePlus, 112);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        Unit result = new Unit(null,name,null,id);
        Cache.getTheCache().put(result);
        return (UnitProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public UnitProxi newDelayedUnit(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        Unit result = new Unit(null,name,null,id);
        Cache.getTheCache().put(result);
        return (UnitProxi)PersistentProxi.createProxi(id, 112);
    }
    
    public Unit getUnit(long UnitId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

