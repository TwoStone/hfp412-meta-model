package persistence;

import model.meta.*;

public class CreateSubTypeCommandFacade{

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

	

	public CreateSubTypeCommandFacade() {
	}

    public CreateSubTypeCommandProxi newCreateSubTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateSubTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 135);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.getNextId();
        CreateSubTypeCommand result = new CreateSubTypeCommand(null,name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateSubTypeCommandProxi)PersistentProxi.createProxi(id, 135);
    }
    
    public CreateSubTypeCommandProxi newDelayedCreateSubTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.getNextId();
        CreateSubTypeCommand result = new CreateSubTypeCommand(null,name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateSubTypeCommandProxi)PersistentProxi.createProxi(id, 135);
    }
    
    public CreateSubTypeCommand getCreateSubTypeCommand(long CreateSubTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 135)) return 135;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void superTypeSet(long CreateSubTypeCommandId, PersistentMAtomicType superTypeVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateSubTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void singletonTypeSet(long CreateSubTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        
    }
    public void abstractTypeSet(long CreateSubTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateSubTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateSubTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateSubTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

