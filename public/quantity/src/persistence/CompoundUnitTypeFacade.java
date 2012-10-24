package persistence;

import model.*;

public class CompoundUnitTypeFacade{



	public CompoundUnitTypeFacade() {
	}

    public CompoundUnitTypeProxi newCompoundUnitType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitTypeFacade.getNextId();
        CompoundUnitType result = new CompoundUnitType(null,id);
        Cache.getTheCache().put(result);
        return (CompoundUnitTypeProxi)PersistentProxi.createProxi(id, 114);
    }
    
    public CompoundUnitType getCompoundUnitType(long CompoundUnitTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

