package persistence;

import model.typeSystem.*;

public class MEmptyProductFacade{



	public MEmptyProductFacade() {
	}

    public MEmptyProductProxi getTheMEmptyProduct() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getNextId();
        MEmptyProduct result = new MEmptyProduct(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MEmptyProductProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 108);
    }
    
    public MEmptyProduct getMEmptyProduct(long MEmptyProductId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

