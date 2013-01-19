package persistence;

import model.meta.*;

public class AddAssociationCommandFacade{

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

	

	public AddAssociationCommandFacade() {
	}

    public AddAssociationCommandProxi newAddAssociationCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (AddAssociationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 173);
        long id = ConnectionHandler.getTheConnectionHandler().theAddAssociationCommandFacade.getNextId();
        AddAssociationCommand result = new AddAssociationCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddAssociationCommandProxi)PersistentProxi.createProxi(id, 173);
    }
    
    public AddAssociationCommandProxi newDelayedAddAssociationCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddAssociationCommandFacade.getNextId();
        AddAssociationCommand result = new AddAssociationCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddAssociationCommandProxi)PersistentProxi.createProxi(id, 173);
    }
    
    public AddAssociationCommand getAddAssociationCommand(long AddAssociationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 173)) return 173;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void hSet(long AddAssociationCommandId, PersistentHierarchy hVal) throws PersistenceException {
        
    }
    public void aSet(long AddAssociationCommandId, PersistentAssociation aVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

