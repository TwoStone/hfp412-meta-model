package persistence;

import model.meta.*;

public class CreateMessageCommandFacade{

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

	

	public CreateMessageCommandFacade() {
	}

    public CreateMessageCommandProxi newCreateMessageCommand(long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateMessageCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 144);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.getNextId();
        CreateMessageCommand result = new CreateMessageCommand(null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMessageCommandProxi)PersistentProxi.createProxi(id, 144);
    }
    
    public CreateMessageCommandProxi newDelayedCreateMessageCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateMessageCommandFacade.getNextId();
        CreateMessageCommand result = new CreateMessageCommand(null,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateMessageCommandProxi)PersistentProxi.createProxi(id, 144);
    }
    
    public CreateMessageCommand getCreateMessageCommand(long CreateMessageCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 144)) return 144;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        
    }
    public void sourceSet(long CreateMessageCommandId, PersistentInstanceObject sourceVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateMessageCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        
    }
    public long apAdd(long CreateMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        return 0;
    }
    public void apRem(long apId) throws PersistenceException {
        
    }
    public ActualParameterList apGet(long CreateMessageCommandId) throws PersistenceException {
        return new ActualParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateMessageCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

