package persistence;

import model.*;

public class UnitTypeFacade{



	public UnitTypeFacade() {
	}

    public UnitTypeProxi newUnitType(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (UnitTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 107);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        UnitType result = new UnitType(null,name,null,id);
        Cache.getTheCache().put(result);
        return (UnitTypeProxi)PersistentProxi.createProxi(id, 107);
    }
    
    public UnitTypeProxi newDelayedUnitType(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        UnitType result = new UnitType(null,name,null,id);
        Cache.getTheCache().put(result);
        return (UnitTypeProxi)PersistentProxi.createProxi(id, 107);
    }
    
    public UnitType getUnitType(long UnitTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

