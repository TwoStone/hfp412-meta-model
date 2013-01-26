package persistence;

import model.meta.*;

public class CreateConstantCommandFacade{

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

	

	public CreateConstantCommandFacade() {
	}

    public CreateConstantCommandProxi newCreateConstantCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateConstantCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 140);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConstantCommandFacade.getNextId();
        CreateConstantCommand result = new CreateConstantCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConstantCommandProxi)PersistentProxi.createProxi(id, 140);
    }
    
    public CreateConstantCommandProxi newDelayedCreateConstantCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConstantCommandFacade.getNextId();
        CreateConstantCommand result = new CreateConstantCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConstantCommandProxi)PersistentProxi.createProxi(id, 140);
    }
    
    public CreateConstantCommand getCreateConstantCommand(long CreateConstantCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 140)) return 140;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateConstantCommandId, String nameVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateConstantCommandId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateConstantCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateConstantCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateConstantCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

