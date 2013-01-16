package persistence;

import model.meta.*;

public class CreateAccountCommandFacade{

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

	

	public CreateAccountCommandFacade() {
	}

    public CreateAccountCommandProxi newCreateAccountCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAccountCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 215);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountCommandFacade.getNextId();
        CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAccountCommandProxi)PersistentProxi.createProxi(id, 215);
    }
    
    public CreateAccountCommandProxi newDelayedCreateAccountCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountCommandFacade.getNextId();
        CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAccountCommandProxi)PersistentProxi.createProxi(id, 215);
    }
    
    public CreateAccountCommand getCreateAccountCommand(long CreateAccountCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 215)) return 215;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAccountCommandId, String nameVal) throws PersistenceException {
        
    }
    public void typeSet(long CreateAccountCommandId, PersistentMAccountType typeVal) throws PersistenceException {
        
    }
    public void objectSet(long CreateAccountCommandId, PersistentInstanceObject objectVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAccountCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAccountCommandId, PersistentAccountManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAccountCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

