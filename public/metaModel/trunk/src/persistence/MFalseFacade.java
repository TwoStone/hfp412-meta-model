package persistence;

import model.basic.*;

public class MFalseFacade{



	public MFalseFacade() {
	}

    public MFalseProxi getTheMFalse() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMBooleanFacade.getNextId();
        MFalse result = new MFalse(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MFalseProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 183);
    }
    
    public MFalse getMFalse(long MFalseId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

