package persistence;

import model.*;

public class CompoundUnitFacade{



	public CompoundUnitFacade() {
	}

    public CompoundUnitProxi newCompoundUnit(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        CompoundUnit result = new CompoundUnit(name,null,id);
        Cache.getTheCache().put(result);
        return (CompoundUnitProxi)PersistentProxi.createProxi(id, 122);
    }
    
    public CompoundUnit getCompoundUnit(long CompoundUnitId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

