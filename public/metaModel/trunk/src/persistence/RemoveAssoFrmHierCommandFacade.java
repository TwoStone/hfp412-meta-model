package persistence;

import model.meta.*;

public class RemoveAssoFrmHierCommandFacade{

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

	

	public RemoveAssoFrmHierCommandFacade() {
	}

    public RemoveAssoFrmHierCommandProxi newRemoveAssoFrmHierCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveAssoFrmHierCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 110);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveAssoFrmHierCommandFacade.getNextId();
        RemoveAssoFrmHierCommand result = new RemoveAssoFrmHierCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveAssoFrmHierCommandProxi)PersistentProxi.createProxi(id, 110);
    }
    
    public RemoveAssoFrmHierCommandProxi newDelayedRemoveAssoFrmHierCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveAssoFrmHierCommandFacade.getNextId();
        RemoveAssoFrmHierCommand result = new RemoveAssoFrmHierCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveAssoFrmHierCommandProxi)PersistentProxi.createProxi(id, 110);
    }
    
    public RemoveAssoFrmHierCommand getRemoveAssoFrmHierCommand(long RemoveAssoFrmHierCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 110)) return 110;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void hSet(long RemoveAssoFrmHierCommandId, PersistentHierarchy hVal) throws PersistenceException {
        
    }
    public void aSet(long RemoveAssoFrmHierCommandId, PersistentAssociation aVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveAssoFrmHierCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveAssoFrmHierCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveAssoFrmHierCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

