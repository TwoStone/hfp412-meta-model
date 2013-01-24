package persistence;

import model.meta.*;

public class CreateFpCommandFacade{

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

	

	public CreateFpCommandFacade() {
	}

    public CreateFpCommandProxi newCreateFpCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateFpCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 199);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateFpCommandFacade.getNextId();
        CreateFpCommand result = new CreateFpCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateFpCommandProxi)PersistentProxi.createProxi(id, 199);
    }
    
    public CreateFpCommandProxi newDelayedCreateFpCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateFpCommandFacade.getNextId();
        CreateFpCommand result = new CreateFpCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateFpCommandProxi)PersistentProxi.createProxi(id, 199);
    }
    
    public CreateFpCommand getCreateFpCommand(long CreateFpCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 199)) return 199;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateFpCommandId, String nameVal) throws PersistenceException {
        
    }
    public void ofTypeSet(long CreateFpCommandId, PersistentMType ofTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateFpCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateFpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateFpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

