package persistence;

import model.*;

public class MSumTypeFacade{



	public MSumTypeFacade() {
	}

    public MSumTypeProxi newMSumType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MSumType result = new MSumType(null,id);
        Cache.getTheCache().put(result);
        return (MSumTypeProxi)PersistentProxi.createProxi(id, 103);
    }
    
    public MSumType getMSumType(long MSumTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

