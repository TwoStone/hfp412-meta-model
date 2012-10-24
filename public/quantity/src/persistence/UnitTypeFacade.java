package persistence;

import model.*;

public class UnitTypeFacade{



	public UnitTypeFacade() {
	}

    public UnitTypeProxi newUnitType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        UnitType result = new UnitType(null,null,id);
        Cache.getTheCache().put(result);
        return (UnitTypeProxi)PersistentProxi.createProxi(id, 117);
    }
    
    public UnitType getUnitType(long UnitTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void defaultUnitSet(long UnitTypeId, PersistentUnit defaultUnitVal) throws PersistenceException {
        
    }

}

