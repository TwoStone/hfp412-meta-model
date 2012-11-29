package persistence;

import model.meta.*;

public class CreateCompUnitTypeCommandFacade{

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

	

	public CreateCompUnitTypeCommandFacade() {
	}

    public CreateCompUnitTypeCommandProxi newCreateCompUnitTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateCompUnitTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 116);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateCompUnitTypeCommandFacade.getNextId();
        CreateCompUnitTypeCommand result = new CreateCompUnitTypeCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateCompUnitTypeCommandProxi)PersistentProxi.createProxi(id, 116);
    }
    
    public CreateCompUnitTypeCommandProxi newDelayedCreateCompUnitTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateCompUnitTypeCommandFacade.getNextId();
        CreateCompUnitTypeCommand result = new CreateCompUnitTypeCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateCompUnitTypeCommandProxi)PersistentProxi.createProxi(id, 116);
    }
    
    public CreateCompUnitTypeCommand getCreateCompUnitTypeCommand(long CreateCompUnitTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 116)) return 116;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateCompUnitTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateCompUnitTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateCompUnitTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateCompUnitTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

