package persistence;

import model.meta.*;

public class CreateOperationCommandFacade{

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

	

	public CreateOperationCommandFacade() {
	}

    public CreateOperationCommandProxi newCreateOperationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateOperationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 243);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.getNextId();
        CreateOperationCommand result = new CreateOperationCommand(null,null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateOperationCommandProxi)PersistentProxi.createProxi(id, 243);
    }
    
    public CreateOperationCommandProxi newDelayedCreateOperationCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateOperationCommandFacade.getNextId();
        CreateOperationCommand result = new CreateOperationCommand(null,null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateOperationCommandProxi)PersistentProxi.createProxi(id, 243);
    }
    
    public CreateOperationCommand getCreateOperationCommand(long CreateOperationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 243)) return 243;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void sourceSet(long CreateOperationCommandId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateOperationCommandId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateOperationCommandId, String nameVal) throws PersistenceException {
        
    }
    public long fpAdd(long CreateOperationCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        return 0;
    }
    public void fpRem(long fpId) throws PersistenceException {
        
    }
    public FormalParameterList fpGet(long CreateOperationCommandId) throws PersistenceException {
        return new FormalParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateOperationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

