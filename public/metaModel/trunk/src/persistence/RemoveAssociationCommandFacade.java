package persistence;

import model.meta.*;

public class RemoveAssociationCommandFacade{

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

	

	public RemoveAssociationCommandFacade() {
	}

    public RemoveAssociationCommandProxi newRemoveAssociationCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (RemoveAssociationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 162);
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveAssociationCommandFacade.getNextId();
        RemoveAssociationCommand result = new RemoveAssociationCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveAssociationCommandProxi)PersistentProxi.createProxi(id, 162);
    }
    
    public RemoveAssociationCommandProxi newDelayedRemoveAssociationCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theRemoveAssociationCommandFacade.getNextId();
        RemoveAssociationCommand result = new RemoveAssociationCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (RemoveAssociationCommandProxi)PersistentProxi.createProxi(id, 162);
    }
    
    public RemoveAssociationCommand getRemoveAssociationCommand(long RemoveAssociationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 162)) return 162;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void aSet(long RemoveAssociationCommandId, PersistentAssociation aVal) throws PersistenceException {
        
    }
    public void invokerSet(long RemoveAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long RemoveAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long RemoveAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

