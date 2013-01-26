package persistence;

import model.meta.*;

public class CreateHierarchyCommandFacade{

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

	

	public CreateHierarchyCommandFacade() {
	}

    public CreateHierarchyCommandProxi newCreateHierarchyCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateHierarchyCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 144);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateHierarchyCommandFacade.getNextId();
        CreateHierarchyCommand result = new CreateHierarchyCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateHierarchyCommandProxi)PersistentProxi.createProxi(id, 144);
    }
    
    public CreateHierarchyCommandProxi newDelayedCreateHierarchyCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateHierarchyCommandFacade.getNextId();
        CreateHierarchyCommand result = new CreateHierarchyCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateHierarchyCommandProxi)PersistentProxi.createProxi(id, 144);
    }
    
    public CreateHierarchyCommand getCreateHierarchyCommand(long CreateHierarchyCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 144)) return 144;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void aSet(long CreateHierarchyCommandId, PersistentAssociation aVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateHierarchyCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateHierarchyCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateHierarchyCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateHierarchyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

