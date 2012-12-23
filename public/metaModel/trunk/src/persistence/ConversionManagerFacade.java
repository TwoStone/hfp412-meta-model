package persistence;

import model.quantity.*;

public class ConversionManagerFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public ConversionManagerFacade() {
	}

    public ConversionManagerProxi getTheConversionManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theConversionManagerFacade.getNextId();
        ConversionManager result = new ConversionManager(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (ConversionManagerProxi)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().equals(result) ? -1 : 1), 169);
    }
    
    public ConversionManager getConversionManager(long ConversionManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 169)) return 169;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long conversionsAdd(long ConversionManagerId, PersistentConversion conversionsVal) throws PersistenceException {
        return 0;
    }
    public void conversionsRem(long conversionsId) throws PersistenceException {
        
    }
    public ConversionList conversionsGet(long ConversionManagerId) throws PersistenceException {
        return new ConversionList(); // remote access for initialization only!
    }
    public void ThisSet(long ConversionManagerId, PersistentConversionManager ThisVal) throws PersistenceException {
        
    }

}

