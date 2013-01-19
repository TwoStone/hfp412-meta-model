package persistence;

import model.basic.*;

public class MTrueFacade{



	public MTrueFacade() {
	}

    public MTrueProxi getTheMTrue() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMBooleanFacade.getNextId();
        MTrue result = new MTrue(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (MTrueProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 190);
    }
    
    public MTrue getMTrue(long MTrueId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

