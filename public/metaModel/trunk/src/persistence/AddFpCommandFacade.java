package persistence;

import model.meta.*;

public class AddFpCommandFacade{

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

	

	public AddFpCommandFacade() {
	}

    public AddFpCommandProxi newAddFpCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddFpCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 167);
        long id = ConnectionHandler.getTheConnectionHandler().theAddFpCommandFacade.getNextId();
        AddFpCommand result = new AddFpCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddFpCommandProxi)PersistentProxi.createProxi(id, 167);
    }
    
    public AddFpCommandProxi newDelayedAddFpCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddFpCommandFacade.getNextId();
        AddFpCommand result = new AddFpCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddFpCommandProxi)PersistentProxi.createProxi(id, 167);
    }
    
    public AddFpCommand getAddFpCommand(long AddFpCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 167)) return 167;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void opSet(long AddFpCommandId, PersistentOperation opVal) throws PersistenceException {
        
    }
    public void fpSet(long AddFpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddFpCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

