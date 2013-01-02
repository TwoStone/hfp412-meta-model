package persistence;

import model.meta.*;

public class AddToHierarchyCommandFacade{

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

	

	public AddToHierarchyCommandFacade() {
	}

    public AddToHierarchyCommandProxi newAddToHierarchyCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddToHierarchyCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 145);
        long id = ConnectionHandler.getTheConnectionHandler().theAddToHierarchyCommandFacade.getNextId();
        AddToHierarchyCommand result = new AddToHierarchyCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddToHierarchyCommandProxi)PersistentProxi.createProxi(id, 145);
    }
    
    public AddToHierarchyCommandProxi newDelayedAddToHierarchyCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddToHierarchyCommandFacade.getNextId();
        AddToHierarchyCommand result = new AddToHierarchyCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddToHierarchyCommandProxi)PersistentProxi.createProxi(id, 145);
    }
    
    public AddToHierarchyCommand getAddToHierarchyCommand(long AddToHierarchyCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 145)) return 145;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void associationSet(long AddToHierarchyCommandId, PersistentMAssociation associationVal) throws PersistenceException {
        
    }
    public void theHierarchySet(long AddToHierarchyCommandId, PersistentMAHierarchy theHierarchyVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddToHierarchyCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddToHierarchyCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddToHierarchyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

