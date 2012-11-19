package persistence;

import model.meta.*;

public class AddReferenceTypeCommandFacade{

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

	

	public AddReferenceTypeCommandFacade() {
	}

    public AddReferenceTypeCommandProxi newAddReferenceTypeCommand(long exponent,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddReferenceTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 142);
        long id = ConnectionHandler.getTheConnectionHandler().theAddReferenceTypeCommandFacade.getNextId();
        AddReferenceTypeCommand result = new AddReferenceTypeCommand(null,null,exponent,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddReferenceTypeCommandProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public AddReferenceTypeCommandProxi newDelayedAddReferenceTypeCommand(long exponent) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddReferenceTypeCommandFacade.getNextId();
        AddReferenceTypeCommand result = new AddReferenceTypeCommand(null,null,exponent,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddReferenceTypeCommandProxi)PersistentProxi.createProxi(id, 142);
    }
    
    public AddReferenceTypeCommand getAddReferenceTypeCommand(long AddReferenceTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 142)) return 142;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void compUnitTypeSet(long AddReferenceTypeCommandId, PersistentCompUnitType compUnitTypeVal) throws PersistenceException {
        
    }
    public void unitTypeSet(long AddReferenceTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        
    }
    public void exponentSet(long AddReferenceTypeCommandId, long exponentVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddReferenceTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddReferenceTypeCommandId, PersistentUnitTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddReferenceTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

