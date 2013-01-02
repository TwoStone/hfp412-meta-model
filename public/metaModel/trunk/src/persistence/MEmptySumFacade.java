package persistence;

import model.*;

public class MEmptySumFacade{



	public MEmptySumFacade() {
	}

    public MEmptySumProxi getTheMEmptySum() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMComplexTypeFacade.getNextId();
        MEmptySum result = new MEmptySum(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MEmptySumProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 185);
    }
    
    public MEmptySum getMEmptySum(long MEmptySumId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

