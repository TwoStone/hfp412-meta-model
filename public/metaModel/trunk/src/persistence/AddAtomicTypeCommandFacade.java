package persistence;

import model.meta.*;

public class AddAtomicTypeCommandFacade{

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

	

	public AddAtomicTypeCommandFacade() {
	}

    public AddAtomicTypeCommandProxi newAddAtomicTypeCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddAtomicTypeCommandFacade.getNextId();
        AddAtomicTypeCommand result = new AddAtomicTypeCommand(null,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddAtomicTypeCommandProxi)PersistentProxi.createProxi(id, 122);
    }
    
    public AddAtomicTypeCommand getAddAtomicTypeCommand(long AddAtomicTypeCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 122)) return 122;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void aspectSet(long AddAtomicTypeCommandId, PersistentMAspect aspectVal) throws PersistenceException {
        
    }
    public void nameSet(long AddAtomicTypeCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddAtomicTypeCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddAtomicTypeCommandId, PersistentTypeManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddAtomicTypeCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

