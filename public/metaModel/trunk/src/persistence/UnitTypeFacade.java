package persistence;

import model.quantity.*;

public class UnitTypeFacade{



	public UnitTypeFacade() {
	}

    public UnitTypeProxi newUnitType(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (UnitTypeProxi)PersistentProxi.createProxi(createMinusStorePlus, 152);
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        UnitType result = new UnitType(name,null,null,id);
        Cache.getTheCache().put(result);
        return (UnitTypeProxi)PersistentProxi.createProxi(id, 152);
    }
    
    public UnitTypeProxi newDelayedUnitType(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        UnitType result = new UnitType(name,null,null,id);
        Cache.getTheCache().put(result);
        return (UnitTypeProxi)PersistentProxi.createProxi(id, 152);
    }
    
    public UnitType getUnitType(long UnitTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void defaultUnitSet(long UnitTypeId, PersistentUnit defaultUnitVal) throws PersistenceException {
        
    }

}

