package persistence;

import model.*;

public class UnitReferenceFacade{



	public UnitReferenceFacade() {
	}

    public UnitReferenceProxi newUnitReference(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbsUnitFacade.getNextId();
        UnitReference result = new UnitReference(name,null,id);
        Cache.getTheCache().put(result);
        return (UnitReferenceProxi)PersistentProxi.createProxi(id, 119);
    }
    
    public UnitReference getUnitReference(long UnitReferenceId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

