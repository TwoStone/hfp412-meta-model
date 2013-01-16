package persistence;

import model.meta.*;

public class CreateAccountTypeCommandFacade{

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

	

	public CreateAccountTypeCommandFacade() {
	}

    public CreateAccountTypeCommandProxi newCreateAccountTypeCommand(String name,long createMinusStorePlus) throws PersistenceException {
        if(createMinusStorePlus > 0) return (CreateAccountTypeCommandProxi)PersistentProxi.createProxi(createMinusStorePlus, 217);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountTypeCommandFacade.getNextId();
        CreateAccountTypeCommand result = new CreateAccountTypeCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAccountTypeCommandProxi)PersistentProxi.createProxi(id, 217);
    }
    
    public CreateAccountTypeCommandProxi newDelayedCreateAccountTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountTypeCommandFacade.getNextId();
        CreateAccountTypeCommand result = new CreateAccountTypeCommand(name,null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (CreateAccountTypeCommandProxi)PersistentProxi.createProxi(id, 217);
    }
    
    public CreateAccountTypeCommand getCreateAccountTypeCommand(long CreateAccountTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 217)) return 217;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAccountTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void typeSet(long CreateAccountTypeCommandId, PersistentMType typeVal) throws PersistenceException {
        
    }
    public void unitTypeSet(long CreateAccountTypeCommandId, PersistentUnitType unitTypeVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAccountTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAccountTypeCommandId, PersistentAccountTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAccountTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

