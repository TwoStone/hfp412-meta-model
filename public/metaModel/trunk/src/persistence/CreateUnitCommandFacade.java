package persistence;

import model.meta.*;

public class CreateUnitCommandFacade{

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

	

	public CreateUnitCommandFacade() {
	}

    public CreateUnitCommandProxi newCreateUnitCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateUnitCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 173);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateUnitCommandFacade.getNextId();
        CreateUnitCommand result = new CreateUnitCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateUnitCommandProxi)PersistentProxi.createProxi(id, 173);
    }
    
    public CreateUnitCommandProxi newDelayedCreateUnitCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateUnitCommandFacade.getNextId();
        CreateUnitCommand result = new CreateUnitCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateUnitCommandProxi)PersistentProxi.createProxi(id, 173);
    }
    
    public CreateUnitCommand getCreateUnitCommand(long CreateUnitCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 173)) return 173;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateUnitCommandId, String nameVal) throws PersistenceException {
        
    }
    public void typeSet(long CreateUnitCommandId, PersistentUnitType typeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateUnitCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateUnitCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateUnitCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

