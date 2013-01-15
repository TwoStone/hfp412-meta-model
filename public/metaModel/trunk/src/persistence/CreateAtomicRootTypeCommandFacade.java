package persistence;

import model.meta.*;

public class CreateAtomicRootTypeCommandFacade{

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

	

	public CreateAtomicRootTypeCommandFacade() {
	}

    public CreateAtomicRootTypeCommandProxi newCreateAtomicRootTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAtomicRootTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 191);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicRootTypeCommandFacade.getNextId();
        CreateAtomicRootTypeCommand result = new CreateAtomicRootTypeCommand(null,name,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicRootTypeCommandProxi)PersistentProxi.createProxi(id, 191);
    }
    
    public CreateAtomicRootTypeCommandProxi newDelayedCreateAtomicRootTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAtomicRootTypeCommandFacade.getNextId();
        CreateAtomicRootTypeCommand result = new CreateAtomicRootTypeCommand(null,name,null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAtomicRootTypeCommandProxi)PersistentProxi.createProxi(id, 191);
    }
    
    public CreateAtomicRootTypeCommand getCreateAtomicRootTypeCommand(long CreateAtomicRootTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 191)) return 191;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void aspectSet(long CreateAtomicRootTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateAtomicRootTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void singletonTypeSet(long CreateAtomicRootTypeCommandId, PersistentMBoolean singletonTypeVal) throws PersistenceException {
        
    }
    public void abstractTypeSet(long CreateAtomicRootTypeCommandId, PersistentMBoolean abstractTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAtomicRootTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAtomicRootTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void commandResultSet(long CreateAtomicRootTypeCommandId, PersistentMAtomicType commandResultVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAtomicRootTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

