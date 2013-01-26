package persistence;

import model.meta.*;

public class CreateStaticMessageCommandFacade{

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

	

	public CreateStaticMessageCommandFacade() {
	}

    public CreateStaticMessageCommandProxi newCreateStaticMessageCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateStaticMessageCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 168);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade.getNextId();
        CreateStaticMessageCommand result = new CreateStaticMessageCommand(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateStaticMessageCommandProxi)PersistentProxi.createProxi(id, 168);
    }
    
    public CreateStaticMessageCommandProxi newDelayedCreateStaticMessageCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStaticMessageCommandFacade.getNextId();
        CreateStaticMessageCommand result = new CreateStaticMessageCommand(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateStaticMessageCommandProxi)PersistentProxi.createProxi(id, 168);
    }
    
    public CreateStaticMessageCommand getCreateStaticMessageCommand(long CreateStaticMessageCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 168)) return 168;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateStaticMessageCommandId, PersistentOperation typeVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateStaticMessageCommandId, String nameVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateStaticMessageCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        
    }
    public long apAdd(long CreateStaticMessageCommandId, PersistentActualParameter apVal) throws PersistenceException {
        return 0;
    }
    public void apRem(long apId) throws PersistenceException {
        
    }
    public ActualParameterList apGet(long CreateStaticMessageCommandId) throws PersistenceException {
        return new ActualParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateStaticMessageCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateStaticMessageCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateStaticMessageCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

