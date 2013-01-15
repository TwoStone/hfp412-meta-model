package persistence;

import model.meta.*;

public class AddSubTypeCommandFacade{

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

	

	public AddSubTypeCommandFacade() {
	}

    public AddSubTypeCommandProxi newAddSubTypeCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddSubTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 133);
        long id = ConnectionHandler.getTheConnectionHandler().theAddSubTypeCommandFacade.getNextId();
        AddSubTypeCommand result = new AddSubTypeCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddSubTypeCommandProxi)PersistentProxi.createProxi(id, 133);
    }
    
    public AddSubTypeCommandProxi newDelayedAddSubTypeCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddSubTypeCommandFacade.getNextId();
        AddSubTypeCommand result = new AddSubTypeCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddSubTypeCommandProxi)PersistentProxi.createProxi(id, 133);
    }
    
    public AddSubTypeCommand getAddSubTypeCommand(long AddSubTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 133)) return 133;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void superTypeSet(long AddSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        
    }
    public void subTypeSet(long AddSubTypeCommandId, PersistentMAtomicType subTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

