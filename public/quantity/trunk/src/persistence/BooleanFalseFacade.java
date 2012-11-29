package persistence;

import model.*;

public class BooleanFalseFacade{



	public BooleanFalseFacade() {
	}

    public BooleanFalseProxi getTheBooleanFalse() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBooleanValueFacade.getNextId();
        BooleanFalse result = new BooleanFalse(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (BooleanFalseProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 127);
    }
    
    public BooleanFalse getBooleanFalse(long BooleanFalseId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

