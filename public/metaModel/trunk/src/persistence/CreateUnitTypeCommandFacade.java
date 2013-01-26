package persistence;

import model.meta.*;

public class CreateUnitTypeCommandFacade{

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

	

	public CreateUnitTypeCommandFacade() {
	}

    public CreateUnitTypeCommandProxi newCreateUnitTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateUnitTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 102);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateUnitTypeCommandFacade.getNextId();
        CreateUnitTypeCommand result = new CreateUnitTypeCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateUnitTypeCommandProxi)PersistentProxi.createProxi(id, 102);
    }
    
    public CreateUnitTypeCommandProxi newDelayedCreateUnitTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateUnitTypeCommandFacade.getNextId();
        CreateUnitTypeCommand result = new CreateUnitTypeCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateUnitTypeCommandProxi)PersistentProxi.createProxi(id, 102);
    }
    
    public CreateUnitTypeCommand getCreateUnitTypeCommand(long CreateUnitTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 102)) return 102;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateUnitTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateUnitTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateUnitTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateUnitTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

