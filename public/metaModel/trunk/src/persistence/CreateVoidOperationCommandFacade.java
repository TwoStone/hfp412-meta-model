package persistence;

import model.meta.*;

public class CreateVoidOperationCommandFacade{

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

	

	public CreateVoidOperationCommandFacade() {
	}

    public CreateVoidOperationCommandProxi newCreateVoidOperationCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateVoidOperationCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 233);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateVoidOperationCommandFacade.getNextId();
        CreateVoidOperationCommand result = new CreateVoidOperationCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateVoidOperationCommandProxi)PersistentProxi.createProxi(id, 233);
    }
    
    public CreateVoidOperationCommandProxi newDelayedCreateVoidOperationCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateVoidOperationCommandFacade.getNextId();
        CreateVoidOperationCommand result = new CreateVoidOperationCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateVoidOperationCommandProxi)PersistentProxi.createProxi(id, 233);
    }
    
    public CreateVoidOperationCommand getCreateVoidOperationCommand(long CreateVoidOperationCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 233)) return 233;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void sourceSet(long CreateVoidOperationCommandId, PersistentMType sourceVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateVoidOperationCommandId, String nameVal) throws PersistenceException {
        
    }
    public long fpAdd(long CreateVoidOperationCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        return 0;
    }
    public void fpRem(long fpId) throws PersistenceException {
        
    }
    public FormalParameterList fpGet(long CreateVoidOperationCommandId) throws PersistenceException {
        return new FormalParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateVoidOperationCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateVoidOperationCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateVoidOperationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

