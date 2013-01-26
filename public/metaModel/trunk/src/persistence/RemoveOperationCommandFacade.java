package persistence;

import model.meta.*;

public class RemoveOperationCommandFacade{

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

	

	public RemoveOperationCommandFacade() {
	}

    public RemoveOperationCommandProxi newRemoveOperationCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveOperationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 228);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.getNextId();
        RemoveOperationCommand result = new RemoveOperationCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveOperationCommandProxi)PersistentProxi.createProxi(id, 228);
    }
    
    public RemoveOperationCommandProxi newDelayedRemoveOperationCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveOperationCommandFacade.getNextId();
        RemoveOperationCommand result = new RemoveOperationCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveOperationCommandProxi)PersistentProxi.createProxi(id, 228);
    }
    
    public RemoveOperationCommand getRemoveOperationCommand(long RemoveOperationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 228)) return 228;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void opSet(long RemoveOperationCommandId, PersistentOperation opVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveOperationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

