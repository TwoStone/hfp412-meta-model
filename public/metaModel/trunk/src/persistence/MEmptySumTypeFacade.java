package persistence;

import model.typeSystem.*;

public class MEmptySumTypeFacade{



	public MEmptySumTypeFacade() {
	}

    public MEmptySumTypeProxi getTheMEmptySumType() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MEmptySumType result = new MEmptySumType(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MEmptySumTypeProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 190);
    }
    
    public MEmptySumType getMEmptySumType(long MEmptySumTypeId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

