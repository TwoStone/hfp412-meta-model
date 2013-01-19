package persistence;

import model.meta.*;

public class CreateStaticOpCommandFacade{

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

	

	public CreateStaticOpCommandFacade() {
	}

    public CreateStaticOpCommandProxi newCreateStaticOpCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateStaticOpCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 232);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStaticOpCommandFacade.getNextId();
        CreateStaticOpCommand result = new CreateStaticOpCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateStaticOpCommandProxi)PersistentProxi.createProxi(id, 232);
    }
    
    public CreateStaticOpCommandProxi newDelayedCreateStaticOpCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateStaticOpCommandFacade.getNextId();
        CreateStaticOpCommand result = new CreateStaticOpCommand(name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateStaticOpCommandProxi)PersistentProxi.createProxi(id, 232);
    }
    
    public CreateStaticOpCommand getCreateStaticOpCommand(long CreateStaticOpCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 232)) return 232;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateStaticOpCommandId, String nameVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateStaticOpCommandId, PersistentMType targetVal) throws PersistenceException {
        
    }
    public long fpAdd(long CreateStaticOpCommandId, PersistentFormalParameter fpVal) throws PersistenceException {
        return 0;
    }
    public void fpRem(long fpId) throws PersistenceException {
        
    }
    public FormalParameterList fpGet(long CreateStaticOpCommandId) throws PersistenceException {
        return new FormalParameterList(); // remote access for initialization only!
    }
    public void invokerSet(long CreateStaticOpCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateStaticOpCommandId, PersistentOperationManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateStaticOpCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

