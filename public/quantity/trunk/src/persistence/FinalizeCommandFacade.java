package persistence;

import model.meta.*;

public class FinalizeCommandFacade{

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

	

	public FinalizeCommandFacade() {
	}

    public FinalizeCommandProxi newFinalizeCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (FinalizeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 145);
        long id = ConnectionHandler.getTheConnectionHandler().theFinalizeCommandFacade.getNextId();
        FinalizeCommand result = new FinalizeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (FinalizeCommandProxi)PersistentProxi.createProxi(id, 145);
    }
    
    public FinalizeCommandProxi newDelayedFinalizeCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theFinalizeCommandFacade.getNextId();
        FinalizeCommand result = new FinalizeCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (FinalizeCommandProxi)PersistentProxi.createProxi(id, 145);
    }
    
    public FinalizeCommand getFinalizeCommand(long FinalizeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 145)) return 145;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void compUnitTypeSet(long FinalizeCommandId, PersistentCompUnitType compUnitTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long FinalizeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long FinalizeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long FinalizeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

