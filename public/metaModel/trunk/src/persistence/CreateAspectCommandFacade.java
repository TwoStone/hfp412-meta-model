package persistence;

import model.meta.*;

public class CreateAspectCommandFacade{

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

	

	public CreateAspectCommandFacade() {
	}

    public CreateAspectCommandProxi newCreateAspectCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAspectCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 139);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAspectCommandFacade.getNextId();
        CreateAspectCommand result = new CreateAspectCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAspectCommandProxi)PersistentProxi.createProxi(id, 139);
    }
    
    public CreateAspectCommandProxi newDelayedCreateAspectCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAspectCommandFacade.getNextId();
        CreateAspectCommand result = new CreateAspectCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAspectCommandProxi)PersistentProxi.createProxi(id, 139);
    }
    
    public CreateAspectCommand getCreateAspectCommand(long CreateAspectCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 139)) return 139;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAspectCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAspectCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAspectCommandId, PersistentAspectManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAspectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

