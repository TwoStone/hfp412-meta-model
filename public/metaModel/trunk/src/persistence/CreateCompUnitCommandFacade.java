package persistence;

import model.meta.*;

public class CreateCompUnitCommandFacade{

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

	

	public CreateCompUnitCommandFacade() {
	}

    public CreateCompUnitCommandProxi newCreateCompUnitCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateCompUnitCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 159);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateCompUnitCommandFacade.getNextId();
        CreateCompUnitCommand result = new CreateCompUnitCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateCompUnitCommandProxi)PersistentProxi.createProxi(id, 159);
    }
    
    public CreateCompUnitCommandProxi newDelayedCreateCompUnitCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateCompUnitCommandFacade.getNextId();
        CreateCompUnitCommand result = new CreateCompUnitCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateCompUnitCommandProxi)PersistentProxi.createProxi(id, 159);
    }
    
    public CreateCompUnitCommand getCreateCompUnitCommand(long CreateCompUnitCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 159)) return 159;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateCompUnitCommandId, String nameVal) throws PersistenceException {
        
    }
    public void typeSet(long CreateCompUnitCommandId, PersistentCompUnitType typeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateCompUnitCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateCompUnitCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateCompUnitCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

