package persistence;

import model.meta.*;

public class CreateAssociationCommandFacade{

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

	

	public CreateAssociationCommandFacade() {
	}

    public CreateAssociationCommandProxi newCreateAssociationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAssociationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 146);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.getNextId();
        CreateAssociationCommand result = new CreateAssociationCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAssociationCommandProxi)PersistentProxi.createProxi(id, 146);
    }
    
    public CreateAssociationCommandProxi newDelayedCreateAssociationCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.getNextId();
        CreateAssociationCommand result = new CreateAssociationCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAssociationCommandProxi)PersistentProxi.createProxi(id, 146);
    }
    
    public CreateAssociationCommand getCreateAssociationCommand(long CreateAssociationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 146)) return 146;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAssociationCommandId, String nameVal) throws PersistenceException {
        
    }
    public void sourceSet(long CreateAssociationCommandId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateAssociationCommandId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAssociationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAssociationCommandId, PersistentAssociationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAssociationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

