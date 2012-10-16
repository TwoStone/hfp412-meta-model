package persistence;

import model.*;

public class PositionFacade{

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

	

	public PositionFacade() {
	}

    public PositionProxi newPosition(long amount) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thePositionFacade.getNextId();
        Position result = new Position(null,amount,null,id);
        Cache.getTheCache().put(result);
        return (PositionProxi)PersistentProxi.createProxi(id, 133);
    }
    
    public Position getPosition(long PositionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 133)) return 133;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void relateToSet(long PositionId, PersistentProduct relateToVal) throws PersistenceException {
        
    }
    public void amountSet(long PositionId, long amountVal) throws PersistenceException {
        
    }
    public void ThisSet(long PositionId, PersistentPosition ThisVal) throws PersistenceException {
        
    }

}

