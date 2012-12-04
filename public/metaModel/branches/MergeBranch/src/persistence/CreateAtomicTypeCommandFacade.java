package persistence;

import model.meta.*;

public class CreateAtomicTypeCommandFacade{

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

	

	public CreateAtomicTypeCommandFacade() {
	}

    public CreateAtomicTypeCommandProxi newCreateAtomicTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAtomicTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 140);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicTypeCommandFacade.getNextId();
        CreateAtomicTypeCommand result = new CreateAtomicTypeCommand(null,name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 140);
    }
    
    public CreateAtomicTypeCommandProxi newDelayedCreateAtomicTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicTypeCommandFacade.getNextId();
        CreateAtomicTypeCommand result = new CreateAtomicTypeCommand(null,name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 140);
    }
    
    public CreateAtomicTypeCommand getCreateAtomicTypeCommand(long CreateAtomicTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 140)) return 140;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void aspectSet(long CreateAtomicTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateAtomicTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void singletonTypeSet(long CreateAtomicTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        
    }
    public void abstractTypeSet(long CreateAtomicTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAtomicTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAtomicTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAtomicTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

