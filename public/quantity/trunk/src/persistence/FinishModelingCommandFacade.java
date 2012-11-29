package persistence;

import model.meta.*;

public class FinishModelingCommandFacade{

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

	

	public FinishModelingCommandFacade() {
	}

    public FinishModelingCommandProxi newFinishModelingCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (FinishModelingCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 101);
        long id = ConnectionHandler.getTheConnectionHandler().theFinishModelingCommandFacade.getNextId();
        FinishModelingCommand result = new FinishModelingCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (FinishModelingCommandProxi)PersistentProxi.createProxi(id, 101);
    }
    
    public FinishModelingCommandProxi newDelayedFinishModelingCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFinishModelingCommandFacade.getNextId();
        FinishModelingCommand result = new FinishModelingCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (FinishModelingCommandProxi)PersistentProxi.createProxi(id, 101);
    }
    
    public FinishModelingCommand getFinishModelingCommand(long FinishModelingCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 101)) return 101;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void compUnitTypeSet(long FinishModelingCommandId, PersistentCompUnitType compUnitTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long FinishModelingCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long FinishModelingCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long FinishModelingCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

