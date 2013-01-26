package persistence;

import model.*;

public class ErrorDisplayFacade{

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

	

	public ErrorDisplayFacade() {
	}

    public ErrorDisplayProxi newErrorDisplay(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (ErrorDisplayProxi)PersistentProxi.createProxi(createMinusStorePlus, -123);
        long id = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getNextId();
        ErrorDisplay result = new ErrorDisplay(id);
        Cache.getTheCache().put(result);
        return (ErrorDisplayProxi)PersistentProxi.createProxi(id, -123);
    }
    
    public ErrorDisplayProxi newDelayedErrorDisplay() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getNextId();
        ErrorDisplay result = new ErrorDisplay(id);
        Cache.getTheCache().put(result);
        return (ErrorDisplayProxi)PersistentProxi.createProxi(id, -123);
    }
    
    public ErrorDisplay getErrorDisplay(long ErrorDisplayId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -123)) return -123;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }

}

