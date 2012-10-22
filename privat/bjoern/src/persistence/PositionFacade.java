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

    public PositionProxi newPosition() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thePositionFacade.getNextId();
        Position result = new Position(null,null,id);
        Cache.getTheCache().put(result);
        return (PositionProxi)PersistentProxi.createProxi(id, 123);
    }
    
    public Position getPosition(long PositionId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 123)) return 123;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void beziehtSichAufSet(long PositionId, PersistentProdukt beziehtSichAufVal) throws PersistenceException {
        
    }
    public void ThisSet(long PositionId, PersistentPosition ThisVal) throws PersistenceException {
        
    }

}

