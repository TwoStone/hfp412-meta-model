package persistence;

import model.meta.*;

public class CreateAtomicSubTypeCommandFacade{

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

	

	public CreateAtomicSubTypeCommandFacade() {
	}

    public CreateAtomicSubTypeCommandProxi newCreateAtomicSubTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAtomicSubTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 188);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.getNextId();
        CreateAtomicSubTypeCommand result = new CreateAtomicSubTypeCommand(null,name,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicSubTypeCommandProxi)PersistentProxi.createProxi(id, 188);
    }
    
    public CreateAtomicSubTypeCommandProxi newDelayedCreateAtomicSubTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicSubTypeCommandFacade.getNextId();
        CreateAtomicSubTypeCommand result = new CreateAtomicSubTypeCommand(null,name,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicSubTypeCommandProxi)PersistentProxi.createProxi(id, 188);
    }
    
    public CreateAtomicSubTypeCommand getCreateAtomicSubTypeCommand(long CreateAtomicSubTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 188)) return 188;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void superTypeSet(long CreateAtomicSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateAtomicSubTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void singletonTypeSet(long CreateAtomicSubTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        
    }
    public void abstractTypeSet(long CreateAtomicSubTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAtomicSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAtomicSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void commandResultSet(long CreateAtomicSubTypeCommandId, PersistentMAtomicType commandResultVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAtomicSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

