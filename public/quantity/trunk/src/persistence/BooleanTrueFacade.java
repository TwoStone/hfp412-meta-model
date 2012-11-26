package persistence;

import model.*;

public class BooleanTrueFacade{



	public BooleanTrueFacade() {
	}

    public BooleanTrueProxi getTheBooleanTrue() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBooleanValueFacade.getNextId();
        BooleanTrue result = new BooleanTrue(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (BooleanTrueProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 142);
    }
    
    public BooleanTrue getBooleanTrue(long BooleanTrueId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

