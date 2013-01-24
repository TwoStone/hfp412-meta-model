package persistence;

import model.meta.*;

public class CreateConstCommandFacade{

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

	

	public CreateConstCommandFacade() {
	}

    public CreateConstCommandProxi newCreateConstCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateConstCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 174);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConstCommandFacade.getNextId();
        CreateConstCommand result = new CreateConstCommand(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConstCommandProxi)PersistentProxi.createProxi(id, 174);
    }
    
    public CreateConstCommandProxi newDelayedCreateConstCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateConstCommandFacade.getNextId();
        CreateConstCommand result = new CreateConstCommand(null,name,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateConstCommandProxi)PersistentProxi.createProxi(id, 174);
    }
    
    public CreateConstCommand getCreateConstCommand(long CreateConstCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 174)) return 174;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateConstCommandId, PersistentOperation typeVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateConstCommandId, String nameVal) throws PersistenceException {
        
    }
    public void targetSet(long CreateConstCommandId, PersistentInstanceObject targetVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateConstCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateConstCommandId, PersistentMessageManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateConstCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

