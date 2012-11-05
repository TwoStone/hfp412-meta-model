package persistence;

import model.meta.*;

public class AddAspectCommandFacade{

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

	

	public AddAspectCommandFacade() {
	}

    public AddAspectCommandProxi newAddAspectCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddAspectCommandFacade.getNextId();
        AddAspectCommand result = new AddAspectCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (AddAspectCommandProxi)PersistentProxi.createProxi(id, 125);
    }
    
    public AddAspectCommand getAddAspectCommand(long AddAspectCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 125)) return 125;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long AddAspectCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddAspectCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddAspectCommandId, PersistentAspectManager commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddAspectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        
    }

}

