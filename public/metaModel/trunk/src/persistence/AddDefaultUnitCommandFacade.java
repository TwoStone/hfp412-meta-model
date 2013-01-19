package persistence;

import model.meta.*;

public class AddDefaultUnitCommandFacade{

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

	

	public AddDefaultUnitCommandFacade() {
	}

    public AddDefaultUnitCommandProxi newAddDefaultUnitCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddDefaultUnitCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 109);
        long id = ConnectionHandler.getTheConnectionHandler().theAddDefaultUnitCommandFacade.getNextId();
        AddDefaultUnitCommand result = new AddDefaultUnitCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddDefaultUnitCommandProxi)PersistentProxi.createProxi(id, 109);
    }
    
    public AddDefaultUnitCommandProxi newDelayedAddDefaultUnitCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddDefaultUnitCommandFacade.getNextId();
        AddDefaultUnitCommand result = new AddDefaultUnitCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddDefaultUnitCommandProxi)PersistentProxi.createProxi(id, 109);
    }
    
    public AddDefaultUnitCommand getAddDefaultUnitCommand(long AddDefaultUnitCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 109)) return 109;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long AddDefaultUnitCommandId, PersistentAbsUnitType typeVal) throws PersistenceException {
        
    }
    public void unitSet(long AddDefaultUnitCommandId, PersistentAbsUnit unitVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddDefaultUnitCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddDefaultUnitCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddDefaultUnitCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

