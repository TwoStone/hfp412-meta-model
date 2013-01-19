package persistence;

import model.meta.*;

public class CreateVoidMessageCommandFacade{

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

	

	public CreateVoidMessageCommandFacade() {
	}

    public CreateVoidMessageCommandProxi newCreateVoidMessageCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateVoidMessageCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 240);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateVoidMessageCommandFacade.getNextId();
        CreateVoidMessageCommand result = new CreateVoidMessageCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateVoidMessageCommandProxi)PersistentProxi.createProxi(id, 240);
    }
    
    public CreateVoidMessageCommandProxi newDelayedCreateVoidMessageCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateVoidMessageCommandFacade.getNextId();
        CreateVoidMessageCommand result = new CreateVoidMessageCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateVoidMessageCommandProxi)PersistentProxi.createProxi(id, 240);
    }
    
    public CreateVoidMessageCommand getCreateVoidMessageCommand(long CreateVoidMessageCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 240)) return 240;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateVoidMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        
    }
    public void sourceSet(long CreateVoidMessageCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        
    }
    public long apAdd(long CreateVoidMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        return 0;
    }
    public void apRem(long apId) throws PersistenceException {
        
    }
    public ActualParameterList apGet(long CreateVoidMessageCommandId) throws PersistenceException {
        return new ActualParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateVoidMessageCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateVoidMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateVoidMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

